package lab0

/**
  * @author Evgeny Borisov
  */
class Dog  extends Animal with Runnable with Comparable[Dog] {


  override def makeVoice(): Unit = {
    println("gav gav")
  }

  override val age: Int = 2

  override def run(): Unit = {

  }

  override def compareTo(o: Dog): Int = {
    1
  }
}
