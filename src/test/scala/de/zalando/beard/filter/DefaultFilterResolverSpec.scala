package de.zalando.beard.filter

import org.scalatest.funspec.AnyFunSpec
import org.slf4j.LoggerFactory

/**
 * @author dpersa
 */
class DefaultFilterResolverSpec extends AnyFunSpec {

  val logger = LoggerFactory.getLogger(this.getClass)

  describe("DefaultFilterResolverTest") {

    it("should resolve") {
      logger.info("start")
      DefaultFilterResolver().resolve("currency", Set("symbol"))
    }
  }
}
