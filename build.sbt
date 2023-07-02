name := "beard"
organization := "de.zalando"
version := "0.3.2-SNAPSHOT"
licenses += ("Apache-2.0", url("http://www.apache.org/licenses/"))

scalaVersion := "2.13.10"
scalacOptions := Seq("-unchecked", "-feature", "-deprecation", "-encoding", "utf8")

val antlrVersion = "4.8-1"

crossScalaVersions := Seq(scalaVersion.value, "2.12.17")

enablePlugins(Antlr4Plugin)

Antlr4 / antlr4GenListener := true

Antlr4 / antlr4GenVisitor := true

Antlr4 / antlr4Version := antlrVersion

Antlr4 / antlr4Dependency := "org.antlr" % "antlr4" % antlrVersion

Antlr4 / antlr4PackageName := Some("de.zalando.beard")

libraryDependencies ++= {
  Seq(
    "org.antlr" % "antlr4" % antlrVersion
    exclude ("org.antlr", "ST4")
    exclude ("org.antlr", "antlr-runtime"),
    "org.scala-lang"                    % "scala-reflect"   % scalaVersion.value,
    "org.scala-lang.modules"           %% "scala-xml"       % "1.3.0",
    "org.slf4j"                         % "slf4j-api"       % "1.7.30",
    "ch.qos.logback"                    % "logback-classic" % "1.1.11",
    "org.scalatest"                    %% "scalatest"       % "3.1.1"  % "test",
    "io.pebbletemplates"                % "pebble"          % "3.0.10" % "test",
    "org.freemarker"                    % "freemarker"      % "2.3.28" % "test",
    "com.github.spullara.mustache.java" % "compiler"        % "0.9.6"  % "test",
    "com.github.jknack"                 % "handlebars"      % "4.1.2"  % "test",
    "de.neuland-bfi"                    % "jade4j"          % "1.2.7"  % "test",
    "com.storm-enroute"                %% "scalameter"      % "0.19"   % "test"
  )
}

logBuffered := false
Test / parallelExecution := false
// testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")
