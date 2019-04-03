package implcits_demo.val_implicits_demo

import implcits_demo.Person

/**
  * @author Evgeny Borisov
  */
object Main2 {
  import ConstantsHolder.defaultPerson

  def main(args: Array[String]): Unit = {
    printPerson(Person("Olga"))
    printPerson
  }

  def printPerson(implicit p:Person): Unit =println(p)
}
