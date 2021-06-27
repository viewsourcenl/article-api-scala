
import nl.viewsource.articleapi.adapter.id.UuidGenerator
import nl.viewsource.articleapi.adapter.url.URLValidator
import nl.viewsource.articleapi.article.entity.Article
import nl.viewsource.articleapi.article.entity.ArticleValidator

import java.util.Date

object Main extends App {
  println("App Started")

  val idGenerator = new UuidGenerator
  val validator = new ArticleValidator(
    idValidator = idGenerator,
    urlValidator = new URLValidator
  )


  val article1 = Article(
    id = idGenerator.generate(),
    hash = "",
    title = "hallo",
    description = "een groet",
    link = "https://viewsource.nl/blog/articles/1",
    image = "https://viewsource.nl/blog/articles/1.png",
    tags = List("Linux", "Programming"),
    date = new Date(),
  )
  println("First article", validator.validate(article1))

  val article2 = article1.copy(id=idGenerator.generate(), title = "Hello", description = "a greeting")
  println("Second article", validator.validate(article2))

  val article3 = Article(
    id = null,
    hash = null,
    title = "Geen Groeten",
    description = null,
    link = null,
    image = null,
    tags = null,
    date = null,
  )
  println("Third article", validator.validate(article3))

}