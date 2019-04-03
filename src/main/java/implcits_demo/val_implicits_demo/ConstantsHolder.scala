package implcits_demo.val_implicits_demo

import implcits_demo.Person

/**
  * @author Evgeny Borisov
  */
object ConstantsHolder {
  implicit val defaultPerson:Person=Person(name = "Vsevolod")

}
