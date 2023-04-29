package edu.luc.etl.cs433.laufer.primenumbers

import cats.effect.{ExitCode, IO, IOApp}
import org.http4s.blaze.server.BlazeServerBuilder
import scala.concurrent.ExecutionContext.global

val DEFAULT_PORT = "8080"

object Main extends IOApp:
  def run(args: List[String]): IO[ExitCode] =
    val port = sys.props.getOrElse("server.port", sys.env.getOrElse("PORT", DEFAULT_PORT)).toInt
    BlazeServerBuilder[IO]
      .bindHttp(port, "0.0.0.0")
      .withHttpApp(PrimeCheckerApp.app)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)
end Main
