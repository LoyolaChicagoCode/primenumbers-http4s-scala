# Project metrics

- In-process  
[![Scala CI](https://github.com/lucproglangcourse/primenumbers-http4s-scala/actions/workflows/scala.yml/badge.svg)](https://github.com/lucproglangcourse/primenumbers-http4s-scala/actions/workflows/scala.yml)
[![codecov](https://img.shields.io/codecov/c/github/LoyolaChicagoCode/primenumbers-http4s-scala)](https://codecov.io/gh/LoyolaChicagoCode/primenumbers-http4s-scala)
![Commit Activity](https://img.shields.io/github/commit-activity/m/LoyolaChicagoCode/primenumbers-http4s-scala)
[![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/LoyolaChicagoCode/primenumbers-http4s-scala.svg)](http://isitmaintained.com/project/LoyolaChicagoCode/primenumbers-http4s-scala "Average time to resolve an issue")
[![Percentage of issues still open](http://isitmaintained.com/badge/open/LoyolaChicagoCode/primenumbers-http4s-scala.svg)](http://isitmaintained.com/project/LoyolaChicagoCode/primenumbers-http4s-scala "Percentage of issues still open")
- Complexity  
![Code Size](https://img.shields.io/github/languages/code-size/LoyolaChicagoCode/primenumbers-http4s-scala)
[![Codacy Badge](https://img.shields.io/codacy/grade/20f5854f50c94a448968683ad33a687f)](https://www.codacy.com/gh/LoyolaChicagoCode/primenumbers-http4s-scala/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=LoyolaChicagoCode/primenumbers-http4s-scala&amp;utm_campaign=Badge_Grade)
[![Maintainability](https://img.shields.io/codeclimate/maintainability/LoyolaChicagoCode/primenumbers-http4s-scala)](https://codeclimate.com/github/LoyolaChicagoCode/primenumbers-http4s-scala/maintainability)
[![Technical Debt](https://img.shields.io/codeclimate/tech-debt/LoyolaChicagoCode/primenumbers-http4s-scala)](https://codeclimate.com/github/LoyolaChicagoCode/primenumbers-http4s-scala/trends/technical_debt)
[![CodeFactor](https://img.shields.io/codefactor/grade/github/LoyolaChicagoCode/primenumbers-http4s-scala)](https://www.codefactor.io/repository/github/LoyolaChicagoCode/primenumbers-http4s-scala)
- Depedencies/composition analysis  
[![Scala Steward badge](https://img.shields.io/badge/Scala_Steward-helping-blue.svg?style=flat&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAQCAMAAAARSr4IAAAAVFBMVEUAAACHjojlOy5NWlrKzcYRKjGFjIbp293YycuLa3pYY2LSqql4f3pCUFTgSjNodYRmcXUsPD/NTTbjRS+2jomhgnzNc223cGvZS0HaSD0XLjbaSjElhIr+AAAAAXRSTlMAQObYZgAAAHlJREFUCNdNyosOwyAIhWHAQS1Vt7a77/3fcxxdmv0xwmckutAR1nkm4ggbyEcg/wWmlGLDAA3oL50xi6fk5ffZ3E2E3QfZDCcCN2YtbEWZt+Drc6u6rlqv7Uk0LdKqqr5rk2UCRXOk0vmQKGfc94nOJyQjouF9H/wCc9gECEYfONoAAAAASUVORK5CYII=)](https://scala-steward.org)
[![OpenSSF Scorecard](https://api.scorecard.dev/projects/github.com/lucproglangcourse/primenumbers-http4s-scala/badge)](https://scorecard.dev/viewer/?uri=github.com/lucproglangcourse/primenumbers-http4s-scala)
- Availability (by deployed instance)  
[![7-day Uptime Linode](https://img.shields.io/uptimerobot/ratio/7/m786446600-5f6dd44ec992b32e992b9a4e)](https://linode5.cs.luc.edu:8080/)
[![7-day Uptime Oracle Cloud](https://img.shields.io/uptimerobot/ratio/7/m786446601-60eff8d20cb712ba914e71bb)](https://129.213.20.3:8080/)
- Other  
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

or deploy to a suitable cloud provider, such as Oracle.

Then, http://host/n returns

- 200 OK if n is prime
- 404 Not Found otherwise

# Sample prime numbers to try

- [1013](http://linode5.cs.luc.edu:8080/1013)
- [10007](http://linode5.cs.luc.edu:8080/10007)
- [100003](http://linode5.cs.luc.edu:8080/100003)
- [1000003](http://linode5.cs.luc.edu:8080/1000003)
- [10000169](http://linode5.cs.luc.edu:8080/10000169)
- [100000007](http://linode5.cs.luc.edu:8080/100000007)

# Sample non-prime numbers to try

- [999989](http://linode5.cs.luc.edu:8080/999989)

# References

- [Jason Christensen's OOPSLA 2009 presentation](http://www.slideshare.net/jasonc411/oopsla-2009-combining-rest-and-cloud-a-practitioners-report)
- [James Earl Douglas's SBTB 2014 presentation](https://www.youtube.com/watch?v=sZYAFWTyOlE)
- [James Earl Douglas's Scala CI/CD/DevOps example](https://github.com/earldouglas/scala-cd): Travis, Coveralls, and Heroku
