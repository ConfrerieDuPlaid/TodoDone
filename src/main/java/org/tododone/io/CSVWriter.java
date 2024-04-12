package org.tododone.io;

import org.tododone.todolist.Task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    private final BufferedWriter writer;

    public CSVWriter(String filename) throws Exception {
        try {
            FileWriter file = new FileWriter(filename);
            this.writer = new BufferedWriter(file);
        } catch (Exception e) {
            throw new Exception("Error opening file " + filename);
        }
    }

    public void writeTaskList(List<Task> tasks) throws IOException {
        tasks.forEach(task -> {
            try {
                this.writeTask(task);
            } catch (IOException e) {
                throw new RuntimeException("Error writing task to file");
            }
        });
        this.writer.close();
    }

    public void writeTask(Task task) throws IOException {
        this.writer.write(task.toCSVString() + '\n');
    }
}
