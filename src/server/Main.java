package server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    private static final int PORT = 23456;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started!");
                try (
                        Socket socket = server.accept(); // accepting a new client
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    String msg = input.readUTF(); // reading a message
                    System.out.println("Received: " + msg);

                    String processedMessage = "A record # N was sent!";
                    output.writeUTF(processedMessage); // resend it to the client
                    System.out.println("Sent: " + processedMessage);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

            var processedMessage = processMessage(msg);
            output.writeUTF(processedMessage);
            System.out.println("Sent: " + processedMessage);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String processMessage(String message) {
        var id = message.split("#")[1].trim();
        return "A record # " + id + " was sent!";
    }
}
