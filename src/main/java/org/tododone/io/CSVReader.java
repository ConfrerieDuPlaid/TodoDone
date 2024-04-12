package org.tododone.io;

import org.tododone.todolist.Task;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private final BufferedReader reader;
    private String line = "";

    public CSVReader(String filename) throws Exception {
        try {
            InputStream inputStream = new FileInputStream(filename);
            this.reader = new BufferedReader(new InputStreamReader(inputStream));
        } catch (IOException e) {
            throw new Exception("Error opening file " + filename);
        }
    }

    public List<Task> readTasks() throws IOException {
        ArrayList<Task> tasks = new ArrayList<>(List.of());
        Task task = null;
        try {
            do {
                task = this.parseLineToTask();
                tasks.add(task);
            } while (task != null);
        } catch (Exception e) {
            throw new IOException("Error reading file : " + e.getMessage());
        }
        return tasks;
    }

    public Task parseLineToTask() throws IOException {
        String l = reader.readLine();
        if (l == null || l.trim().isEmpty()) return null;
        String[] taskData = l.split(",");
        if (taskData.length != 3) return null;
        return new Task(LocalDateTime.parse(taskData[0]), taskData[1].trim(), Integer.parseInt(taskData[2]) == 1);
    }
}
