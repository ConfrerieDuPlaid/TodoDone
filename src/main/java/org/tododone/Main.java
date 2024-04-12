package org.tododone;

import org.tododone.commands.*;
import org.tododone.commands.add.AddCommand;
import org.tododone.commands.add.AddCommandHandler;
import org.tododone.commands.delete.DeleteCommand;
import org.tododone.commands.delete.DeleteCommandHandler;
import org.tododone.commands.done.DoneCommand;
import org.tododone.commands.done.DoneCommandHandler;
import org.tododone.commands.list.ListQuery;
import org.tododone.commands.list.ListQueryHandler;
import org.tododone.io.*;
import org.tododone.todolist.CommandHandler;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        final var saveFileName = "./todo.csv";
        CSVReader csvReader = new CSVReader(saveFileName);
        CSVWriter csvWriter = new CSVWriter(saveFileName);
        Map<Class<? extends Command>, CommandHandler> commandHandlerMap = getClassCommandHandlerMap(csvReader, csvWriter);

        final var commandParser = new CommandParser(args);
        final var command = commandParser.parse();
        final var commandHandler = commandHandlerMap.get(command.getClass());
        var todoList = commandHandler.handle(command);
    }

    private static Map<Class<? extends Command>, CommandHandler> getClassCommandHandlerMap(CSVReader csvReader, CSVWriter csvWriter) {
        RetrieveTodoList retrieveTodoList = new CsvRetrieveList(csvReader);
        SaveTodoList saveTodoList = new CsvSaveTodoList(csvWriter);
        Map<Class<? extends Command>, CommandHandler> commandHandlerMap = Map.of(
                AddCommand.class, new AddCommandHandler(retrieveTodoList, saveTodoList),
                ListQuery.class, new ListQueryHandler(retrieveTodoList),
                DeleteCommand.class, new DeleteCommandHandler(retrieveTodoList, saveTodoList),
                DoneCommand.class, new DoneCommandHandler(retrieveTodoList, saveTodoList)
        );
        return commandHandlerMap;
    }
}