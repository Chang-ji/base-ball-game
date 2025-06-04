package org.example;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private String question;

    public GuessResult guess(String guessNumber) {
        checkForNull(guessNumber);
        checkForThreeLength(guessNumber);
        checkForDigit(guessNumber);
        checkForDuplicate(guessNumber);

        return runToGame(question, guessNumber);
    }

    private void checkForNull(String guessNumber) {
        if (guessNumber == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkForThreeLength(String guessNumber) {
        if (guessNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkForDigit(String guessNumber) {
        for (int i = 0; i < guessNumber.length(); i++) {
            char ch = guessNumber.charAt(i);
            if (ch < '0' || ch > '9') {
                throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다: " + ch);
            }
        }
    }

    private void checkForDuplicate(String guessNumber) {
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < guessNumber.length(); i++) {
            char ch = guessNumber.charAt(i);

            // 중복 검사
            if (seen.contains(ch)) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다: " + ch);
            }

            seen.add(ch);
        }
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    private GuessResult runToGame(String rightNumber, String guessNumber) {
        GuessResult result = new GuessResult();
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (guessNumber.charAt(i) == rightNumber.charAt(i)) {
                strike++;
            } else if (rightNumber.contains(String.valueOf(guessNumber.charAt(i)))) {
                ball++;
            }
        }
        boolean isSolved = (strike == 3);

        result.setStrikes(strike);
        result.setBalls(ball);
        result.setSolved(isSolved);

        return result;
    }
}
