package de.zalando.beard.ast

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

/**
 * @author dpersa
 */
class NewLineSpec extends AnyFunSpec with Matchers {

  it("should return the right text") {
    NewLine(3).text should be("\n\n\n")
    NewLine(1).text should be("\n")
  }
}
