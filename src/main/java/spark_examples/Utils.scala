package spark_examples

import java.text.SimpleDateFormat
import java.util.Date

object Utils {
  def main(args: Array[String]): Unit = {
    val dateStr = "Sat Feb 20 12:00:06 IST 2016"
    val date = convertStringToDate(dateStr)
  }

  val DATE_FORMAT = "E MMM dd HH:mm:ss Z yyyy"

  def getDateAsString(d: Date): String = {
    val dateFormat = new SimpleDateFormat(DATE_FORMAT)
    dateFormat.format(d)
  }

  def convertStringToDate(s: String): Long = {
    val dateFormat = new SimpleDateFormat(DATE_FORMAT)
    dateFormat.parse(s).getTime
  }

}
