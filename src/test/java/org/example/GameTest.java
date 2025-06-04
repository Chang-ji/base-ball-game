package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    void createBaseBallGame() {
        Game game = new Game();
        Assertions.assertNotNull(game);
    }

    @Test
    void throwExceptionWhenInputIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.guess(null);
        });
        Game game = new Game();
        Assertions.assertNotNull(game);
    }
}