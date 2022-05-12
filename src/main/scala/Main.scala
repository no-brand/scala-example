object Main extends App {

  def nextArgs(map: Map[String, Any], list: List[String]): Map[String, Any] = {
    list match {
      case Nil => map
      case "--arg1" :: v :: rest => nextArgs(map ++ Map("arg1" -> v.toInt), rest)
      case "--arg2" :: v :: rest => nextArgs(map ++ Map("arg2" -> v.toInt), rest)
      case _ :: rest => nextArgs(map, rest)
    }
  }

  val options = nextArgs(Map(), args.toList)
  if (args.length == 0 || options.size != 2) {
    println("\nUsage: command [--arg1 num] [--arg2 num]\n")
  }
  else {
    println(options)
  }
}
