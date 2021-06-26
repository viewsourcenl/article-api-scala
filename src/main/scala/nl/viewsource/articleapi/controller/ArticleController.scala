package nl.viewsource.articleapi.controller

import nl.viewsource.articleapi.article.entity.{Article, ArticleValidationError}
import nl.viewsource.articleapi.article.usecase.{CreateArticle, FindArticle}
import nl.viewsource.articleapi.controller.model.ArticleWeb

class ArticleController(val createArticle: CreateArticle, val findArticle: FindArticle) {

  def findArticleById(articleId:String): Option[Article] = findArticle.findById(articleId)

  def listArticles(): List[Article] = findArticle.findAllArticles()

  def createArticle(articleWeb: ArticleWeb): Either[ArticleValidationError, Article] =
    createArticle.create(articleWeb.toArticle)

  def updateArticle(articleId: String, articleWeb: ArticleWeb): Option[Either[ArticleValidationError, Article]] =
    createArticle.update(articleId, articleWeb.toArticle)

}
