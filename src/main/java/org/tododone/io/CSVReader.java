package org.tododone.io;

import org.tododone.todolist.Task;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private final String filename;

    public CSVReader(String filename) throws Exception {
        this.filename = filename;
    }

    public List<Task> readTasks() throws IOException {
        ArrayList<Task> tasks = new ArrayList<>(List.of());
        Task task = null;
        try {
            FileReader input = new FileReader(this.filename);
            BufferedReader reader = new BufferedReader(input);
            do {
                task = this.parseLineToTask(reader);
                if (task != null) tasks.add(task);
            } while (task != null);
            reader.close();
        } catch (Exception e) {
            throw new IOException("Error reading file : " + e.getMessage());
        }
        return tasks;
    }

    public Task parseLineToTask(BufferedReader reader) throws IOException {
        String l = reader.readLine();
        if (l == null || l.trim().isEmpty()) return null;
        String[] taskData = l.split(",");
        if (taskData.length != 3) return null;
        return new Task(LocalDateTime.parse(taskData[0]), taskData[1].trim(), Integer.parseInt(taskData[2]) == 1);
    }
}
