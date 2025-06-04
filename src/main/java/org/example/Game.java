package org.example;

public class Game {

    public void guess(String guessNumber) {
        if (guessNumber == null) {
            throw new IllegalArgumentException();
        }

        if (guessNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < guessNumber.length(); i++) {
            char ch = guessNumber.charAt(i);
            if (ch < '0' || ch > '9') {
                throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다: " + ch);
            }
        }
    }
}
