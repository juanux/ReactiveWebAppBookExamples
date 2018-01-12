package coreConcepts

import mockws.{MockWS, MockWSHelpers}
import org.scalatest.{BeforeAndAfterAll, FreeSpec, Matchers}
import play.api.libs.ws.WSResponse
import play.api.mvc.Results._
import play.api.test.Helpers._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


class Futures  extends FreeSpec with Matchers with MockWSHelpers with BeforeAndAfterAll{

  val ws = MockWS {
    case (GET, "http://www.playframework.com") => Action { Ok("homepage") }
    case (GET, "/users/24") => Action { NotFound("") }
  }

  "Future Test  should return Ok " in {


    val response: Future[WSResponse] = ws.url("http://www.playframework.com").get()

    response.map{r=>

      r.status shouldBe 200

    }

  }

  override def afterAll(): Unit = {
    shutdownHelpers()
  }

}
