package edu.luc.etl.cs433.laufer.primenumbers

import cats.effect.IO
import org.http4s._
import org.http4s.implicits._
import org.specs2.matcher.MatchResult

class PrimeCheckerSpec extends org.specs2.mutable.Specification {

  "PrimeChecker method" >> {
    "6007 is prime" >> {
      PrimeChecker.isPrime(6007) must beTrue
    }
    "6008 is not prime" >> {
      PrimeChecker.isPrime(6008) must beFalse
    }
    "6033 is not prime" >> {
      PrimeChecker.isPrime(6033) must beFalse
    }
  }

  "PrimeChecker service" >> {
    "6007 is prime" >> {
      uriReturns200(6007)
    }
    "6008 is not prime" >> {
      uriReturns404(6008)
    }
    "6033 is not prime" >> {
      uriReturns404(6033)
    }
  }

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