package templatemethod

import org.scalatest.FunSuite
import strategy._
import templatemethod._

class ProcedureSuite extends FunSuite {

  test("pattern-matching parser") {
    val args = List("--arg1", "10", "--arg2", "20")
    val procedure: Procedure = new One
    procedure.run(parser = new Parser(new PatternMatchParser()), args = args)
  }

  test("pattern-matching parser abnormal") {
    val args = List("--arg1", "abnormal", "--arg2", "20")
    val procedure: Procedure = new One
    assertThrows[NumberFormatException] {
      procedure.run(parser = new Parser(new PatternMatchParser()), args = args)
    }
  }

  test("list-sliding parser") {
    val args = List("--arg1", "10", "--arg2", "20")
    val procedure: Procedure = new One
    procedure.run(parser = new Parser(new ListSlidingParser()), args = args)
  }

  test("list-sliding parser abnormal") {
    val args = List("--arg1", "abnormal", "--arg2", "20")
    val procedure: Procedure = new One
    assertThrows[NumberFormatException] {
      procedure.run(parser = new Parser(new ListSlidingParser()), args = args)
    }
  }
}
