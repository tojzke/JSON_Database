package server.input.commands;

import server.ApplicationContext;
import server.network.Response;

public interface Command {

    String NO_SUCH_KEY_MSG = "No such key";

    Response execute(ApplicationContext context);

}

