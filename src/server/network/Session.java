package server.network;

import server.ApplicationContext;
import server.input.JsonParser;
import server.input.StatusType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Session implements Runnable {

    private final Socket socket;
    private final ApplicationContext context;

    public Session(ApplicationContext context, Socket socket) {
        this.context = context;
        this.socket = socket;
    }

    public void run() {
        try (DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
                var response = processRequest(context, input, output);
                socket.close();
                if (response.getStatus() == StatusType.EXIT) {
                    context.shutdown();
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Response processRequest(ApplicationContext context, DataInputStream input, DataOutputStream output) throws IOException {
        String msg = input.readUTF(); // reading a message
        System.out.println("Received: " + msg);

        var parser = new JsonParser(msg);
        var command = parser.getNextCommand();

        var response = command.execute(context);
        var responseMsg = response.toJson();
        output.writeUTF(responseMsg);
        System.out.println("Server sent: " + responseMsg);
        return response;
    }
}
