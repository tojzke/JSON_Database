package server.network;


import com.google.gson.Gson;
import server.input.StatusType;

public class Response {

    private StatusType response;
    private String value;
    private String reason;

    public Response(StatusType response) {
        this(response, null);
    }

    public Response(StatusType response, String value) {
        this.response = response;
        if (response == StatusType.ERROR) {
            this.reason = value;
        } else {
            this.value = value;
        }
    }

    public String getValue() {
        if (value == null || "".equals(value)) {
            return response.toString();
        }
        return value;
    }

    public StatusType getResponse() {
        return response;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}

