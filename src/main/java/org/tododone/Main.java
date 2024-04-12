package org.tododone;

import org.tododone.commands.*;
import org.tododone.todolist.CommandHandler;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Command, CommandHandler> commandHandlerMap = Map.of(
                AddCommand.class, new AddCommandHandler(),
                DoneCommand.class, new DoneCommandHandler(),
                ListQuery.class, new ListQueryHandler(),
                DeleteCommand.class, new DeleteCommandHandler()
        );
    }
}