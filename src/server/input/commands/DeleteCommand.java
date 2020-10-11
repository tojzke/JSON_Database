package server.input.commands;

import server.ApplicationContext;
import server.network.Response;
import server.input.StatusType;

public class DeleteCommand implements Command {

    private String key;

    public DeleteCommand(String key) {
        this.key = key;
    }

    @Override
    public Response execute(ApplicationContext context) {
        var dataProvider = context.getDataProvider();
        try {
            var record = dataProvider.delete(key);
            if (record != null) {
                return new Response(StatusType.OK);
            } else {
                return new Response(StatusType.ERROR, NO_SUCH_KEY_MSG);
            }
        } catch (Exception e) {
            return new Response(StatusType.ERROR);
        }
    }

    @Override
    public String toString() {
        return "DeleteCommand{" +
                "id=" + key +
                '}';
    }
}
