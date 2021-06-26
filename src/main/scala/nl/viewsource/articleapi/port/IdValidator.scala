package nl.viewsource.articleapi.port

trait IdValidator {
  def isValid(id:String): Boolean
}
