package edu.luc.etl.cs433.laufer.primenumbers

import cats.effect.IO
import org.http4s.dsl.io._
import org.http4s.{HttpApp, HttpRoutes, MediaType}
import org.http4s.headers.`Content-Type`
import org.http4s.implicits._
import org.http4s.scalaxml.xmlEncoder

object PrimeCheckerApp {

  val routes: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case GET -> Root =>
      val title = "Welcome to the prime checker web service!"
      Ok(<html>
          <head><title>{title}</title></head>
          <body>
            <h1>{title}</h1>
            <p>Append a whole number to the request URL to check whether it is prime.</p>
            <p>No more than {Long.MaxValue}, please.</p>
            <p>The code for this service is <a href="https://github.com/LoyolaChicagoCode/primenumbers-http4s-scala">on GitHub</a>.</p>
          </body>
        </html>
      ).map(_.withContentType(`Content-Type`(MediaType.text.html)))
    case GET -> Root / LongVar(number) =>
      if (PrimeChecker.isPrime(BigInt(number)))
        Ok(f"Yay, $number happens to be a prime!")
      else
        NotFound(f"Bummer, $number is not a prime.")
  }

  val app: HttpApp[IO] = routes.orNotFound
}