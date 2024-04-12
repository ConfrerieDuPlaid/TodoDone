package org.tododone;

import org.tododone.commands.AddCommand;
import org.tododone.commands.AddCommandHandler;
import org.tododone.commands.Command;
import org.tododone.io.TodoListQuery;
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
        Map<Class<? extends Command>, Object> commandHandlerMap = Map.of(
                AddCommand.class, new AddCommandHandler(todoListQuery)
        );
    }
}