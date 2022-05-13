import strategy._

object Main extends App {

  val parser = new Parser(new PatternMatchParser())
  val options = parser.parse(args.toList)
  println(s"args: ${options}")

}
