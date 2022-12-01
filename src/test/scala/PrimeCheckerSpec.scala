package edu.luc.etl.cs433.laufer.primenumbers

import cats.effect.IO
import cats.effect.testing.specs2.CatsEffect
import cats.effect.unsafe.implicits.global
import org.http4s.{Method, Request, Response, Status}
import org.http4s.implicits.*
import org.specs2.mutable.Specification
import org.specs2.matcher.{DataTables, MatchResult}

class PrimeCheckerSpec extends Specification with DataTables with CatsEffect:

  "PrimeChecker method works for values in table" >> {
    primeTable |> {
      (number, result) => PrimeChecker.isPrime(BigInt(number)) must_== result
    }
  }

  "PrimeChecker service works for values in table" >> {
    primeTable |> {
      (number, result) =>
        serviceReturnsStatus(number, if result then Status.Ok else Status.NotFound)
    }
  }

  private[this] lazy val primeTable =
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

  private[this] def retPrimeChecker(i: Int): Response[IO] =
    val getPC = Request[IO](Method.GET, uri"/" / s"$i")
    PrimeCheckerApp.app(getPC).unsafeRunSync()

  private[this] def serviceReturnsStatus(i: Int, s: Status): MatchResult[Status] =
    retPrimeChecker(i).status must beEqualTo(s)

end PrimeCheckerSpec
