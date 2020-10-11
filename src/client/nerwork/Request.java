package client.nerwork;

import com.beust.jcommander.Parameter;
import com.google.gson.Gson;

public class Request {

    @Parameter(names = "-t",
            description = "Type of request")
    private String type;

    @Parameter(names = "-k", description = "Key for storing in database")
    private String key;

    @Parameter(names = "-v", description = "Value for storing in database")
    private String value;


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
