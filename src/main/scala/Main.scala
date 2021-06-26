
import nl.viewsource.articleapi.article.entity.Article

import java.util.Date

object Main extends App {

  val article = new Article(
    id = "articleId",
    hash = "",
    title="hallo",
    description = "een groet",
    link = "https://viewsource.nl/blog/articles/1",
    image = "https://viewsource.nl/blog/articles/1.png",
    tags = List("Linux", "Programming"),
    date = new Date(),
  )

  println("App Started")
  println("First article", article)
  val article2 = article.copy(title="Hello", description = "a greeting")

  println("Second article", article2)
}