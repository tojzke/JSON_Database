package server.input.commands;

import server.ApplicationContext;
import server.network.Response;
import server.input.StatusType;
import server.model.Record;

public class SetCommand implements Command {

    // Args
    private Record record;
    private String key;

    public SetCommand(String key, Record record) {
        this.record = record;
        this.key = key;
    }

    @Override
    public Response execute(ApplicationContext context) {
        var dataProvider = context.getDataProvider();
        try {
            dataProvider.save(key, record);
            return new Response(StatusType.OK);
        } catch (Exception e) {
            return new Response(StatusType.ERROR);
        }

    }

    @Override
    public String toString() {
        return "SetCommand{" +
                "record=" + record +
                ", id=" + key +
                '}';
    }
}
