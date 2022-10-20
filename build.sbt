val Http4sVersion                  = "1.0.0-M35"
val Specs2Version                  = "5.0.7"
val CatsEffectTestingSpecs2Version = "1.4.0"
val LogbackVersion                 = "1.2.11"

lazy val root = (project in file("."))
  .settings(
    organization := "edu.luc.etl",
    name := "primenumbers-http4s-scala",
    version := "0.0.3-SNAPSHOT",
    scalaVersion := "3.2.0",
    libraryDependencies ++= Seq(
      "org.http4s"     %% "http4s-blaze-server"        % Http4sVersion,
      "org.http4s"     %% "http4s-blaze-client"        % Http4sVersion,
      "org.http4s"     %% "http4s-dsl"                 % Http4sVersion,
      "org.http4s"     %% "http4s-scala-xml"           % Http4sVersion,
      "org.typelevel"  %% "cats-effect-testing-specs2" % CatsEffectTestingSpecs2Version % Test,
      "ch.qos.logback" %  "logback-classic"            % LogbackVersion
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

enablePlugins(JavaAppPackaging)
