package org.tododone.commands;

import org.tododone.io.TodoListQuery;
import org.tododone.todolist.CommandHandler;
import org.tododone.todolist.Task;
import org.tododone.todolist.TodoList;

import java.util.ArrayList;

public class AddCommandHandler implements CommandHandler<AddCommand> {

    private final TodoListQuery todoListQuery;

    public AddCommandHandler(TodoListQuery todoListQuery) {
        this.todoListQuery = todoListQuery;
    }

    @Override
    public TodoList handle(AddCommand command) throws Exception {
        command.validateArgument();
<<<<<<< Updated upstream
        TodoList todoList = this.todoListQuery.getTodoList();
        todoList.addTask(Task.create(command.content()));
        return todoList;
=======
        return TodoList.of(new ArrayList<>());
>>>>>>> Stashed changes
    }
}
