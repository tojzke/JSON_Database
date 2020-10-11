package server.input;

import client.nerwork.Request;
import com.google.gson.Gson;
import server.input.commands.*;
import server.model.Record;

public class JsonParser implements Parser {

    private String json;

    public JsonParser(String json) {
        this.json = json;
    }

    @Override
    public Command getNextCommand() {
        var gson = new Gson();
        var request = gson.fromJson(json, Request.class);

        var command = request.getType();
        var key = request.getKey();
        var value = new Record(request.getValue());

        switch (command) {
            case "exit":
                return new ExitCommand();
            case "set":
                return new SetCommand(key, value);
            case "get":
                return new GetCommand(key);
            case "delete":
                return new DeleteCommand(key);
            default:
                return new ErrorCommand();
        }
    }
}
