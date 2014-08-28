package actors.managers;

import actors.Session;
import actors.messages.ChatMessages.Login;
import actors.messages.ChatMessages.Logout;

import akka.actor.*;

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
//            ActorRef session = system.actorOf(new Props(new UntypedActorFactory() {
//
//                @Override
//                public UntypedActor create() throws Exception {
//                    return new Session(username, storage);
//                }
//            }), "session");
//
//            session.
            ActorRef session = system.actorOf(Props.create(Session.class, username, storage), "session");
            session.start(); // starts a session actor
            session.put(((Login) message).getUser(), session);    // sends login message to session actor
            logger().info("User [%s] has logged in", username);

            } else if (message instanceof Logout) {
            String username = ((Logout) message).getUser();
            ActorRef session = sessions.get(username);            // get session actor of the username
            session.stop();
            logger().info("User [%s] has logged out", username);
        }
    }
    public void shutdownSessions() {
        for (ActorRef session : sessions.values())
            session.stop();
    }
}
