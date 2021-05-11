package server;


import server.input.ConsoleParser;
import server.input.JsonParser;
import server.input.StatusType;
import server.network.Response;
import server.network.Session;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int PORT = 23456;
    public static final int MAX_THREADS = 20;

    private ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ApplicationContext();
        new Main().startServer(context);
    }

    private void startServer(ApplicationContext context) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started!");
            context.setServerSocket(server);
            while (true) {
                Socket socket = server.accept(); // accepting a new client
                var session = new Session(context, socket);
                executor.submit(session);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

