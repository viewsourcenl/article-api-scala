package nl.viewsource.articleapi.article.usecase

import nl.viewsource.articleapi.article.entity.{Article, ArticleValidationError, ArticleValidator}
import nl.viewsource.articleapi.article.usecase.port.ArticleRepository
import nl.viewsource.articleapi.port.IdGenerator

class CreateArticle(val articleRepository: ArticleRepository, val idGenerator: IdGenerator, val articleValidator: ArticleValidator) {

 def option2Either (option:Option[Article]): Either[ArticleValidationError, Article] = {
   if (option.isDefined)
     Right(option.get)
   else
     Left(ArticleValidationError("not found"))
 }

  def create(article:Article):Either[ArticleValidationError, Article] =
    articleValidator
      .validate(article.copy(id=idGenerator.generate()))
      .map(articleRepository.create)

  def update(articleId:String, article: Article): Option[Either[ArticleValidationError, Article]] =
    articleRepository
      .findById(articleId)
      .map(foundArticle => article.copy(id=foundArticle.id))
      .map(articleValidator.validate)
      .map(_.map(articleRepository.replace))
}
