package com.iluwatar.scheduler;

public class App {
    public static void main(String... args) throws InterruptedException {
//        TaskQueue taskQueue = new TaskQueue();
//
//        taskQueue.add(new Task(() -> System.out.println(6)));
//        taskQueue.add(new Task(() -> System.out.println(0)));
//        taskQueue.add(new Task(() -> System.out.println(3)));
//        taskQueue.add(new Task(() -> System.out.println(2)));
//        taskQueue.add(new Task(() -> System.out.println(3)));
//        taskQueue.add(new Task(() -> System.out.println(2)));
//        taskQueue.add(new Task(() -> System.out.println(3)));
//        taskQueue.add(new Task(() -> System.out.println(3)));
//        taskQueue.add(new Task(() -> System.out.println(5)));
//
//        new FifoScheduler(taskQueue).run();

        TaskQueue taskQueue = new TaskQueue();

        taskQueue.add(new Task(() -> System.out.println(0), new Priority(2)));
        taskQueue.add(new Task(() -> System.out.println(3), new Priority(3)));
        taskQueue.add(new Task(() -> System.out.println(6), new Priority(1)));
        taskQueue.add(new Task(() -> System.out.println(3), new Priority(7)));
        taskQueue.add(new Task(() -> System.out.println(5), new Priority(9)));
        taskQueue.add(new Task(() -> System.out.println(2), new Priority(6)));
        taskQueue.add(new Task(() -> System.out.println(3), new Priority(5)));
        taskQueue.add(new Task(() -> System.out.println(3), new Priority(8)));
        taskQueue.add(new Task(() -> System.out.println(2), new Priority(4)));

        new Thread(new PriorityScheduler(taskQueue)).start();

        Thread.sleep(3000);
        taskQueue.add(new Task(() -> System.out.println("KABOOOM very important task"), new Priority(1)));

    }
}
