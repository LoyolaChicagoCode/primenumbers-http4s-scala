package edu.luc.etl.cs433.laufer.primenumbers

object PrimeChecker:
  def isPrime(i: BigInt): Boolean =
    if i < 2 then
      false
    else if i == 2 then
      true
    else if i % 2 == 0 then
      false
    else
      val sqroot = BigInt(Math.sqrt(i.toDouble).toLong)
      var k = BigInt(3)
      while k <= sqroot do
        if i % k == 0 then return false
        k += 2
      true
end PrimeChecker
