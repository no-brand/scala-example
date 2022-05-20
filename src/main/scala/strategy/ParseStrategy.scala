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

class ListSlidingParser extends ParseStrategy {
  override def parse(args: List[String]): Map[String, Any] = {
    val message = "\nUsage: command [--arg1 num] [--arg2 num]\n"
    if (args.isEmpty || args.size % 2 != 0) {
      println(message)
      return Map()
    }
    val options = Map.newBuilder[String, Any]
    args.sliding(2, 2).toList.collect {
      case List("--arg1", arg1: String) => options.addOne("arg1", arg1.toInt)
      case List("--arg2", arg2: String) => options.addOne("arg2", arg2.toInt)
    }
    options.result()
  }
}
