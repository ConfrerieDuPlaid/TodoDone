package org.tododone;

import org.tododone.commands.*;
import org.tododone.io.TodoListQuery;
import org.tododone.todolist.CommandHandler;
import org.tododone.todolist.TodoList;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TodoListQuery todoListQuery = new TodoListQuery() {
            @Override
            public TodoList getTodoList() throws Exception {
                return null;
            }
        };
        Map<Command, CommandHandler> commandHandlerMap = Map.of(
                AddCommand.class, new AddCommandHandler(todoListQuery),
                DoneCommand.class, new DoneCommandHandler(),
                ListQuery.class, new ListQueryHandler(),
                DeleteCommand.class, new DeleteCommandHandler()
        );
    }
}