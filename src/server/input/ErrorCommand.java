package server.input;

import server.ApplicationContext;

public class ErrorCommand implements Command {

    @Override
    public void execute(ApplicationContext context) {
        context.notifyError("ERROR");
    }
}
