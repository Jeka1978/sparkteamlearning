package implcits_demo.class_implcit_demo

/**
  * @author Evgeny Borisov
  */
class RichString(s: String) {
  def isBlank: Boolean = {
    s==null || s.isEmpty
  }
  def isEmail: Boolean = {
    !isBlank && s.contains("@")
  }
}
