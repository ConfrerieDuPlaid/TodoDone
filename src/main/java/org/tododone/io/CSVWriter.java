package org.tododone.io;

import org.tododone.todolist.Task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    private final String filename;

    public CSVWriter(String filename) throws Exception {
        this.filename = filename;
    }

    public void writeTaskList(List<Task> tasks) throws IOException {
        FileWriter file = new FileWriter(filename);
        BufferedWriter writer = new BufferedWriter(file);
        tasks.forEach(task -> {
            try {
                this.writeTask(writer, task);
            } catch (IOException e) {
                throw new RuntimeException("Error writing task to file");
            }
        });
        writer.close();
    }

    public void writeTask(BufferedWriter writer, Task task) throws IOException {
        if (task != null) writer.write(task.toCSVString() + '\n');
    }
}
