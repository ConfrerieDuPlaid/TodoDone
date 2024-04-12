package org.tododone.commands.done;

import org.tododone.commands.Command;

import java.util.Objects;

public record DoneCommand(Integer index) implements Command {
    @Override
    public void validateArgument() throws Exception {
        if(Objects.requireNonNull(index) <= 0) {
            throw new Exception("Index must be above 0");
        }
    }
}
