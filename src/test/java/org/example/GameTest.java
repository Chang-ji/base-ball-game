package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

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
    }

    private void assertIllegalArgument(String number) {
        try {
            game.guess(number);
            Assertions.fail();
        } catch (IllegalArgumentException e) {

        }
    }
}