package server.input;

import server.ApplicationContext;

public class ExitCommand implements Command {
    @Override
    public void execute(ApplicationContext context) {
        context.shutdown();
    }
}
