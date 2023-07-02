package de.zalando.beard.ast

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

/**
 * @author rweyand
 */
class WhiteSpec extends AnyFunSpec with Matchers {
  it("should return the right text") {
    White(3).text should be("   ")
    White(1).text should be(" ")
  }
}
