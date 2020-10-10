package server.input;

import server.model.Record;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Parser {

    private static final String ARGUMENT_ERROR_MESSAGE =
            "Not valid arguments for [%s] command. Should be more than [%d], but actual [%d]";

    private Scanner scanner;

    public Parser(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public Command getNextCommand() {
        var input = scanner.nextLine().trim();

        var tokens = input.split("\\s+");
        var command = tokens[0];
        if ("exit".equals(command)) {
            return new ExitCommand();
        }

        var id = Integer.parseInt(tokens[1]);
        var content = getRecordContent(tokens);
        var record = new Record(content);
        switch (command) {
            case "set":
                return new SetCommand(record, id);
            case "get":
                return new GetCommand(id);
            case "delete":
                return new DeleteCommand(id);
            default:
                return new ErrorCommand();
        }
    }

    private String getRecordContent(String[] tokens) {
        var args = Arrays.copyOfRange(tokens, 2, tokens.length);
        return String.join(" ", args);
    }

}
