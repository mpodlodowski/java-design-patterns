package com.iluwatar.scheduler;

import java.util.Optional;

public abstract class Scheduler implements Runnable {

    protected final TaskQueue taskQueue;

    public Scheduler(final TaskQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            // take task (policy)
            Optional<Task> next = pollNext();
            if (!next.isPresent()) {
                System.out.println();
                System.out.println("All tasks completed. Bye.");
                return;
            }
            // execute it
            next.ifPresent(taskQueue::remove);
            next.ifPresent(Task::execute);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract Optional<Task> pollNext();
}
