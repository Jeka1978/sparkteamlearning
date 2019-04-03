package implcits_demo.method_implcits_demo.implcit_method_import_demo

import implcits_demo.Person

/**
  * @author Evgeny Borisov
  */
object Convertions {
  implicit def convert(name:String):Person=Person(name)
}
