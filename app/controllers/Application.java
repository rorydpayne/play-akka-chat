package controllers;

import actors.ChatServer;
import actors.messages.Login;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Akka;
import play.libs.F;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import static akka.pattern.Patterns.ask;

public class Application extends Controller {

    private static ActorSystem system = Akka.system();

    public static Result index() {
        return ok(views.html.index.render());
    }

    public static F.Promise<Result> login() {
        ActorRef chatServer = system.actorOf(new Props(ChatServer.class));
        Login login = new Login("user");
        return F.Promise.wrap(ask(chatServer, login, 1000)).map(
                        new F.Function<Object, Result>() {
                            public Result apply(Object response) {
                                ObjectNode result = Json.newObject();
                                result.put("msg", response.toString());
                                return ok(result);
                            }
                        }
                );
    }
}