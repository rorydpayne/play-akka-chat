package actors;

import actors.messages.ChatMessages.GetChatLog;
import actors.messages.ChatMessages.ChatMessage;
import akka.actor.ActorRef;
import akka.actor.UntypedActor;

import java.util.ArrayList;
import java.util.List;

public class Session extends UntypedActor {
    private ActorRef storage = null;
    private final long loginTime = System.currentTimeMillis();
    private List<String> userLog = new ArrayList<String>();

    public Session(String user, ActorRef storage) {
        this.storage = storage;
        log().logger().info("New session for user [%s] has been created at [%s]", user, loginTime);
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof ChatMessage) {
                userLog.add(((ChatMessage) message).getMessage());
                storage.sendOneWay(message);
        } else if (message instanceof GetChatLog) {
                storage.forward(message, getContext());
        }
    }
}
