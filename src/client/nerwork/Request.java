package client.nerwork;

import com.beust.jcommander.Parameter;
import com.google.gson.Gson;

public class Request {

    private String type;

    private String key;

    private String value;

    public Request(String type, String key, String value) {
        this.type = type;
        this.key = key;
        this.value = value;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }


    public String getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
