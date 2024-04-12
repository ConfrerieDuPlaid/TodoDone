package org.tododone.io;

import org.tododone.todolist.TodoList;

public interface SaveTodoList {
    void save(TodoList todoList) throws Exception;
}
