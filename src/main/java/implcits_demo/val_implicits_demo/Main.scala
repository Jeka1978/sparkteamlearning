package implcits_demo.val_implicits_demo

/**
  * @author Evgeny Borisov
  */
object Main {
  def main(args: Array[String]): Unit = {
    implicit val x: Double = 10

    def printMe(implicit d:Double):Unit=println(d)

    printMe

  }
}
