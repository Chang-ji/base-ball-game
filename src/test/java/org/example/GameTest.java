package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    private void assertIllegalArgument(String number) {
        try {
            game.guess(number);
        } catch (IllegalArgumentException e) {

        }
    }
}