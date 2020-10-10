package server;

import server.input.Parser;
import server.storage.DataProvider;
import server.storage.InMemoryDataProvider;

public class ApplicationContext {

    private Parser parser = new Parser(System.in);
    private DataProvider dataProvider = new InMemoryDataProvider(100);


    public Parser getParser() {
        return parser;
    }

    public DataProvider getDataProvider() {
        return dataProvider;
    }

    public void notifyError(String message) {
        System.out.println(message);
    }

    public void shutdown() {
        System.exit(0);
    }
}
