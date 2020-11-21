package edu.luc.etl.cs433.laufer.primenumbers

import cats.effect.Sync
import cats.implicits._
import org.http4s.{HttpRoutes, MediaType}
import org.http4s.headers.`Content-Type`
import org.http4s.dsl.Http4sDsl
import org.http4s.scalaxml._

object PrimeCheckerRoutes {

  def primeCheckerRoutes[F[_]: Sync](P: PrimeChecker[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F]{}
    import dsl._
    HttpRoutes.of[F] {
      case GET -> Root =>
        val title = "Welcome to the prime checker web service!"
        Ok(<html>
            <head><title>{title}</title></head>
            <body>
              <h1>{title}</h1>
              <p>Append a whole number to the request URL to check whether it is prime.</p>
              <p>No more than ${Long.MaxValue}, please.</p>
              <p>The code for this service is <a href="https://github.com/LoyolaChicagoCode/primenumbers-http4s-scala">on GitHub</a>.</p>
            </body>
          </html>
        ).map(_.withContentType(`Content-Type`(MediaType.text.html)))
      case GET -> Root / LongVar(number) =>
        P.check(BigInt(number)).flatMap {
          case true => Ok(f"Yay, $number happens to be a prime!")
          case false => NotFound(f"Bummer, $number is not a prime.")
        }
    }
  }
}