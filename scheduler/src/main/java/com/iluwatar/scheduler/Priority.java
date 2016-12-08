package com.iluwatar.scheduler;

public class Priority extends TaskProperty<Integer> {
    public Priority(final Integer value) {
        super(value);
    }

    @Override
    public String getName() {
        return "priority";
    }
}
