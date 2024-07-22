package ru.netology;

import java.util.HashMap;
import java.util.Map;

import static ru.netology.GenerateRoute.generateRoute;
import static ru.netology.NumberOfRightTurns.numberOfRightTurns;

public class MyThread extends Thread {
  public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();
    private final static String letters = "RLRFR";
    private final static int length = 100;

    @Override
    public void run() {
        String s = generateRoute(letters, length);
        Integer numberR = numberOfRightTurns(s);      //возвращает кол-ва "R"
        synchronized (sizeToFreq) {
            if (sizeToFreq.containsKey(numberR)) {
                sizeToFreq.put(numberR, sizeToFreq.get(numberR) + 1);
            } else {
                sizeToFreq.put(numberR, 1);
            }
            sizeToFreq.notify();
        }
    }
}
