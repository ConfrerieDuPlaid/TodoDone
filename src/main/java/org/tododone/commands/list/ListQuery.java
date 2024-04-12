package org.tododone.commands.list;

import org.tododone.commands.Command;

public record ListQuery() implements Command {

    @Override
    public void validateArgument() throws Exception {}
}
