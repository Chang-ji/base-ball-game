package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class GameTest {
    private Game game;

    @BeforeEach
    void setup() {
        game = new Game();
    }

    @Test
    void createBaseBallGame() {
        Assertions.assertNotNull(game);
    }

    @Test
    void throwExceptionWhenInputLengthIsUnmatched() {
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1342");
        assertIllegalArgument("13s");
        assertIllegalArgument("133");
    }

    @Test
    void returnSolvedResultIfMatchNumber() {
        game.setQuestion("123");
        assertMatchNumber(game.guess("123"), true, 3, 0);
    }

    @Test
    void returnSolvedResultIfTwoStrikeZeroBall() {
        game.setQuestion("123");
        assertMatchNumber(game.guess("173"), false, 2, 0);
    }

    @Test
    void returnSolvedResultIfOneStrikeTwoBall() {
        game.setQuestion("123");
        assertMatchNumber(game.guess("132"), false, 1, 2);
    }

    private void assertIllegalArgument(String number) {
        try {
            game.guess(number);
            Assertions.fail();
        } catch (IllegalArgumentException e) {

        }
    }

    private void assertMatchNumber(GuessResult result, boolean isSolved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(isSolved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }
}