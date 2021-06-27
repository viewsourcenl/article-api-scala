package nl.viewsource.articleapi.article.entity

import nl.viewsource.articleapi.article.entity.Article.{Tag, Url}

import java.util.Date


case class Article(
                    id: String,
                    hash: String,
                    title: String,
                    description: String,
                    tags: List[Tag],
                    link: Url,
                    image: Url,
                    date: Date
                  )

object Article {
  type Tag = String
  type Url = String
}
