package interview

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author Evgeny Borisov
  */
object SparkHolder {

  val spark = SparkSession
    .builder()
    .master("local[*]")
    .appName("interview")
    .getOrCreate()
}
