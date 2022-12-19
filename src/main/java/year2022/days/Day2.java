package year2022.days;
import common.Day;
import main.java.common.ResourceLoader;

import java.util.Arrays;
import java.util.List;

public class Day2 extends Day {

    public Day2(int day) {
        super(day);
    }

    public static void main(String[] args) {
        Day2 day = new Day2(2);
        List<String> input = day.getInputAsStringList(day.getDefaultInputName());
        List<String> testInput = Arrays.asList("A Y", "B X", "C Z");
        System.out.println(test1(input));
        System.out.println(test2(input));

    }

    private static int test1(List<String> input) {
        int strategyScore = 0;
        for (String s : input) {
            DrawOptions opMove = getDraw(s.substring(0, 1));
            DrawOptions myMove = getDraw(s.substring(2));
            //System.out.println(opMove.compareTo(myMove));
            //System.out.println(String.format("%s | %s - %s", input.get(i), opMove.name(), myMove.name()));
            if (opMove.compareTo(myMove) == 0) {
                strategyScore += 3 + myMove.score; //draw
            }
            if (opMove.compareTo(myMove) == 1 || opMove.compareTo(myMove) == -2) {
                strategyScore += myMove.score; //loss
            }
            if (opMove.compareTo(myMove) == 2 || opMove.compareTo(myMove) == -1) {
                strategyScore += 6 + myMove.score; //win
            }
        }
        return strategyScore;
    }

    private static int test2(List<String> input ) {
        int strategyScore = 0;

        for (String s : input) {
            DrawOptions opMove = getDraw(s.substring(0, 1));
            String endRound = s.substring(2);
            if (endRound.equals("X")) {
                //need to loose
                DrawOptions myMove = opMove.getLoss();
                strategyScore += myMove.score;
            }
            if (endRound.equals("Y")) {
                //need to draw
                strategyScore += 3 + opMove.score;
            }
            if (endRound.equals("Z")) {
                //need to win
                DrawOptions myMove = opMove.getWin();
                strategyScore += 6 + myMove.score;
            }
        }
        return strategyScore;

    }

    private enum DrawOptions {
        ROCK(1),
        PAPER(2),
        SCISSORS(3);

        final int score;

        DrawOptions(int score) {
            this.score = score;
        }

        public DrawOptions getWin() {
            if (this.name().equals("ROCK")) {
                return PAPER;
            }
            if (this.name().equals("PAPER")) {
                return SCISSORS;
            }
            return ROCK;
        }

        public DrawOptions getLoss() {
            if (this.name().equals("ROCK")) {
                return SCISSORS;
            }
            if (this.name().equals("PAPER")) {
                return ROCK;
            }
            return PAPER;
        }

    }

    private static DrawOptions getDraw(String draw) {
        return switch (draw) {
            case "A", "X" -> DrawOptions.ROCK;
            case "B", "Y" -> DrawOptions.PAPER;
            case "C", "Z" -> DrawOptions.SCISSORS;
            default -> null;
        };
    }

}
