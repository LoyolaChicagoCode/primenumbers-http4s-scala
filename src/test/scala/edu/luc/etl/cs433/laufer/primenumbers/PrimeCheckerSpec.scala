package edu.luc.etl.cs433.laufer.primenumbers

import cats.effect.IO
import org.http4s._
import org.http4s.implicits._
import org.specs2.mutable.Specification
import org.specs2.matcher.{DataTables, MatchResult}

class PrimeCheckerSpec extends Specification with DataTables {

  "PrimeChecker method works for values in table" >> {
    primeTable |> {
      (number, result) => PrimeChecker.isPrime(BigInt(number)) must_== result
    }
  }

  "PrimeChecker service works for values in table" >> {
    primeTable |> {
      (number, result) =>
        if (result) uriReturns200(number) else uriReturns404(number)
    }
  }

  private[this] val primeTable =
    "number" | "result" |
      -7 ! false |
      -1 ! false |
      0 ! false |
      1 ! false |
      2 ! true |
      3 ! true |
      4 ! false |
      5 ! true |
      6 ! false |
      7 ! true |
      8 ! false |
      9 ! false |
      10 ! false |
      1013 ! true |
      1014 ! false |
      6006 ! false |
      6007 ! true |
      6033 ! false |
      10007 ! true |
      10077 ! false |
      100003 ! true |
      100033 ! false |
      1000003 ! true |
      1000013 ! false |
      10000169 ! true |
      10001169 ! false |
      100000007 ! true |
      100000077 ! false

  private[this] def retPrimeChecker(i: Int): Response[IO] = {
    val getHW = Request[IO](Method.GET, uri"/" / s"$i")
    val primeChecker = PrimeChecker.impl[IO]
    PrimeCheckerRoutes.primeCheckerRoutes(primeChecker).orNotFound(getHW).unsafeRunSync()
  }

  private[this] def uriReturns200(i: Int): MatchResult[Status] =
    retPrimeChecker(i).status must beEqualTo(Status.Ok)

  private[this] def uriReturns404(i: Int): MatchResult[Status] =
    retPrimeChecker(i).status must beEqualTo(Status.NotFound)
}