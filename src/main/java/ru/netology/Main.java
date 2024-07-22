package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int NUMBER_OF_GENERATED_ROUTES = 1000;

    public static void main(String[] args) {

        Thread myThreadCounter = new MyThreadCounter();
        myThreadCounter.start();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_GENERATED_ROUTES; i++) {
            Thread thread = new MyThread();
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        myThreadCounter.interrupt();
        try {
            myThreadCounter.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
