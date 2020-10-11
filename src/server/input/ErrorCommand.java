package server.input;

import server.ApplicationContext;

public class ErrorCommand implements Command {

    @Override
    public Status execute(ApplicationContext context) {
        context.notifyError("ERROR");
        return new Status(StatusType.ERROR);
    }
}
