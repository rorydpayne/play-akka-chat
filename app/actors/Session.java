package actors;

import actors.messages.ChatMessages;
import akka.actor.UntypedActor;

public class Session extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof ChatMessages.ChatMessage) {

        } else if (message instanceof ChatMessages.GetChatLog) {

        } else {
            // handle exception
        }
    }
}
