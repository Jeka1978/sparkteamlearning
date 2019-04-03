package implcits_demo.class_implcit_demo

/**
  * @author Evgeny Borisov
  */
object Main {

  import NewStringMethodsRegistry._

  def main(args: Array[String]): Unit = {
    println("".isBlank)
    println("".isEmail)
    val s:String=null
    println(s.isEmail)
    println(s.isBlank)
    println("asds@sfs".isEmail)

  }

}
