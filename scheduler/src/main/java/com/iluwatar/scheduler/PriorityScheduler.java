package com.iluwatar.scheduler;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class PriorityScheduler extends Scheduler {

    public PriorityScheduler(final TaskQueue taskQueue) {
        super(taskQueue);
    }

    @Override
    protected Optional<Task> pollNext() {
        return taskQueue.list().stream().min(new TaskPriorityComparator());
    }

    private static class TaskPriorityComparator implements Comparator<Task> {
        private static final Predicate<TaskProperty> isPriority = property -> property instanceof Priority;
        private static final Function<TaskProperty, Priority> toPriority = property -> (Priority) property;
        @Override
        public int compare(final Task t1, final Task t2) {
            Priority p1 = t1.getProperties().stream().filter(isPriority).map(toPriority).findFirst().orElseThrow(IllegalArgumentException::new);
            Priority p2 = t2.getProperties().stream().filter(isPriority).map(toPriority).findFirst().orElseThrow(IllegalArgumentException::new);
            return p1.getValue() - p2.getValue();
        }
    }
}
