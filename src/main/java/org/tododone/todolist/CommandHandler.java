package org.tododone.todolist;

import org.tododone.commands.Command;

public interface CommandHandler <T extends Command> {
    TodoList handle(T command) throws Exception;
}
