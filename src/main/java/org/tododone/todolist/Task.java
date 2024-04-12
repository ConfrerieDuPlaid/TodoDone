package org.tododone.todolist;

import java.time.LocalDateTime;

public class Task {
    LocalDateTime creation_date;
    String content;
    Boolean done;

    public Task(LocalDateTime creation_date, String content, Boolean done) {
        this.creation_date = creation_date;
        this.content = content;
        this.done = done;
    }

    public static Task create(String content) {
        return new Task(LocalDateTime.now(), content, false);
    }

    public TimeElapsed timeElapsed() {
        return new TimeElapsed(this.creation_date);
    }

    public void setDone(boolean isDone) {
        done = isDone;
    }

    public String toCSVString() {
        return String.format("%s,%s,%s", creation_date.toString(), content, done);
    }
}
