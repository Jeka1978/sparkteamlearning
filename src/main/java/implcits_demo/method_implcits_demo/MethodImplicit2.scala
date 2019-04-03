package implcits_demo.method_implcits_demo

import implcits_demo.Person

/**
  * @author Evgeny Borisov
  */
object MethodImplicit2 {


  def main(args: Array[String]): Unit = {
    implicit def createPerson(name:String):Person={
      Person(name)
    }
    val p:Person="Yaroslav"   // if variable p will not be declared as Person, it will be String
    "Izimir".printMe()  //String doesn't have printMe method, so compiler will generate createPerson("Svyatoslav").printMe()
  }
}
