![Scala CI](https://github.com/LoyolaChicagoCode/primenumbers-http4s-scala/workflows/Scala%20CI/badge.svg)
[![codecov](https://codecov.io/gh/LoyolaChicagoCode/primenumbers-http4s-scala/branch/master/graph/badge.svg)](https://codecov.io/gh/LoyolaChicagoCode/primenumbers-http4s-scala)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/20f5854f50c94a448968683ad33a687f)](https://www.codacy.com/gh/LoyolaChicagoCode/primenumbers-http4s-scala/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=LoyolaChicagoCode/primenumbers-http4s-scala&amp;utm_campaign=Badge_Grade)

[![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/LoyolaChicagoCode/primenumbers-http4s-scala.svg)](http://isitmaintained.com/project/LoyolaChicagoCode/primenumbers-http4s-scala "Average time to resolve an issue")
[![Percentage of issues still open](http://isitmaintained.com/badge/open/LoyolaChicagoCode/primenumbers-http4s-scala.svg)](http://isitmaintained.com/project/LoyolaChicagoCode/primenumbers-http4s-scala "Percentage of issues still open")


# Learning Objectives

- Show how CPU-intensive computation can be off-loaded from a mobile app to
  the cloud, by comparison to a mobile device, an unlimited resource for
  computation and storage.

- End-to-end example of continuous integration (CI), continuous
  deployment/delivery (CD), and DevOps in Scala.

See also the
[corresponding mobile app](https://github.com/LoyolaChicagoCode/primenumbers-android-scala).

# How to use

Test with

    $ sbt test

Run with

    $ sbt run

or

    $ sbt stage
	$ ./target/universal/stage/bin/primenumbers-http4s-scala

or deploy to a suitable APaaS provider, such as Heroku.

Then, http://host/n returns

- 200 OK if n is prime
- 404 Not Found otherwise

# Sample prime numbers to try

- [1013](http://laufer-primechecker.herokuapp.com/1013)
- [10007](http://laufer-primechecker.herokuapp.com/10007)
- [100003](http://laufer-primechecker.herokuapp.com/100003)
- [1000003](http://laufer-primechecker.herokuapp.com/1000003)
- [10000169](http://laufer-primechecker.herokuapp.com/10000169)
- [100000007](http://laufer-primechecker.herokuapp.com/100000007)

# Sample non-prime numbers to try

- [999989](http://laufer-primechecker.herokuapp.com/999989)

# References

- [Jason Christensen's OOPSLA 2009 presentation](http://www.slideshare.net/jasonc411/oopsla-2009-combining-rest-and-cloud-a-practitioners-report)
- [James Earl Douglas's SBTB 2014 presentation](https://www.youtube.com/watch?v=sZYAFWTyOlE)
- [James Earl Douglas's Scala CI/CD/DevOps example](https://github.com/earldouglas/scala-cd): Travis, Coveralls, and Heroku
