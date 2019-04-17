package interview

import org.apache.spark.sql.functions._

import scala.collection.mutable

/**
  * @author Evgeny Borisov
  */
object ExplodeExample {
  def main(args: Array[String]): Unit = {
    var dataFrame = SparkHolder.spark.read.json("files/data.json")

    val colAmount = dataFrame.head().getAs[mutable.WrappedArray.ofRef[String]]("f").size
    1.to(colAmount).foreach(i => {
      dataFrame = dataFrame.withColumn(s"F$i", col("f").getItem(i - 1))
    })
    dataFrame.drop("f").show()
  }
}
