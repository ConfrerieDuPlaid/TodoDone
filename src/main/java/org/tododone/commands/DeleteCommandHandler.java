package org.tododone.commands;

import org.tododone.todolist.CommandHandler;
import org.tododone.todolist.TodoList;

public class DeleteCommandHandler implements CommandHandler<DeleteCommand> {
    @Override
    public TodoList handle(DeleteCommand command) throws Exception {
        command.validateArgument();
    }
}
