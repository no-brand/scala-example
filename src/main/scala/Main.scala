import templatemethod._

object Main extends App {

  val procedure: Procedure = new One
  procedure.run(args.toList)

}
