package templatemethod

import strategy._

trait Procedure {

  protected def in(args: List[String]): Unit
  protected def out(): Unit

  def run(args: List[String]): Unit = {
    in(args)
    out()
  }
}

class One extends Procedure {

  private var options: Map[String, Any] = Map()

  override protected def in(args: List[String]): Unit = {
    val parser = new Parser(new PatternMatchParser())
    options = parser.parse(args)
  }
  override protected def out(): Unit = {
    println(s"args: ${options}")
  }
}
