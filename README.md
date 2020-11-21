# Project status

- In-process metrics: 
[![Scala CI](https://img.shields.io/github/workflow/status/LoyolaChicagoCode/primenumbers-http4s-scala/Scala%20CI)](https://github.com/LoyolaChicagoCode/primenumbers-http4s-scala/actions)
[![codecov](https://img.shields.io/codecov/c/github/LoyolaChicagoCode/primenumbers-http4s-scala)](https://codecov.io/gh/LoyolaChicagoCode/primenumbers-http4s-scala)
![Commit Activity](https://img.shields.io/github/commit-activity/m/LoyolaChicagoCode/primenumbers-http4s-scala)
[![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/LoyolaChicagoCode/primenumbers-http4s-scala.svg)](http://isitmaintained.com/project/LoyolaChicagoCode/primenumbers-http4s-scala "Average time to resolve an issue")
[![Percentage of issues still open](http://isitmaintained.com/badge/open/LoyolaChicagoCode/primenumbers-http4s-scala.svg)](http://isitmaintained.com/project/LoyolaChicagoCode/primenumbers-http4s-scala "Percentage of issues still open")

- Complexity metrics:
![Code Size](https://img.shields.io/github/languages/code-size/LoyolaChicagoCode/primenumbers-http4s-scala)
[![Codacy Badge](https://img.shields.io/codacy/grade/20f5854f50c94a448968683ad33a687f)](https://www.codacy.com/gh/LoyolaChicagoCode/primenumbers-http4s-scala/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=LoyolaChicagoCode/primenumbers-http4s-scala&amp;utm_campaign=Badge_Grade)
[![Maintainability](https://img.shields.io/codeclimate/maintainability/LoyolaChicagoCode/primenumbers-http4s-scala)](https://codeclimate.com/github/LoyolaChicagoCode/primenumbers-http4s-scala/maintainability)
[![CodeFactor](https://img.shields.io/codefactor/grade/github/LoyolaChicagoCode/primenumbers-http4s-scala)](https://www.codefactor.io/repository/github/loyolachicagocode/primenumbers-http4s-scala)

- Availability metrics (instances 1 and 2): 
[![7-day Uptime Heroku 1](https://img.shields.io/uptimerobot/ratio/7/m786446600-5f6dd44ec992b32e992b9a4e)](https://laufer-primechecker.herokuapp.com/)
[![7-day Uptime Heroku 2](https://img.shields.io/uptimerobot/ratio/7/m786446601-60eff8d20cb712ba914e71bb)](https://laufer-primechecker2.herokuapp.com/)

- Other: 
[![License](http://img.shields.io/:license-mit-blue.svg)](http://doge.mit-license.org)

# Learning objectives

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
