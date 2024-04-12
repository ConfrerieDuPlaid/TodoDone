package org.tododone.commands;

import org.tododone.io.RetrieveTodoList;
import org.tododone.io.SaveTodoList;
import org.tododone.todolist.CommandHandler;
import org.tododone.todolist.Task;
import org.tododone.todolist.TodoList;

public class AddCommandHandler implements CommandHandler<AddCommand> {

    private final RetrieveTodoList todoListQuery;
    private final SaveTodoList saveTodoList;

    public AddCommandHandler(RetrieveTodoList todoListQuery, SaveTodoList saveTodoList) {
        this.todoListQuery = todoListQuery;
        this.saveTodoList = saveTodoList;
    }

    @Override
    public TodoList handle(AddCommand command) throws Exception {
        command.validateArgument();
        TodoList todoList = this.todoListQuery.getTodoList();
        todoList.addTask(Task.create(command.content()));
        this.saveTodoList.save(todoList);
        return todoList;
    }
}
