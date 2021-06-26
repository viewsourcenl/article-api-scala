package nl.viewsource.articleapi.article.entity

import nl.viewsource.articleapi.port.{IdValidator, UrlValidator}

class  ArticleValidator(val idValidator: IdValidator, val urlValidator: UrlValidator) {
  def validate(article: Article):Either[ArticleValidationError, Article] = {
    if (!idValidator.isValid(article.id)) msg("Article must have a valid id")
    if (article.title == null) msg("Article must have a title")
    if (article.title.length < 3) msg("Article title should be a minimal of 3 characters")
    if (article.description == null) msg("Article must have a description")
    if (article.link == null) msg("Article must have a link")
    if (!urlValidator.isValid(article.link)) msg("Article must have a valid link")
    if (article.image == null) msg("Article must have an image")
    if (!urlValidator.isValid(article.image)) msg("Article must have a valid image url")
    if (article.date == null) msg("Article must have a date")

    Right(article)
  }

  private def msg(message: String):Either[ArticleValidationError, Article] = Left(ArticleValidationError(message))
}
