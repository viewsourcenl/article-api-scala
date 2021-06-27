package nl.viewsource.articleapi.port

import nl.viewsource.articleapi.port.EntityValidator.ValidationMessages

trait EntityValidator[A] {
  def validate(entity:A): Either[ValidationMessages, A]
}
object EntityValidator {
  type ValidationMessages = List[String]
}
