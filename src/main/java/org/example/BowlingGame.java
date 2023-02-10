package org.example;

public class BowlingGame {


    public static final int MAX_GAMES_TURNS = 10;

    public int score(String scoreLine) {
        String[] frames = scoreLine.split("\\s+");
        int gameScore = 0;
        //strike
        //spare


        for (int i = 0; i < MAX_GAMES_TURNS; i++) {
            int frameScore = 0;
            if (frames[i].contains("/")) {
                frameScore = 10 + frames[i + 1].charAt(0) - '0';
            } else {

                frameScore = frames[i].charAt(0) - '0' + frames[i].charAt(1) - '0';

            }
            gameScore += frameScore;
        }
        return gameScore;

    }

}