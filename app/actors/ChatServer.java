package actors;

import actors.messages.Login;
import akka.actor.UntypedActor;

public class ChatServer extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Login) {
            Login login = (Login) message;
            System.out.println("Welcome user: " + login.getUser());
            getContext().system().shutdown();
//        } else if (message instanceof ChatMessages.Logout) {
//
//        } else if (message instanceof ChatMessages.ChatMessage) {
//
//        } else if (message instanceof ChatMessages.GetChatLog) {

        } else {
            unhandled(message);
        }
    }
}
