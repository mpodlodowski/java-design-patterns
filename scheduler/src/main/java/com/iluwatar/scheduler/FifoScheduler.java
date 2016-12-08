package com.iluwatar.scheduler;

import java.util.Optional;

public class FifoScheduler extends Scheduler {

    public FifoScheduler(final TaskQueue taskQueue) {
        super(taskQueue);
    }

    @Override
    protected Optional<Task> pollNext() {
        return taskQueue.list().stream().findFirst();
    }
}
