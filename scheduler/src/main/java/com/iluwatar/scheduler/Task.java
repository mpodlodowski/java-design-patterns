package com.iluwatar.scheduler;

import java.util.Arrays;
import java.util.List;

public class Task {

    private final Runnable runnable;
    private final List<TaskProperty> properties;

    public Task(final Runnable runnable, final TaskProperty... properties) {
        this.runnable = runnable;
        this.properties = Arrays.asList(properties);
    }

    public Task(final Runnable runnable) {
        this(runnable, null);
    }

    public void execute() {
        runnable.run();
    }

    public List<TaskProperty> getProperties() {
        return properties;
    }
}
