package year2022.days;

import common.Day;
import main.java.common.ResourceLoader;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 extends Day{
    public Day1(int day) {
        super(day);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Day d = new Day1(1);
        List<Integer> input = ResourceLoader.getInputAsIntList("Day1.txt", -1);
        System.out.println(test1(input));
        System.out.println(test2(input));

    }

    private static int test1(List<Integer> input) {
        List<Integer> calories = new ArrayList<>();
        Integer elfCalSum = 0;
        for (int i=0;i < input.size();i++) {
            if (input.get(i) > -1) {
                elfCalSum += input.get(i);
            }else{
                calories.add(elfCalSum);
                elfCalSum = 0;
            }

        }
        return Collections.max(calories);
    }

    private static int test2(List<Integer> input) {
        List<Integer> calories = new ArrayList<>();
        Integer elfCalSum = 0;
        for (int i=0;i < input.size();i++) {
            if (input.get(i) > -1) {
                elfCalSum += input.get(i);
            }else{
                calories.add(elfCalSum);
                elfCalSum = 0;
            }

        }
        int i = 0;
        int topThreeSum = 0;
        while(i < 3) {
            int currMax = Collections.max(calories);
            topThreeSum += currMax;
            int idx = calories.indexOf(currMax);
            calories.remove(idx);
            i ++;
        }
        return topThreeSum;
    }


}

