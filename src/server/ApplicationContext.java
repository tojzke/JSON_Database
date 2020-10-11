package server;

import server.input.Parser;
import server.storage.DataProvider;
import server.storage.InMemoryDataProvider;

public class ApplicationContext {

    private DataProvider dataProvider = new InMemoryDataProvider(1000);


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
