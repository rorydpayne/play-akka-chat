package actors.managers;

import actors.Session;
import actors.messages.ChatMessages.Login;
import actors.messages.ChatMessages.Logout;
import actors.messages.ChatMessages.GetChatLog;
import actors.messages.ChatMessages.ChatMessage;
import akka.actor.*;
import play.libs.Akka;

import java.util.HashMap;
import java.util.Map;

public class SessionManagement {
    private ActorRef storage = null;
    private ActorRef self = null;
    private Map<String, ActorRef> sessions = new HashMap<String, ActorRef>();
    private final ActorSystem system = ActorSystem.create("SessionSystem");

    public SessionManagement(ActorRef self, ActorRef storage) {
        this.self = self;
        this.storage = storage;
    }

    public ActorRef getSession(String username) {
        return sessions.get(username);
    }

    public void handleReceive(final Object message) {
        if (message instanceof Login) {
            final String username =((Login) message).getUser();
            ActorRef session = system.actorOf(new Props(new UntypedActorFactory() {

                @Override
                public Actor create() throws Exception {
                    return new Session(username, storage);
                }
            }), "session");
            session.start();
            session.put(((Login) message).getUser(), session);
            logger().info("User [%s] has logged in", username);
        } else if (message instanceof Logout) {
            String username = ((Logout) message).getUser();
            ActorRef session = sessions.get(username);
            logger().info("User [%s] has logged out", username);
        }
    }
    public void shutdownSessions() {
        for (ActorRef session : sessions.values())
            session.stop();
    }
}
