package nl.viewsource.articleapi.article.usecase

import nl.viewsource.articleapi.article.entity.Article
import nl.viewsource.articleapi.article.usecase.port.ArticleRepository
import nl.viewsource.articleapi.port.EntityValidator.ValidationMessages
import nl.viewsource.articleapi.port.{EntityValidator, IdGenerator}

class CreateArticle(val articleRepository: ArticleRepository, val idGenerator: IdGenerator, val articleValidator: EntityValidator[Article]) {

  def create(article:Article): Either[ValidationMessages, Article] =
    articleValidator
      .validate(article.copy(id=idGenerator.generate()))
      .map(articleRepository.create)

  def update(articleId:String, article: Article): Option[Either[ValidationMessages, Article]] =
    articleRepository
      .findById(articleId)
      .map(foundArticle => article.copy(id=foundArticle.id))
      .map(articleValidator.validate)
      .map(_.map(articleRepository.replace))
}
