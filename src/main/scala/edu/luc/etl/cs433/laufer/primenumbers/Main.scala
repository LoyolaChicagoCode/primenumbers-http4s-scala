package edu.luc.etl.cs433.laufer.primenumbers

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  def run(args: List[String]) =
    PrimeCheckerServer.stream[IO].compile.drain.as(ExitCode.Success)
}