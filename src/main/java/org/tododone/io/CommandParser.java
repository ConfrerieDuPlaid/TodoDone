package org.tododone.io;

import org.tododone.commands.*;
import org.tododone.commands.add.AddCommand;
import org.tododone.commands.delete.DeleteCommand;
import org.tododone.commands.done.DoneCommand;
import org.tododone.commands.list.ListQuery;

public class CommandParser {
    public final String command;
    public final String argument;

    public CommandParser(String[] args) throws Exception {
        if (args.length < 1 || args.length > 2) {
            throw new Exception("Expected one (1) or two (2) arguments");
        }
        if (args[0].isEmpty()) {
            throw new Exception("Command can't be empty");
        }
        this.command = args[0];
        if(args.length > 1) {
            this.argument = args[1];
        } else {
            this.argument = null;
        }

    }

    public Command parse() {
        return switch (this.command) {
            case "add" -> new AddCommand(this.argument);
            case "list" -> new ListQuery();
            case "delete" -> new DeleteCommand(Integer.parseInt(this.argument));
            case "done" -> new DoneCommand(Integer.parseInt(this.argument));
            default -> throw new IllegalArgumentException("Invalid command");
        };
    }
}
