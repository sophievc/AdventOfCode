package year2022.days;

import common.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 extends Day {

    public Day3() {
        super(3);
    }

    public static void main(String[] args) {
        Day3 day = new Day3();
        List<String> input = day.getInputAsStringList(day.getDefaultInputName());
        List<String> testInput = Arrays.asList(
                "vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg",
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                "ttgJtRGJQctTZtZT",
                "CrZsJsPPZsGzwwsLwLmpwMDw");

        //System.out.println(test1(input));
        System.out.println(test2(input));

    }

    private static int test1(List<String> input) {
        int sumOfPriorities = 0;
        for (String s: input) {
            char commonItem = getCommonItemType(s);
            int priority = getItemPriority(commonItem);
            //System.out.println(String.format("Item %s. Prio: %d", commonItem, priority));
            sumOfPriorities += priority;
        }
        return sumOfPriorities;
    }

    private static int test2(List<String> input) {
        var priotitySum = 0;
        for (int i=0; i < input.size()-2; i = i+3) {
            char commonType = getCommonItemTypeNew(input.get(i), input.get(i+1), input.get(i+2));
            int priority = getItemPriority(commonType);
            priotitySum += priority;
        }
        return priotitySum;
    }


    private static int getItemPriority(char letter) {
        final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return(alphabet.indexOf(letter)+1);
    }

    private static char getCommonItemTypeNew(String str1, String str2, String str3) {
        HashSet<Character> commonChars = new HashSet<>();

        for (int i=0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (str2.indexOf(c) >= 0 && str3.indexOf(c) >= 0 && !commonChars.contains(c)) {
                commonChars.add(c);
            }
        }
        List<Character> list = new ArrayList<Character>(commonChars);
        return list.get(0);

    }

    private static char getCommonItemType(String items) {
        int limit = items.length()/2;
        String firstComp = items.substring(0, limit);
        String secondComp = items.substring(limit);
        for (int i=0; i< firstComp.length(); i++) {
            for (int j=0; j< secondComp.length(); j++) {
                if (firstComp.charAt(i) == secondComp.charAt(j)) {
                    return firstComp.charAt(i);
                }
            }

        }
        System.out.println(String.format("WARNING. %s does not have a common type", items));
        return 0;
    }


}
