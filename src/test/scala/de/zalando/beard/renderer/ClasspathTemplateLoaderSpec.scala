package de.zalando.beard.renderer

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import scala.util.{Success, Failure, Try}

/**
 * @author dpersa
 */
class ClasspathTemplateLoaderSpec extends AnyFunSpec with Matchers {

  describe("simple loader") {

    val loader = new ClasspathTemplateLoader()

    it("should load the template") {
      val template = loader.load(TemplateName("/loader/dir/template.beard"))
      template.isSuccess.should(be(true))
    }

    describe("template doesn't exist") {
      it("should not load anything") {
        val template = loader.load(TemplateName("/does/not/exist"))
        template.isSuccess.should(be(false))
      }
    }
  }

  describe("loader with prefix and suffix") {

    val loader = new ClasspathTemplateLoader(templatePrefix = "/loader/", templateSuffix = ".beard")

    it("should load the template") {
      val template = loader.load(TemplateName("dir/template"))
      template.isSuccess.should(be(true))
    }
  }
}

