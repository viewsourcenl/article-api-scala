package nl.viewsource.articleapi.article.entity

import nl.viewsource.articleapi.port.EntityValidator.ValidationMessages
import nl.viewsource.articleapi.port.{EntityValidator, IdValidator, UrlValidator}

import scala.collection.mutable.ListBuffer

class ArticleValidator(val idValidator: IdValidator, val urlValidator: UrlValidator) extends EntityValidator[Article] {

  override def validate(article: Article): Either[ValidationMessages, Article] = {
    val messages = new ListBuffer[String]

    if (!idValidator.isValid(article.id)) messages += "Article must have a valid id"
    if (article.title == null || article.title.length < 3) messages += "Article title should be a minimal of 3 characters"
    if (article.description == null) messages += "Article must have a description"
    if (!urlValidator.isValid(article.link)) messages += "Article must have a valid link url"
    if (!urlValidator.isValid(article.image)) messages += "Article must have a valid image url"
    if (article.date == null) messages += "Article must have a date"

    if (messages.nonEmpty) Left(messages.toList) else Right(article)
  }

}
