package nl.viewsource.articleapi.adapter.id

import nl.viewsource.articleapi.port.{IdGenerator, IdValidator}

import java.util.UUID

class UuidGenerator extends IdGenerator with IdValidator{
  override def generate(): String = UUID.randomUUID().toString

  override def isValid(id: String): Boolean = {
    try {
      UUID.fromString(id).toString.equals(id)
    } catch {
      case _: Throwable => false
    }
  }
}
