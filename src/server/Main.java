package server;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var context = new ApplicationContext();
        var parser = context.getParser();

        var running = true;
        while (running) {
            var command = parser.getNextCommand();
            try {
                command.execute(context);
            } catch (Exception e) {
                System.err.println("Can't execute command: " + command);
                context.notifyError("ERROR");
            }

        }

    }


}
