val Http4sVersion                  = "1.0.0-M38"
val Http4sScalaXmlVersion          = Http4sVersion + ".1"
val Specs2Version                  = "5.0.7"
val CatsEffectTestingSpecs2Version = "1.7.0"
val LogbackVersion                 = "1.5.18"
val JAnsiVersion                   = "2.4.2"

lazy val root = (project in file("."))
  .settings(
    organization := "edu.luc.etl",
    name := "primenumbers-http4s-scala",
    version := "0.0.4-SNAPSHOT",
    scalaVersion := "3.7.3",
    libraryDependencies ++= Seq(
      "org.http4s"           %% "http4s-blaze-server"        % Http4sVersion,
      "org.http4s"           %% "http4s-blaze-client"        % Http4sVersion,
      "org.http4s"           %% "http4s-dsl"                 % Http4sVersion,
      "org.http4s"           %% "http4s-scala-xml"           % Http4sScalaXmlVersion,
      "ch.qos.logback"       %  "logback-classic"            % LogbackVersion,
      "org.fusesource.jansi" %  "jansi"                      % JAnsiVersion,
      "org.typelevel"        %% "cats-effect-testing-specs2" % CatsEffectTestingSpecs2Version % Test
    ),
    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-unchecked",
      "-Wvalue-discard",
      "-language:strictEquality",
      "-Yexplicit-nulls",
      "-Wsafe-init"
    )
  )

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

// Docker settings
Docker / packageName := "primenumbers-http4s-scala"
Docker / version := version.value
dockerUpdateLatest := true
dockerBaseImage := "eclipse-temurin:25-jre-jammy"
dockerBuildOptions += "--platform=linux/amd64"
dockerExposedPorts := Seq(8080)
dockerEnvVars := Map("PORT" -> "8080")
dockerUsername := sys.env.get("DOCKER_USERNAME")
