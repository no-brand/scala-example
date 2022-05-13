package strategy

trait ParseStrategy {
  def parse(args: List[String]): Map[String, Any]
}

class PatternMatchParser extends ParseStrategy {
  private def nextArgs(map: Map[String, Any], list: List[String]): Map[String, Any] = {
    list match {
      case Nil => map
      case "--arg1" :: v :: rest => nextArgs(map ++ Map("arg1" -> v.toInt), rest)
      case "--arg2" :: v :: rest => nextArgs(map ++ Map("arg2" -> v.toInt), rest)
      case _ :: rest => nextArgs(map, rest)
    }
  }
  override def parse(args: List[String]): Map[String, Any] = {
    val message = "\nUsage: command [--arg1 num] [--arg2 num]\n"
    val options = nextArgs(Map(), args)
    if (args.isEmpty || options.size != 2) {
      println(message)
    }
    options
  }
}
