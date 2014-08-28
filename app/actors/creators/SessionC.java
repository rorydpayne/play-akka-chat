package actors.creators;

import actors.Session;
import akka.actor.ActorRef;
import akka.japi.Creator;

public class SessionC implements Creator<Session> {
    private String username;
    private ActorRef storage = null;
    /**
     * This method must return a different instance upon every call.
     */
            @Override
            public Session create() throws Exception {
                return new Session(username, storage);
    }
}
