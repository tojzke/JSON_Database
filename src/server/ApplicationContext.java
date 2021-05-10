package server;

import server.storage.DataProvider;
import server.storage.InMemoryArrayDataProvider;
import server.storage.InMemoryMapDataProvider;
import server.storage.JsonFileDataProvider;

import java.io.IOException;

public class ApplicationContext {

    private DataProvider dataProvider = new JsonFileDataProvider();

    public ApplicationContext() throws IOException {
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
