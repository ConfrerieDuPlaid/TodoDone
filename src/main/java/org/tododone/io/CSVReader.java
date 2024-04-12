package org.tododone.io;

import java.io.*;

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

    public void readLine() throws Exception {
        try {
            String l = reader.readLine();
            this.line = l != null ? l : "";

        } catch (IOException e) {
            throw new RuntimeException("Error reading file");
        }
    }

//    public Task[] parseIntLine() throws Exception {
//        if (this.line.isEmpty()) throw new Exception("Empty line");
//        String[] taskData = this.line.split(",");
//        if (taskData.length != 3) throw new Exception("Invalid task data");
////        return new Task[] {new Task(new Local(taskData[0].trim()), taskData[1].trim(), taskData[2].trim())};
////        return Arrays.stream(this.line.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
//    }
}
