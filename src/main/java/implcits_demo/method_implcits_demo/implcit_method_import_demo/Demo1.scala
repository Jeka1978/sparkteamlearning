package implcits_demo.method_implcits_demo.implcit_method_import_demo

import implcits_demo.Person

/**
  * @author Evgeny Borisov
  */
object Demo1 {
  import Convertions._  //could be also Convertions.convert
  def main(args: Array[String]): Unit = {
    val p:Person="Vladimir"  // if variable p will not be declared as Person, it will be String
    println(p)
    "Svyatoslav".printMe()  //String doesn't have printMe method, so compiler will generate createPerson("Svyatoslav").printMe()
  }
}
