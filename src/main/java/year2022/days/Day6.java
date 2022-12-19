package year2022.days;

import common.Day;

import java.util.HashSet;

public class Day6 extends Day {

    public Day6() {
        super(6);
    }

    public static void main(String args[]) {
        Day6 d = new Day6();
        var input = d.getinputAsString(d.getDefaultInputName());
        var testInput = "bvwbjplbgvbhsrlpgdmjqwftvncz";
        //System.out.println(test1(input));
        System.out.println(test2(input));

    }

    static int test1(String input) {
        int loc = 0;

        for (int i = 3; i < input.length(); i++) {
            String packet = input.substring(i-3, i+1);
            if (cntDistinct(packet) == 4) {
                loc = i+1;
                break;
            }
        }
        return loc;
    }

    static int test2(String input) {

        for (int i=13; i<input.length(); i++) {
            String startOfMessage = input.substring(i-13, i+1);
            if (cntDistinct(startOfMessage) == 14) {
                return i+1;
            }
        }
        return -1;
    }

    static int cntDistinct(String str) {
        HashSet<Character> s = new HashSet<Character>();
        for(int i = 0; i < str.length(); i++)
        {
            // Insert current character
            // into the set
            s.add(str.charAt(i));
        }

        // Return Answer
        return s.size();
    }
}
