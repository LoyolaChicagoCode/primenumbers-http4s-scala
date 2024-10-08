val Http4sVersion                  = "1.0.0-M38"
val Http4sScalaXmlVersion          = Http4sVersion + ".1"
val Specs2Version                  = "5.0.7"
val CatsEffectTestingSpecs2Version = "1.5.0"
val LogbackVersion                 = "1.5.7"
val JAnsiVersion                   = "2.4.1"

lazy val root = (project in file("."))
  .settings(
    organization := "edu.luc.etl",
    name := "primenumbers-http4s-scala",
    version := "0.0.4-SNAPSHOT",
    scalaVersion := "3.3.3",
    libraryDependencies ++= Seq(
      "org.http4s"           %% "http4s-blaze-server"        % Http4sVersion,
      "org.http4s"           %% "http4s-blaze-client"        % Http4sVersion,
      "org.http4s"           %% "http4s-dsl"                 % Http4sVersion,
      "org.http4s"           %% "http4s-scala-xml"           % Http4sScalaXmlVersion,
      "ch.qos.logback"       %  "logback-classic"            % LogbackVersion,
      "org.fusesource.jansi" %  "jansi"                      % JAnsiVersion,
      "org.typelevel"        %% "cats-effect-testing-specs2" % CatsEffectTestingSpecs2Version % Test
    ),
    scalacOptions ++= Seq("@.scalacOptions.txt", "-Xfatal-warnings")
  )

assembly / mainClass := Some("edu.luc.etl.cs433.laufer.primenumbers.Main")

enablePlugins(JavaAppPackaging)

assembly / assemblyMergeStrategy := {
  case "module-info.class" => MergeStrategy.discard
  case manifest if manifest.contains("MANIFEST.MF") =>
    // We don't need manifest files since sbt-assembly will create
    // one with the given settings
    MergeStrategy.discard
  case referenceOverrides if referenceOverrides.contains("reference-overrides.conf") =>
    // Keep the content for all reference-overrides.conf files
    MergeStrategy.concat
  case x =>
    // For all the other files, use the default sbt-assembly merge strategy
    val oldStrategy = (assembly / assemblyMergeStrategy).value
    oldStrategy(x)
}

publishTo := Some(MavenCache("local-maven", file("maven-repo")))
