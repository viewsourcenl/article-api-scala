package nl.viewsource.articleapi.article.usecase

import nl.viewsource.articleapi.article.entity.Article
import nl.viewsource.articleapi.article.usecase.port.ArticleRepository

class FindArticle(articleRepository: ArticleRepository) {
  def findById(id:String): Option[Article] = articleRepository.findById(id)
  def findAllArticles(): List[Article] = articleRepository.findAllArticles()
}
