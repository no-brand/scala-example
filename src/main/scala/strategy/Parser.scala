package strategy

class Parser(strategy: ParseStrategy) {
  def parse(args: List[String]): Map[String, Any] = {
    strategy.parse(args)
  }
}
