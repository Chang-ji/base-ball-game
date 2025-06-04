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
    void throwExceptionWhenInputIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.guess(null);
        });
    }
}