package nl.viewsource.articleapi.article.entity

case class ArticleValidationError(message: String, cause: Option[Throwable] = Option.empty)
