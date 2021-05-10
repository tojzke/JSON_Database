package server.input.commands;

import server.ApplicationContext;
import server.network.Response;
import server.input.StatusType;

public class GetCommand implements Command {

    private String key;

    public GetCommand(String key) {
        this.key = key;
    }

    @Override
    public Response execute(ApplicationContext context) {
        var dataProvider = context.getDataProvider();
        try {
            var record = dataProvider.get(key);
            return new Response(StatusType.OK, record.getContent());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return new Response(StatusType.ERROR, NO_SUCH_KEY_MSG);
        }
    }

    @Override
    public String toString() {
        return "GetCommand{" +
                "id=" + key +
                '}';
    }
}
