package client;

import client.nerwork.Request;
import com.beust.jcommander.JCommander;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    private static final String address = "127.0.0.1";
    private static int port = 23456;


    public static void main(String[] args) {
        Request request = new Request();
        JCommander.newBuilder()
                .addObject(request)
                .build()
                .parse(args);

        new Main().sendRequest(request);
    }

    void sendRequest(Request request) {

        try (
                Socket socket = new Socket(InetAddress.getByName(address), port);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            System.out.println("Client started!");
            var msg = request.toJson();
            output.writeUTF(msg); // sending message to the server
            System.out.println("Sent: " + msg);


            String receivedMsg = input.readUTF(); // response message
            System.out.println("Received: " + receivedMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
