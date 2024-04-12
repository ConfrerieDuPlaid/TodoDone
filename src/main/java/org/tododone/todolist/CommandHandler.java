package org.tododone.todolist;

import org.tododone.commands.Command;

public interface CommandHandler <T extends Command> {
    void handle(T command) throws Exception;
}
