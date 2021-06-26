package nl.viewsource.articleapi.article.entity

import java.util.Date

case class Article(
                    val id: String,
                    val hash: String,
                    val title: String,
                    val description: String,
                    val tags: List[String],
                    val link: String,
                    val image: String,
                    val date: Date
                  )
