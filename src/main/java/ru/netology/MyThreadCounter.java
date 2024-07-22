package ru.netology;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static ru.netology.MyThread.sizeToFreq;

public class MyThreadCounter extends Thread {
    static int maxKey = 0;
    static int maxValue = 0;

    @Override
    public void run() {
        while (!MyThread.interrupted()) {
            synchronized (sizeToFreq) {
                try {
                    sizeToFreq.wait();
                    CollectionSearchMaxValue();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void CollectionSearchMaxValue() {
        for (Integer key : sizeToFreq.keySet()) {
            if (sizeToFreq.get(key) > maxValue) {
                maxValue = sizeToFreq.get(key);
                maxKey = key;
            }
        }
        System.out.println("Текущий лидер среди частот " + maxKey + " (встретилось  " + maxValue + " раз)");
        sizeToFreq.remove(maxKey);
    }

    public static void CollectionSearchValue() {
        System.out.println("Другие размеры: ");
        for (Integer key : sizeToFreq.keySet()) {
            System.out.println("- " + key + " (" + sizeToFreq.get(key) + " раз)");
        }
    }

}