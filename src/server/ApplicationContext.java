package server;

import server.storage.DataProvider;
import server.storage.InMemoryArrayDataProvider;
import server.storage.InMemoryMapDataProvider;

public class ApplicationContext {

    private DataProvider dataProvider = new InMemoryMapDataProvider(100);

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
