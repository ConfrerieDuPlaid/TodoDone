package org.tododone.commands;

import org.tododone.io.TodoListQuery;
import org.tododone.todolist.CommandHandler;
import org.tododone.todolist.TodoList;

public class AddCommandHandler implements CommandHandler<AddCommand> {

    private final TodoListQuery todoListQuery;

    public AddCommandHandler(TodoListQuery todoListQuery) {
        this.todoListQuery = todoListQuery;
    }

    @Override
    public TodoList handle(AddCommand command) throws Exception {
        command.validateArgument();

    }
}
