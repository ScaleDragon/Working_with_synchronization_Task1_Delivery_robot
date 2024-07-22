package ru.netology;

import java.util.Map;
import java.util.TreeMap;

import static ru.netology.GenerateRoute.generateRoute;
import static ru.netology.NumberOfRightTurns.numberOfRightTurns;

public class MyThread extends Thread {
    public static final Map<Integer, Integer> sizeToFreq = new TreeMap<>();
    private final static String letters = "RLRFR";
    private final static int length = 100;
    static int maxKey = 0;
    static int maxValue = 0;

    @Override
    public void run() {
        String s = generateRoute(letters, length);
        Integer numberR = numberOfRightTurns(s);

        synchronized (sizeToFreq) {
            if (sizeToFreq.containsKey(numberR)) {
                sizeToFreq.put(numberR, sizeToFreq.get(numberR) + 1);
            } else {
                sizeToFreq.put(numberR, 1);
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
        System.out.println("Самое частое количество повторений " +
                maxKey + " (встретилось  " + maxValue + " раз)");
        sizeToFreq.remove(maxKey);
    }

    public static void CollectionSearchValue() {
        System.out.println("Другие размеры: ");
        for (Integer key : sizeToFreq.keySet()) {
            System.out.println("- " + key + " (" + sizeToFreq.get(key) + " раз)");
        }
    }
}
