val Http4sVersion                  = "1.0.0-M21"
val Specs2Version                  = "4.10.6"
val CatsEffectTestingSpecs2Version = "1.0.1"
val LogbackVersion                 = "1.2.3"

lazy val root = (project in file("."))
  .settings(
    organization := "edu.luc.etl",
    name := "primenumbers-http4s-scala",
    version := "0.0.3-SNAPSHOT",
    scalaVersion := "2.13.5",
    libraryDependencies ++= Seq(
      "org.http4s"    %% "http4s-blaze-server"        % Http4sVersion,
      "org.http4s"    %% "http4s-blaze-client"        % Http4sVersion,
      "org.http4s"    %% "http4s-dsl"                 % Http4sVersion,
      "org.http4s"    %% "http4s-scala-xml"           % Http4sVersion,
      "org.specs2"    %% "specs2-core"                % Specs2Version % Test,
      "org.typelevel" %% "cats-effect-testing-specs2" % CatsEffectTestingSpecs2Version % Test
    ),//.map(_.cross(CrossVersion.for3Use2_13)),
    libraryDependencies ++= Seq(
      "ch.qos.logback"  %  "logback-classic"     % LogbackVersion
    )
  )

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-language:higherKinds",
  "-language:postfixOps",
  "-feature",
  "-Xfatal-warnings",
)

coverageExcludedPackages := """.*\.Main;.*\.PrimeCheckerServer"""

enablePlugins(JavaAppPackaging)
