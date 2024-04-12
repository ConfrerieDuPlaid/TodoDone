package org.tododone.commands;

import org.tododone.io.RetrieveTodoList;
import org.tododone.io.SaveTodoList;
import org.tododone.todolist.CommandHandler;
import org.tododone.todolist.TodoList;

public class DoneCommandHandler implements CommandHandler<DoneCommand> {
    private final RetrieveTodoList retrieveTodoList;
    private final SaveTodoList saveTodoList;

    public DoneCommandHandler(RetrieveTodoList retrieveTodoList, SaveTodoList saveTodoList) {
        this.retrieveTodoList = retrieveTodoList;
        this.saveTodoList = saveTodoList;
    }
    @Override
    public TodoList handle(DoneCommand command) throws Exception {
        command.validateArgument();
        int index = command.index() - 1;
        final var todoList = this.retrieveTodoList.getTodoList();
        var tasks = todoList.getTasks();
        var task = tasks.get(index);
        task.setDone(true);
        tasks.set(index, task);
        final var newTodoList = TodoList.of(tasks);
        this.saveTodoList.save(newTodoList);
        return newTodoList;
    }
}
