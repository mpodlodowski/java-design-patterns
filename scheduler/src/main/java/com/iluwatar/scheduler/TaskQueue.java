package com.iluwatar.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TaskQueue {

    private final List<Task> tasks = new ArrayList<>();

    public void add(Task task) {
        tasks.add(task);
    }

    public List<Task> list() {
        return tasks;
    }

    public void remove(Task task) {
        tasks.remove(task);
    }

}
