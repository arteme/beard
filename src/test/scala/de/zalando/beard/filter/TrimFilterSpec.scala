package de.zalando.beard.filter

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

/**
 * @author Emiliano Busiello.
 */
class TrimFilterSpec extends AnyFunSpec with Matchers {
  describe("TrimFilterTest") {

    val filter = new TrimFilter

    it("Should return the trimmed value") {
      filter.apply("  Aaa ") should be("Aaa")
      filter.applyIterable(List("Aaa  ", "  Bbb")) should be(List("Aaa", "Bbb"))
      filter.applyMap(Map(1 -> "  Aaa", 2 -> "  Bbb")) should be(Map("1" -> "Aaa", "2" -> "Bbb"))
    }
  }
}
