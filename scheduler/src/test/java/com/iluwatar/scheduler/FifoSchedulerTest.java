package com.iluwatar.scheduler;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class FifoSchedulerTest {

    private FifoScheduler fifoScheduler;

    private Task task1 = new Task(() -> {});
    private Task task2 = new Task(() -> {});
    private Task task3 = new Task(() -> {});

    @Test
    public void shouldReturnFirstTask() throws Exception {
        // given
        TaskQueue taskQueue = new TaskQueue();
        taskQueue.add(task1);
        taskQueue.add(task2);
        taskQueue.add(task3);
        fifoScheduler = new FifoScheduler(taskQueue);

        // when
        Optional<Task> task = fifoScheduler.pollNext();

        // then
        assertTrue(task.isPresent());
        assertSame(task1, task.get());
    }

    @Test
    public void shouldWorkForEmptyTaskQueue() throws Exception {
        // given
        TaskQueue taskQueue = new TaskQueue();
        fifoScheduler = new FifoScheduler(taskQueue);

        // when
        Optional<Task> task = fifoScheduler.pollNext();

        // then
        assertFalse(task.isPresent());
    }
}