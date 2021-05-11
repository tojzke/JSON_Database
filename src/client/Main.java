package client;

import client.network.Request;
import com.beust.jcommander.JCommander;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.file.Paths;

public class Main {

    private static final String address = "127.0.0.1";
    private static final int PORT = 23456;
//    private static final String CLIENT_DATA_PATH = System.getProperty("user.dir") + "JSON Database/task/src/client/data/";
    private static final String CLIENT_DATA_PATH = System.getProperty("user.dir") + File.separator +
        "src" + File.separator +
        "client" + File.separator +
        "data";;

    public Main() throws IOException {
        File file = new File(CLIENT_DATA_PATH);
        file.mkdirs();
    }

    public static void main(String[] args) throws Exception {
        var client = new Main();
        var request = createRequest(args);
        client.sendRequest(request);
    }

    static Request createRequest(String[] consoleArgs) throws FileNotFoundException {
        Args args = new Args();
        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(consoleArgs);

        if (args.getFilename() != null) {
            return requestFromFile(args.getFileroot(), args.getFilename());
        } else {
            return new Request(args.getType(), args.getKey(), args.getValue());
        }
    }

    private static Request requestFromFile(String fileroot, String filename) throws FileNotFoundException {
        var gson = new Gson();
        var file = Paths.get(fileroot, filename).toFile();
        var jsonReader = new JsonReader(new FileReader(file));
        return gson.fromJson(jsonReader, Request.class);
    }

    void sendRequest(Request request) {

        try (
                Socket socket = new Socket(InetAddress.getByName(address), PORT);
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
