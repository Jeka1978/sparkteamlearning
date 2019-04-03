package spark_examples

import java.time.LocalDateTime

import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.catalyst.encoders.ExpressionEncoder
import org.apache.spark.sql.types.DataType
import org.apache.spark.sql.{Encoder, Encoders, SparkSession, functions}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author Evgeny Borisov
  */
object Main {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("taxi").setMaster("local")
    val sc: SparkContext = new SparkContext(conf)
    val sparkSession = SparkSession.builder.getOrCreate
    import sparkSession.implicits._

    val encoder: Encoder[Trip] = Encoders.product[Trip]
    val expEncoder = encoder.asInstanceOf[ExpressionEncoder[Trip]]

    val rdd = sc.textFile("files/taxi_orders.txt")
      .map(_.split(", "))
      .map(e => Trip(e(0), e(1), e(2).toInt, Utils.convertStringToDate(e(3))))



  }
}
