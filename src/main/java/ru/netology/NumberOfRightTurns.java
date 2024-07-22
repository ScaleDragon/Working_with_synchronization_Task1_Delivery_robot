package ru.netology;

public class NumberOfRightTurns {
    private static final char character = 'R';

    public static Integer numberOfRightTurns(String string) {
        Integer number_R = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character) {
                number_R++;
            }
        }
        return number_R;
    }
}
