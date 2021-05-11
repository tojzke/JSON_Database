package server;

import server.storage.DataProvider;
import server.storage.InMemoryArrayDataProvider;
import server.storage.InMemoryMapDataProvider;
import server.storage.JsonFileDataProvider;

import java.io.IOException;
import java.net.ServerSocket;

public class ApplicationContext {

    private DataProvider dataProvider = new JsonFileDataProvider();
    private ServerSocket serverSocket;

    public ApplicationContext() throws IOException {
    }

    public DataProvider getDataProvider() {
        return dataProvider;
    }

    public void notifyError(String message) {
        System.out.println(message);
    }

    public void shutdown() throws IOException {
        serverSocket.close();
        System.exit(0);
    }

    public void setServerSocket(ServerSocket server) {
        this.serverSocket = server;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }
}
