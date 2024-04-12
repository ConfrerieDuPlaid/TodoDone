package org.tododone.io;

import org.tododone.todolist.TodoList;

public class CsvSaveTodoList implements SaveTodoList {
    private final CSVWriter csvWriter;

    public CsvSaveTodoList(CSVWriter csvWriter) {
        this.csvWriter = csvWriter;
    }

    @Override
    public void save(TodoList todoList) throws Exception {
        this.csvWriter.writeTaskList(todoList.getTasks());
    }
}
