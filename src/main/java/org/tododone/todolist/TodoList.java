package org.tododone.todolist;

import java.util.List;

public class TodoList {
    private List<Task> tasks;

    private TodoList(List<Task> tasks){
        this.tasks = tasks;
    }

    public static TodoList of(List<Task> tasks) {
        return new TodoList(tasks);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
