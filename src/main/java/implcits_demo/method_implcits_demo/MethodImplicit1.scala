package implcits_demo.method_implcits_demo

import implcits_demo.Person

/**
  * @author Evgeny Borisov
  */
object MethodImplicit1 {

  implicit def createPerson(name:String):Person={
    Person(name)
  }

  def main(args: Array[String]): Unit = {
    val p:Person="Oleg"   // if variable p will not be declared as Person, it will be String

    "Svyatoslav".printMe()  //String doesn't have printMe method, so compiler will generate createPerson("Svyatoslav").printMe()
  }
}
