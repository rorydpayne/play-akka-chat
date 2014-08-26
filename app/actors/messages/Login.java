package actors.messages;

public class Login {
    final String user;

    public Login(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
}
