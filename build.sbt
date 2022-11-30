val Http4sVersion                  = "1.0.0-M35"
val Specs2Version                  = "5.0.7"
val CatsEffectTestingSpecs2Version = "1.5.0"
val LogbackVersion                 = "1.4.5"
val JAnsiVersion                   = "1.18"

lazy val root = (project in file("."))
  .settings(
    organization := "edu.luc.etl",
    name := "primenumbers-http4s-scala",
    version := "0.0.4-SNAPSHOT",
    scalaVersion := "3.2.1",
    libraryDependencies ++= Seq(
      "org.http4s"           %% "http4s-blaze-server"        % Http4sVersion,
      "org.http4s"           %% "http4s-blaze-client"        % Http4sVersion,
      "org.http4s"           %% "http4s-dsl"                 % Http4sVersion,
      "org.http4s"           %% "http4s-scala-xml"           % Http4sVersion,
      "ch.qos.logback"       %  "logback-classic"            % LogbackVersion,
      "org.fusesource.jansi" %  "jansi"                      % JAnsiVersion,
      "org.typelevel"        %% "cats-effect-testing-specs2" % CatsEffectTestingSpecs2Version % Test
    )
  )

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Yexplicit-nulls",
  "-Ysafe-init",
  "-language:strictEquality",
  "-Xfatal-warnings",
)

coverageExcludedPackages := """.*\.Main;.*\.PrimeCheckerServer"""

assembly / mainClass := Some("play.core.server.ProdServerStart")

enablePlugins(JavaAppPackaging)
