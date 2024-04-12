package org.tododone.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandParserTest {
    private final String testFilePath = "src/test/resources/test.csv";
    private final String testOperand = "+";

    @Test()
    public void testCommandParser() {


        try {
            CommandParser parser = new CommandParser(new String[]{this.testFilePath, this.testOperand});
            assertEquals(this.testFilePath, parser.command);
            assertEquals(this.testOperand.charAt(0), parser.argument);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Test()
    public void testEmptyArgs() {
        assertThrows(
                Exception.class,
                () -> new CommandParser(new String[]{}),
                "Expected two (2) arguments : filePath operand"
        );
    }

    @Test()
    public void testEmptyFilepathCommand() {
        assertThrows(
                Exception.class,
                () -> new CommandParser(new String[]{"", "+"}),
                "File path can't be empty"
        );
    }

    @Test()
    public void testEmptyOperandCommand() {
        assertThrows(
                Exception.class,
                () -> new CommandParser(new String[]{this.testFilePath, ""}),
                "Operand must be one character only"
        );
    }

    @Test()
    public void testInvalidOperandCommand() {
        assertThrows(
                Exception.class,
                () -> new CommandParser(new String[]{this.testFilePath, "xx"}),
                "Operand must be one character only"
        );
    }
}