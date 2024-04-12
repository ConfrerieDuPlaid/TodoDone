package org.tododone;

import org.tododone.commands.*;
import org.tododone.io.*;
import org.tododone.todolist.CommandHandler;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        final var saveFileName = "./todo.csv";
        CSVReader csvReader = new CSVReader(saveFileName);
        CSVWriter csvWriter = new CSVWriter(saveFileName);
        RetrieveTodoList retrieveTodoList = new CsvRetrieveList(csvReader);
        SaveTodoList saveTodoList = new CsvSaveTodoList(csvWriter);
        Map<Class<? extends Command>, CommandHandler> commandHandlerMap = Map.of(
                AddCommand.class, new AddCommandHandler(retrieveTodoList, saveTodoList),
                ListQuery.class, new ListQueryHandler(retrieveTodoList)
        );
        final var commandParser = new CommandParser(args);
        final var command = commandParser.parse();
        final var commandHandler = commandHandlerMap.get(command.getClass());
        commandHandler.handle(command);
    }
}