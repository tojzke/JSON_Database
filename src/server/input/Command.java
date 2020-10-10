package server.input;

import server.ApplicationContext;
import server.storage.DataProvider;

import java.util.Optional;

public interface Command {

    void execute(ApplicationContext context) throws Exception;

}

