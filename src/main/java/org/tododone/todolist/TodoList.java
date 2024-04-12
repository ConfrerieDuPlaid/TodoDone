package org.tododone.todolist;

import org.tododone.commands.Command;

import java.util.ArrayList;
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

    @Override
    public String toString() {
        ArrayList<String> taskList = new ArrayList<>();
        int i = 1;
        for (Task task : this.tasks) {
            taskList.add("[" + (i < 10 ? '0' : "") + i + "]" + task.toString());
            i++;
        }
        return String.join("\n", taskList);
    }
}
