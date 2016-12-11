package com.iluwatar.scheduler;

public class App {
    public static void main(String... args) throws InterruptedException {
        TaskQueue taskQueue = new TaskQueue();

        taskQueue.add(new Task(() -> System.out.print("J"), new Priority(1)));
        taskQueue.add(new Task(() -> System.out.print("a"), new Priority(2)));
        taskQueue.add(new Task(() -> System.out.print("v"), new Priority(3)));
        taskQueue.add(new Task(() -> System.out.print("a"), new Priority(4)));
        taskQueue.add(new Task(() -> System.out.print("D"), new Priority(5)));
        taskQueue.add(new Task(() -> System.out.print("e"), new Priority(6)));
        taskQueue.add(new Task(() -> System.out.print("s"), new Priority(7)));
        taskQueue.add(new Task(() -> System.out.print("i"), new Priority(8)));
        taskQueue.add(new Task(() -> System.out.print("g"), new Priority(9)));
        taskQueue.add(new Task(() -> System.out.print("n"), new Priority(10)));
        taskQueue.add(new Task(() -> System.out.print("P"), new Priority(11)));
        taskQueue.add(new Task(() -> System.out.print("a"), new Priority(12)));
        taskQueue.add(new Task(() -> System.out.print("t"), new Priority(13)));
        taskQueue.add(new Task(() -> System.out.print("t"), new Priority(14)));
        taskQueue.add(new Task(() -> System.out.print("e"), new Priority(15)));
        taskQueue.add(new Task(() -> System.out.print("r"), new Priority(16)));
        taskQueue.add(new Task(() -> System.out.print("n"), new Priority(17)));
        taskQueue.add(new Task(() -> System.out.print("s"), new Priority(18)));

        new FifoScheduler(taskQueue).run();

        System.out.println();

        taskQueue = new TaskQueue();

        taskQueue.add(new Task(() -> System.out.print("a"), new Priority(2)));
        taskQueue.add(new Task(() -> System.out.print("v"), new Priority(3)));
        taskQueue.add(new Task(() -> System.out.print("e"), new Priority(15)));
        taskQueue.add(new Task(() -> System.out.print("J"), new Priority(1)));
        taskQueue.add(new Task(() -> System.out.print("s"), new Priority(17)));
        taskQueue.add(new Task(() -> System.out.print("P"), new Priority(11)));
        taskQueue.add(new Task(() -> System.out.print("s"), new Priority(7)));
        taskQueue.add(new Task(() -> System.out.print("r"), new Priority(16)));
        taskQueue.add(new Task(() -> System.out.print("g"), new Priority(9)));
        taskQueue.add(new Task(() -> System.out.print("a"), new Priority(12)));
        taskQueue.add(new Task(() -> System.out.print("e"), new Priority(6)));
        taskQueue.add(new Task(() -> System.out.print("t"), new Priority(13)));
        taskQueue.add(new Task(() -> System.out.print("D"), new Priority(5)));
        taskQueue.add(new Task(() -> System.out.print("n"), new Priority(16)));
        taskQueue.add(new Task(() -> System.out.print("n"), new Priority(10)));
        taskQueue.add(new Task(() -> System.out.print("i"), new Priority(8)));
        taskQueue.add(new Task(() -> System.out.print("a"), new Priority(4)));
        taskQueue.add(new Task(() -> System.out.print("t"), new Priority(14)));

        new Thread(new PriorityScheduler(taskQueue)).start();
    }
}
