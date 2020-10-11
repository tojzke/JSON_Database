package server.input;

public enum StatusType {
    OK("OK"),
    ERROR("ERROR"),
    EXIT("OK");

    private String msg;

    StatusType(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
