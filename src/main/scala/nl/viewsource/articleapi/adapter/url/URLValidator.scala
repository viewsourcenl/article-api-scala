package nl.viewsource.articleapi.adapter.url

import nl.viewsource.articleapi.port.UrlValidator

import java.net.URL

class URLValidator extends UrlValidator {
  override def isValid(url: String): Boolean = {
    try {
      new URL(url)
      true
    }  catch {
      case _: Throwable => false
    }
  }
}
