public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public Message(Contact contact) {
        this.message = "Fruble has detected an emergency for " + contact.getName();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

