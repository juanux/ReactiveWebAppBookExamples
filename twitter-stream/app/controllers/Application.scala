package controllers

import actors.TwitterStreamer
import play.api._
import play.api.mvc._
import play.api.libs.oauth.{ConsumerKey, OAuthCalculator, RequestToken}
import play.api.Play.current

import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.ws._
import play.api.libs.iteratee._
import play.api.Logger
import play.api.libs.json._
import play.extras.iteratees._


class Application extends Controller {

  def index = Action { implicit request =>
    Ok(views.html.index("Tweets"))
  }

  def tweets = WebSocket.acceptWithActor[String,JsValue]{
    request => out => TwitterStreamer.props(out)
  }

  def credentials:Option[(ConsumerKey,RequestToken)] = for{
    apiKey <- Play.configuration.getString("twitter.apiKey")
    apiSecret <- Play.configuration.getString("twitter.apiSecret")
    token <- Play.configuration.getString("twitter.token")
    tokenSecret <- Play.configuration.getString("twitter.tokenSecret")
  }yield(
    ConsumerKey(apiKey,apiSecret),
    RequestToken(token,tokenSecret)
  )

  def replicateFeed = Action{ implicit request =>
    Ok.feed(TwitterStreamer.subscribeNode)

  }
}
