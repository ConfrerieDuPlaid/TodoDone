package org.tododone.io;

public class CommandParser {
    public final String command;
    public final String argument;

    public CommandParser(String[] args) throws Exception {
        if (args.length >= 1 && args.length <= 2) {
            throw new Exception("Expected one (1) or two (2) arguments");
        }
        if (args[0].isEmpty()) {
            throw new Exception("Command can't be empty");
        }
        this.command = args[0];

        this.argument = args[1];
    }
}
