package server;


import server.input.Parser;
import server.input.Status;
import server.input.StatusType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    private static final int PORT = 23456;

    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext();
        new Main().startServer(context);
    }

    private void startServer(ApplicationContext context) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started!");
            while (true) {
                try (Socket socket = server.accept(); // accepting a new client
                     DataInputStream input = new DataInputStream(socket.getInputStream());
                     DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    var status = processRequest(context, input, output);

                    if (status.getType() == StatusType.EXIT) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Status processRequest(ApplicationContext context, DataInputStream input, DataOutputStream output) throws IOException {
        String msg = input.readUTF(); // reading a message
        System.out.println("Received: " + msg);

        var parser = new Parser(msg);
        var command = parser.getNextCommand();

        var status = command.execute(context);
        output.writeUTF(status.getMessage());
        System.out.println("Server sent: " + status.getMessage());
        return status;
    }
}

class Session extends Thread {
    private final Socket socket;

    public Session(Socket socketForClient) {
        this.socket = socketForClient;
    }

    public void run() {
        try (DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            String msg = input.readUTF();
            System.out.println("Received: " + msg);

            var processedMessage = "Sent koko";
            output.writeUTF(processedMessage);
            System.out.println("Sent: " + processedMessage);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
