package server.input.commands;

import server.ApplicationContext;
import server.network.Response;
import server.input.StatusType;

public class ExitCommand implements Command {
    @Override
    public Response execute(ApplicationContext context) {
        return new Response(StatusType.EXIT, "OK");
    }
}
