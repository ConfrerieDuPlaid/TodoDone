package org.tododone.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {
    private final String testFilePath = "./resources/test.csv";
    private final String expectedLine = "12/11/2001,content,0";

    @Test()
    public void testInitCSVReader() {
        assertDoesNotThrow(() -> new CSVReader(this.testFilePath));
    }

    @Test()
    public void testInvalidFilePath() {
        assertThrows(Exception.class, () -> new CSVReader("invalid.csv"), "Error opening file invalid.csv");
    }

    @Test()
    public void testReadLine() {
        try {
            CSVReader reader = new CSVReader(this.testFilePath);
            reader.readTasks();
            System.out.println(reader.parseLineToTask());
            assertEquals(this.expectedLine);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}