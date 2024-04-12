package org.tododone.commands;

import org.tododone.io.RetrieveTodoList;
import org.tododone.todolist.CommandHandler;
import org.tododone.todolist.TodoList;

public class ListQueryHandler implements CommandHandler<ListQuery> {
    private final RetrieveTodoList retrieveTodoList;

    public ListQueryHandler(RetrieveTodoList retrieveTodoList) {
        this.retrieveTodoList = retrieveTodoList;
    }


    @Override
    public TodoList handle(ListQuery command) throws Exception {
        return this.retrieveTodoList.getTodoList();
    }
}
