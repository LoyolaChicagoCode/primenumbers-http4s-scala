package edu.luc.etl.cs433.laufer.primenumbers

import cats.effect.{ExitCode, IO, IOApp}
import org.http4s.blaze.server.BlazeServerBuilder
import scala.concurrent.ExecutionContext.global

object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] =
    BlazeServerBuilder[IO](global)
      .bindHttp(8080, "localhost")
      .withHttpApp(PrimeCheckerApp.app)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)
}
