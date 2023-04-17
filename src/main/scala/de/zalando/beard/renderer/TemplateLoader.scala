package de.zalando.beard.renderer

import org.slf4j.LoggerFactory
import scala.io.Source
import scala.util.{ Failure, Success, Try }

/**
  * @author dpersa
  */
trait TemplateLoader {

  def load(templateName: TemplateName): Try[String]
}

class ClasspathTemplateLoader(val templatePrefix: String = "", val templateSuffix: String = "") extends TemplateLoader {

  private val logger = LoggerFactory.getLogger(this.getClass)

  override def load(templateName: TemplateName): Try[String] = {
    val path = s"$templatePrefix${templateName.name}$templateSuffix"

    logger.debug(s"Looking for template with path: $path")

    Try(getClass.getResourceAsStream(path))
      .map(Source.fromInputStream)
      .map(_.mkString)
      .fold(
        _ =>
          Failure(
            new TemplateLoadException(
              s"Expected to find template '${templateName.name}' in file '$path', file not found on classpath"
            )
          ),
        src => Success(src)
      )
  }
}

class FileTemplateLoader(
    val directoryPath: String,
    val templateSuffix: String = ""
) extends TemplateLoader {

  override def load(templateName: TemplateName): Try[String] = {
    val path = s"$directoryPath/${templateName.name}$templateSuffix"
    Try(Source.fromFile(path)).fold(_ =>
      Failure(
        new TemplateLoadException(
          s"Expected to find template '${templateName.name}' in file '$path', file not found"
        )
      ), b => Success(b.mkString))
  }
}

class TemplateLoadException(msg: String) extends Exception(msg) {}
