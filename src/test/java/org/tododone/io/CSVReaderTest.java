package org.tododone.io;

import org.junit.jupiter.api.Test;
import org.tododone.todolist.Task;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {
    private final String testFilePath = "./resources/test.csv";
    private final String expectedLine = "2024-04-12T19:02:27.823102,content,false";

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
            List<Task> tasks = reader.readTasks();
            assertEquals(this.expectedLine, tasks.get(0).toCSVString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}