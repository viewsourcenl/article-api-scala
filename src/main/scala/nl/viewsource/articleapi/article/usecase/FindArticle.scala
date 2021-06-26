package nl.viewsource.articleapi.article.usecase

import nl.viewsource.articleapi.article.entity.Article
import nl.viewsource.articleapi.article.usecase.port.ArticleRepository
import nl.viewsource.articleapi.port.IdGenerator

class FindArticle(articleRepository: ArticleRepository, idGenerator: IdGenerator) {
  def findById(id:String): Option[Article] = articleRepository.findById(id)
  def findAllArticles(): List[Article] = articleRepository.findAllArticles()
}
