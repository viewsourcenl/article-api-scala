package nl.viewsource.articleapi.article.usecase.port

import nl.viewsource.articleapi.article.entity.Article

trait ArticleRepository {
  def create(article: Article): Article

  def findById(id: String): Option[Article]

  def findAllArticles(): List[Article]

  def replace(article: Article): Article
}
