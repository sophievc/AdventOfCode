package year2022.days;

import common.Day;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.*;

public class Day5 extends Day {

    public Day5() {
        super(5);
    }

    public static void main(String[] args) {
        Day5 day = new Day5();
        List<String> input = day.getInputAsStringList(day.getDefaultInputName());
        //System.out.println(test1(input));
        System.out.println(test2(input));

    }

    public static String test1(List<String> input) {
        Map<String, Stack> map = new HashMap<String, Stack>();
        String stackNames = input.get(8);
        System.out.println(stackNames);
        for (int i=7; i >= 0; i--) {
            System.out.println(i);
            for (int j=0; j< input.get(i).length(); j++) {
                if (Pattern.compile("[A-Z]").matcher(Character.toString(input.get(i).charAt(j))).matches() ) {
                    if (map.get(Character.toString(stackNames.charAt(j))) == null) {
                        Stack<Character> stack = new Stack<>();
                        stack.push(input.get(i).charAt(j));
                        map.put(Character.toString(stackNames.charAt(j)), stack);
                    } else {
                        map.get(Character.toString(stackNames.charAt(j))).push(input.get(i).charAt(j));
                    }
                }
            }
        }
        for (Stack s : map.values()) {
            System.out.println(s);
        }
        for (int i = 10; i < input.size(); i++) {
            var row = input.get(i).split(" ");
            int amount = Integer.parseInt(row[1]);
            String source = row[3];
            String target = row[5];
            for (int j=0; j < amount; j++) {
                var box = map.get(source).pop();
                map.get(target).push(box);
            }
        }
        var boxes = "";
        for (Stack s: map.values()) {
            boxes += s.peek();
        }

        return boxes;
    }

    public static String test2(List<String> input) {
        Map<String, Stack> map = new HashMap<String, Stack>();
        String stackNames = input.get(8);
        for (int i=7; i >= 0; i--) {
            for (int j=0; j< input.get(i).length(); j++) {
                if (Pattern.compile("[A-Z]").matcher(Character.toString(input.get(i).charAt(j))).matches() ) {
                    if (map.get(Character.toString(stackNames.charAt(j))) == null) {
                        Stack<Character> stack = new Stack<>();
                        stack.push(input.get(i).charAt(j));
                        map.put(Character.toString(stackNames.charAt(j)), stack);
                    } else {
                        map.get(Character.toString(stackNames.charAt(j))).push(input.get(i).charAt(j));
                    }
                }
            }
        }
        for (int i = 10; i < input.size(); i++) {
            var row = input.get(i).split(" ");
            int amount = Integer.parseInt(row[1]);
            String source = row[3];
            String target = row[5];
            Stack<Object> temp = new Stack<>();
            for (int j=0; j < amount; j++) {
                var box = map.get(source).pop();
                temp.push(box);
            }

            while (!temp.empty()) {
                map.get(target).push(temp.pop());
            }
        }
        var boxes = "";
        for (Stack s: map.values()) {
            boxes += s.peek();
        }

        return boxes;
    }
}
