package com.iluwatar.scheduler;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class PrioritySchedulerTest {

    private PriorityScheduler priorityScheduler;
    private TaskQueue taskQueue;

    private Task highPriorityTask = new Task(() -> {}, new Priority(1));
    private Task midPriorityTask = new Task(() -> {}, new Priority(5));
    private Task lowPriorityTask = new Task(() -> {}, new Priority(10));

    @Test
    public void shouldReturnTaskWithHighestPriority() throws Exception {
        // given
        taskQueue = new TaskQueue();
        taskQueue.add(lowPriorityTask);
        taskQueue.add(midPriorityTask);
        taskQueue.add(highPriorityTask);
        priorityScheduler = new PriorityScheduler(taskQueue);

        // when
        Optional<Task> task = priorityScheduler.pollNext();

        // then
        assertTrue(task.isPresent());
        assertSame(highPriorityTask, task.get());
    }

    @Test
    public void shouldWorkForEmptyTaskQueue() throws Exception {
        // given
        taskQueue = new TaskQueue();
        priorityScheduler = new PriorityScheduler(taskQueue);

        // when
        Optional<Task> task = priorityScheduler.pollNext();

        // then
        assertFalse(task.isPresent());

    }
}