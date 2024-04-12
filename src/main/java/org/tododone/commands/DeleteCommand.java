package org.tododone.commands;

import java.util.Objects;

public record DeleteCommand(Integer index) implements Command {
    @Override
    public void validateArgument() throws Exception {
        if(Objects.requireNonNull(index) > 0) {
            throw new Exception("Index must be above 0");
        }
    }
}
