package org.tododone.io;

import org.tododone.todolist.TodoList;

import java.util.List;

public class CsvTodoListQuery implements TodoListQuery {

    private final CSVReader csvReader;

    public CsvTodoListQuery(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public TodoList getTodoList() throws Exception {
        // TODO
        return TodoList.of(List.of());
    }
}
