package server.input;

import server.input.commands.Command;

public interface Parser {
    Command getNextCommand();
}
