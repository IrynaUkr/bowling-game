package org.example;

public class BowlingGame {
    public static final String SPARE_SIGN = "/";
    public static final String STRIKE_SIGN = "X";
    public static final int MAX_TURNS_GAME = 10;
    public static final String MISS_SIGN = "-";
    String[] frames;

    public int score(String scoreLine) {
        frames = getFrames(scoreLine);
        int totalScore = 0;
        for (int i = 0; i < MAX_TURNS_GAME; i++) {
            int frameScore = 0;
            if (isStrike(frames[i])) {
                frameScore = 10 + getStrikeBonus(i);
            } else if (isSpare(frames[i])) {
                frameScore = 10 + getSpareBonus(i);
            } else if (frames[i].length() == 2) {
                frameScore = scoreCurrentCouple(i);
            }
            totalScore += frameScore;
        }
        return totalScore;
    }

    private static String[] getFrames(String scoreLine) {
        return scoreLine.replaceAll(MISS_SIGN, "0").split("\\s+");
    }

    private int getStrikeBonus(int i) {
        if (i == frames.length - 1) {
            return 0;
        }
        if (i == frames.length - 2) {
            return scoreCurrentCouple(i + 1);
        } else {
            return scoreCurrentCouple(i + 1) + scoreCurrentCouple(i + 2);
        }
    }

    private int getSpareBonus(int i) {
        String frame = frames[i + 1];
        if (isStrike(frame)) {
            return 10;
        } else {
            return frames[i + 1].charAt(0) - 48;
        }
    }

    private int scoreCurrentCouple(int i) {
        if (frames[i].length() == 2) {
            return (frames[i].charAt(0) - '0') + (frames[i].charAt(1) - '0');
        } else {
            return 10;
        }
    }

    private static boolean isStrike(String frame) {
        return frame.matches(STRIKE_SIGN);
    }

    private static boolean isSpare(String frame) {
        return frame.contains(SPARE_SIGN);
    }

}