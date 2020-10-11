package server.input;

public enum StatusType {
    OK("OK"),
    ERROR("ERROR"),
    EXIT("OK");

    private String msg;

    StatusType(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
