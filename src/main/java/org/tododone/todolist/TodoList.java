package org.tododone.todolist;

import org.tododone.commands.Command;

import java.util.List;
import java.util.Map;


public class TodoList {
    private List<Task> tasks;
    private Map<Command, CommandHandler> Bus;
    private TodoList(List<Task> tasks){
        this.tasks = tasks;
    }

    public static TodoList of(List<Task> tasks) {
        return new TodoList(tasks);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
