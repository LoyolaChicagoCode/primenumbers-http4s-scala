package edu.luc.etl.cs433.laufer.primenumbers

import cats.Applicative
import cats.implicits._

trait PrimeChecker[F[_]]{
  def check(n: BigInt): F[Boolean]
}

object PrimeChecker {
  implicit def apply[F[_]](implicit ev: PrimeChecker[F]): PrimeChecker[F] = ev

  def impl[F[_]: Applicative]: PrimeChecker[F] = (i: BigInt) => isPrime(i).pure[F]

  def isPrime(i: BigInt): Boolean =
    if (i < 2)
      false
    else if (i == 2)
      true
    else if (i % 2 == 0)
      false
    else {
      val half = BigInt(Math.sqrt(i.toDouble).toLong)
      var k = BigInt(3)
      while (k <= half) {
        if (i % k == 0) return false
        k += 2
      }
      true
    }
}
