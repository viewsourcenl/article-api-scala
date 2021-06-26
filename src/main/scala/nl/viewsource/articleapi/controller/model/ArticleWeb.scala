package nl.viewsource.articleapi.controller.model

import nl.viewsource.articleapi.article.entity.Article

import java.text.SimpleDateFormat
import scala.runtime.Static

class ArticleWeb (
                    var id: String,
                    var hash: String,
                    var title: String,
                    var description: String,
                    var tags: List[String],
                    var link: String,
                    var image: String,
                    var date: String,
                  ) {

  def toArticle: Article = Article(
    id  = id,
    hash  = hash,
    title  = title,
    description  = description,
    tags  = tags,
    link  = link,
    image  = image,
    date  = sdf.parse(date)
  )

  @Static
  def toArticleWeb(article:Article): ArticleWeb = new ArticleWeb(
    id  = article.id,
    hash  = article.hash,
    title  = article.title,
    description  = article.description,
    tags  = article.tags,
    link  = article.link,
    image  = article.image,
    date  = sdf.format(article.date)
  )

  val sdf: SimpleDateFormat = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss.SSSXXX")
}
