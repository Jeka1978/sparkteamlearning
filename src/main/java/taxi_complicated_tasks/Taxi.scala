package taxi_complicated_tasks

/**
  * @author Evgeny Borisov
  */
import java.time.{LocalDateTime, ZonedDateTime, ZoneOffset}
import java.time.format.DateTimeFormatter
import java.util.Locale
import org.apache.spark.sql._
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

object Taxi {
  def main(args: Array[String]): Unit = {
    Locale.setDefault(Locale.UK)
    val spark = SparkSession.builder().appName("taxi").master("local[*]").getOrCreate()

    try {
      impl(spark)
    } finally {
      spark.stop()
    }
  }

  private def impl(spark: SparkSession): Unit = {
    import spark.implicits._
    val DistanceThresholdKm: Long = 10

    val schema = StructType(Seq(
      StructField("driverId", LongType, nullable = false),
      StructField("city", StringType, nullable = false),
      StructField("distanceKm", LongType, nullable = false),
      StructField("datetime", StringType, nullable = false)
    ))


    val parseDateTime = udf[Long, String] { str =>
      val dateFormat = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss z yyyy")
      val dt = ZonedDateTime.parse(str.trim(), dateFormat)
      dt.toInstant.toEpochMilli
    }

    val trips = spark.read
      .schema(schema)
      .csv("files/taxi_orders.txt")
      .withColumn("datetime", parseDateTime($"datetime"))
      .withColumn("covered_distance",
        sum($"distanceKm") over
          Window
            .partitionBy($"driverId")
            .orderBy($"datetime")
            .rowsBetween(Window.currentRow, 1)
      )
      .where($"covered_distance" > lit(DistanceThresholdKm * 2))
      .select($"driverId")
      .distinct()

    trips.show()

  }
  case class Trip(driverId: Long,
                  city: String,
                  distanceKm: Long,
                  datetime: Long)
}