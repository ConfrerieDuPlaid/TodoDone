package org.tododone.io;

import org.tododone.todolist.TodoList;

public interface TodoListQuery {
    TodoList getTodoList() throws Exception;
}
