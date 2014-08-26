package actors;

import actors.managers.ChatManagement;
import actors.managers.SessionManagement;
import actors.messages.ChatMessages.Login;
import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class ChatServer extends UntypedActor {
    private ActorRef storage = null;
    private SessionManagement sessionMgr = null;
    private ChatManagement chatMgr = null;

    public ChatServer() {
        storage = getContext().spawnLink(MongoChatStorage.class);

        Supervision.FaultHandlingStrategy faultHandler = new Supervision.OneForOneStrategy(
                null,
                null,
                null
        );
        getContext().setFaultHandler(faultHandler);

        sessionMgr = new SessionManagement(getContext(), storage);
        chatMgr = new ChatManagement(getContext(), sessionMgr);

        logger().info("Chat server is starting up...");
    }


    @Override
    public void onReceive(Object message) throws Exception {
        sessionMgr.handleReceive(message);
        chatMgr.handleReceive(message);
    }

    public void postStop() {
        logger().info("Chat server is shutting down...");
        sessionMgr.shutdownSessions();
        getContext().unlink(storage);
        storage.stop();
    }
}
