package org.tododone.commandparser;

public class CommandParser {
    public final String command;
    public final String argument;

    public CommandParser(String[] args) throws Exception {
        if (args.length != 2) {
            throw new Exception("Expected two (2) arguments : command argument");
        }
        if (args[0].isEmpty()) {
            throw new Exception("Command can't be empty");
        }
        this.command = args[0];
        if (args[1].length() != 1) {
            throw new Exception("Operand must be one character only");
        }
        this.argument = args[1];
    }
}
