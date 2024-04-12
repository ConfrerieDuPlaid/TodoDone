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
        System.out.println(tasks.size());
        return new TodoList(tasks);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }


    public List<Task> getTasks() {
        return tasks;
    }

    private void isIndexInTodoList(Integer index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
}
