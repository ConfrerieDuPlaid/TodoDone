package org.tododone.io;

import org.tododone.todolist.TodoList;

public class CsvRetrieveList implements RetrieveTodoList {

    private final CSVReader csvReader;

    public CsvRetrieveList(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public TodoList getTodoList() throws Exception {
        // TODO
        return TodoList.of(this.csvReader.readTasks());
    }
}
