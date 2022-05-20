import strategy.{ListSlidingParser, Parser, PatternMatchParser}
import templatemethod._

object Main extends App {

  var procedure: Procedure = _

  procedure = new One
  procedure.run(parser = new Parser(new PatternMatchParser()), args = args.toList)
  procedure.run(parser = new Parser(new ListSlidingParser()), args = args.toList)

}
