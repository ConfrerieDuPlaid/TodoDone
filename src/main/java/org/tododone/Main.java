package org.tododone;

import org.tododone.commands.AddCommand;
import org.tododone.commands.AddCommandHandler;
import org.tododone.commands.Command;
import org.tododone.io.TodoListQuery;
import org.tododone.todolist.CommandHandler;
import org.tododone.todolist.Task;
import org.tododone.todolist.TodoList;

import java.time.LocalDateTime;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Task task = new Task(LocalDateTime.now(), "content", false);
        System.out.println(task.toCSVString());

        TodoListQuery todoListQuery = new TodoListQuery() {
            @Override
            public TodoList getTodoList() throws Exception {
                return null;
            }
        };
        Map<Class<? extends Command>, CommandHandler> commandHandlerMap = Map.of(
                AddCommand.class, new AddCommandHandler(todoListQuery)
        );
    }
}