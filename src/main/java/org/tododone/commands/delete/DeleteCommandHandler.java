package org.tododone.commands.delete;

import org.tododone.io.RetrieveTodoList;
import org.tododone.io.SaveTodoList;
import org.tododone.todolist.CommandHandler;
import org.tododone.todolist.TodoList;

public class DeleteCommandHandler implements CommandHandler<DeleteCommand> {
    private final RetrieveTodoList retrieveTodoList;
    private final SaveTodoList saveTodoList;

    public DeleteCommandHandler(RetrieveTodoList retrieveTodoList, SaveTodoList saveTodoList) {
        this.retrieveTodoList = retrieveTodoList;
        this.saveTodoList = saveTodoList;
    }

    @Override
    public TodoList handle(DeleteCommand command) throws Exception {
        command.validateArgument();
        int index = command.index() - 1;
        final var todoList = this.retrieveTodoList.getTodoList();
        var tasks = todoList.getTasks();
        tasks.remove(index);
        final var newTodoList = TodoList.of(tasks);
        this.saveTodoList.save(newTodoList);
        return newTodoList;
    }
}
