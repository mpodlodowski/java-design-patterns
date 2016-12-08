package com.iluwatar.scheduler;

public abstract class TaskProperty<T> {
    private final T value;

    public TaskProperty(final T value) {
        this.value = value;
    }

    public abstract String getName();
    public T getValue() {
        return value;
    }
}
