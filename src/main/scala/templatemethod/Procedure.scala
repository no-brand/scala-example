package templatemethod

import strategy._

trait Procedure {

  protected def in(args: List[String]): Unit
  protected def out(): Unit
  protected var parser: Parser

  def run(parser: Parser, args: List[String]): Unit = {
    this.parser = parser
    in(args)
    out()
  }
}

class One extends Procedure {

  override protected var parser: Parser = _
  private var options: Map[String, Any] = Map()

  override protected def in(args: List[String]): Unit = {
    options = parser.parse(args)
  }
  override protected def out(): Unit = {
    println(s"args: ${options}")
  }
}
