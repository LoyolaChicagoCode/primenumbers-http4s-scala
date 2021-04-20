package edu.luc.etl.cs433.laufer.primenumbers

object PrimeChecker {
  def isPrime(i: BigInt): Boolean =
    if (i < 2)
      false
    else if (i == 2)
      true
    else if (i % 2 == 0)
      false
    else {
      val sqroot = BigInt(Math.sqrt(i.toDouble).toLong)
      var k = BigInt(3)
      while (k <= sqroot) {
        if (i % k == 0) return false
        k += 2
      }
      true
    }
}
