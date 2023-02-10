package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 2)
    void shouldReturnTheValidScore(String input, int expected) {
        BowlingGame game = new BowlingGame();
        int actualScore = game.score(input);

        assertEquals(expected, actualScore);
    }
}