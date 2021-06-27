package nl.viewsource.articleapi.controller

import nl.viewsource.articleapi.article.entity.Article
import nl.viewsource.articleapi.article.usecase.{CreateArticle, FindArticle}
import nl.viewsource.articleapi.controller.model.ArticleWeb
import nl.viewsource.articleapi.port.EntityValidator.ValidationMessages

class ArticleController(val createArticleUsecase: CreateArticle, val findArticle: FindArticle) {

  def findArticleById(articleId: String): Option[Article] = findArticle.findById(articleId)

  def listArticles(): List[Article] = findArticle.findAllArticles()

  def createArticle(articleWeb: ArticleWeb): Either[ValidationMessages, Article] =
    createArticleUsecase.create(articleWeb.toArticle)

  def updateArticle(articleId: String, articleWeb: ArticleWeb): Option[Either[ValidationMessages, Article]] =
    createArticleUsecase.update(articleId, articleWeb.toArticle)

}
