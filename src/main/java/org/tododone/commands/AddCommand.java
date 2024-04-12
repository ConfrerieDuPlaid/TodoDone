package org.tododone.commands;

import java.util.Objects;

public record AddCommand(String content) implements Command{

    @Override
    public void validateArgument() throws Exception {
        if (Objects.requireNonNull(content).isEmpty()) {
            throw new Exception("Content can't be empty");
        }
    }
}
