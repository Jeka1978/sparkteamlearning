package implcits_demo

/**
  * @author Evgeny Borisov
  */
case class Person(name:String) {
  def printMe():Unit={
    println(this)
  }

}
