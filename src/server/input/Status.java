package server.input;


public class Status {

    private String message;
    private StatusType type;

    public Status(StatusType type) {
        this(type, null);
    }

    public Status(StatusType type, String message) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        if (message == null || "".equals(message)) {
            return type.getMsg();
        }
        return message;
    }

    public StatusType getType() {
        return type;
    }
}

