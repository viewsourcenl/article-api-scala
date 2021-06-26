package nl.viewsource.articleapi.port

trait UrlValidator {
  def isValid(url:String):Boolean
}
