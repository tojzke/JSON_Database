package server.input.commands;

import server.ApplicationContext;
import server.network.Response;
import server.input.StatusType;

public class ErrorCommand implements Command {

    @Override
    public Response execute(ApplicationContext context) {
        context.notifyError("ERROR");
        return new Response(StatusType.ERROR);
    }
}
