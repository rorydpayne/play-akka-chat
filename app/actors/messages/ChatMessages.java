package actors.messages;

import java.util.List;

public class ChatMessages {

    public static class Login {
        final String user;

        public Login(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }
    }

    public static class Logout {
        final String user;

        public Logout(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }
    }

    public static class GetChatLog {
        final String from;

        public GetChatLog(String from) {
            this.from = from;
        }

        public String getFrom() {
            return from;
        }
    }

    public static class ChatLog {
        final List<String> log;

        public ChatLog(List<String> log) {
            this.log = log;
        }

        public List<String> getLog() {
            return log;
        }
    }

    public static class ChatMessage {
        final String from, message;

        public ChatMessage(String from, String message) {
            this.from = from;
            this.message = message;
        }

        public String getFrom() {
            return from;
        }

        public String getMessage() {
            return message;
        }
    }
}
