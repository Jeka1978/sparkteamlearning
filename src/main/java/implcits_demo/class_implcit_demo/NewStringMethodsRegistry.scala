package implcits_demo.class_implcit_demo

/**
  * @author Evgeny Borisov
  */
object NewStringMethodsRegistry {
  implicit def enrichString(string: String):RichString={
    new RichString(string)
  }

}
