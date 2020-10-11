package server.input;

import server.ApplicationContext;

public class ExitCommand implements Command {
    @Override
    public Status execute(ApplicationContext context) {
        return new Status(StatusType.EXIT);
    }
}
