package actors

import akka.actor.{Actor, ActorRef, Props}
import play.api.{Logger, Play}
import play.api.libs.iteratee.Enumerator
import play.api.Play.current

import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.ws._
import play.api.libs.iteratee._
import play.api.Logger
import play.api.libs.json._
import play.extras.iteratees._
import play.api.libs.oauth.{ConsumerKey, OAuthCalculator, RequestToken}

/**
  * Created by juanj on 22/06/2017.
  */
class TwitterStreamer (out:ActorRef) extends Actor{

   def receive: Receive = {
     case "subscribe" =>
       Logger.info("Received subscription from a client")
       TwitterStreamer.suscribe(out)
   }

}

object TwitterStreamer{

  def props(out: ActorRef) = Props(new TwitterStreamer((out)))

  private var broadcastEnumerator: Option[Enumerator[JsObject]] = None

  def connect(): Unit = {




    credentials.map{ case (consumerKey,requestToken) =>
      val (iteratee,enumerator) = Concurrent.joined[Array[Byte]]

      val jsonStream: Enumerator[JsObject]=
        enumerator &>
          Encoding.decode() &>
          Enumeratee.grouped(JsonIteratees.jsSimpleObject)

     val (be,_) = Concurrent.broadcast(jsonStream)
     broadcastEnumerator = Some(be)
        val maybeMasterNodeUrl = Option(System.getProperty("masterNodeUrl"))
        val url = maybeMasterNodeUrl.getOrElse{ "https://stream.twitter.com/1.1/statuses/filter.json"}

         WS
          .url(url)
          .sign(OAuthCalculator(consumerKey,requestToken))
          .withQueryString("track" -> "paz")
          .get{ response =>
            Logger.info("Status: " + response.status)
            iteratee
        }.map{ _ =>
       Logger.info("Twiteer stream closed")
      }

    }getOrElse{
      Future.successful{
        Logger.info("Twitter credentials missing")
      }
    }

  }
  def suscribe(out:ActorRef): Unit = {
    if(broadcastEnumerator.isEmpty){
      connect()
    }



    val twitterClient = Iteratee.foreach[JsObject]{t => out ! t}

    broadcastEnumerator.foreach{enumerator =>
      enumerator run twitterClient
    }
  }

  def subscribeNode: Enumerator[JsObject] = {
    if(broadcastEnumerator.isEmpty){
      connect()
    }
    broadcastEnumerator.getOrElse{
      Enumerator.empty[JsObject]

    }
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

}
