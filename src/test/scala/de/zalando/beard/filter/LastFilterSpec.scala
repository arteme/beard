package de.zalando.beard.filter

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

/**
 * @author Emiliano Busiello.
 */
class LastFilterSpec extends AnyFunSpec with Matchers {

  describe("LastFilterTest") {

    val filter = new LastFilter

    it("Should return the last letter/element") {
      filter.apply("Aaa") should be("a")
      filter.applyIterable(List("Aaa", "Bbb")) should be(List("Bbb"))
      filter.applyMap(Map(1 -> "Aaa", 2 -> "Bbb")) should be(Map("2" -> "Bbb"))
    }

    it("Should throw on empty collections") {
      intercept[NoSuchElementException] {
        filter.apply("")
      }
      intercept[IllegalArgumentException] {
        filter.applyIterable(List())
      }
      intercept[IllegalArgumentException] {
        filter.applyMap(Map())
      }
    }
  }
}
