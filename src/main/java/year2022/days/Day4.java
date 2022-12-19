package year2022.days;

import common.Day;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day4 extends Day {

    public Day4() {
        super(4);
    }

    public static void main(String[] args) {
        Day4 day = new Day4();
        List<String> input = day.getInputAsStringList(day.getDefaultInputName());
        List<String> testInput = Arrays.asList(
                "2-4,6-8",
                "2-3,4-5",
                "5-7,7-9",
                "2-8,3-7",
                "6-6,4-6",
                "2-6,4-8");

        System.out.println(test2(input));
    }

    private static int test1(List<String> input) {
        int sum = 0;
        for (String s: input) {
            var pairs = s.split(",");
            var elf1Tasks = getAssignmentRange(pairs[0]);
            var elf2Tasks = getAssignmentRange(pairs[1]);

            if (elf1Tasks.containsAll(elf2Tasks) || elf2Tasks.containsAll(elf1Tasks)) {
                sum++;
            }

        }
        return sum;
    }

    private static int test2(List<String> input) {
        int sum = 0;
        for (String s: input) {
            var pairs = s.split(",");
            var elf1Tasks = new HashSet<Integer>(getAssignmentRange(pairs[0]));
            var elf2Tasks = new HashSet<Integer>(getAssignmentRange(pairs[1]));
            elf1Tasks.retainAll(elf2Tasks);

            if (elf1Tasks.size() > 0) {
                sum++;
            }


        }

        return sum;
    }

    private static List<Integer> getAssignmentRange(String range) {
        var tasks = range.split("-");
        var firstTask = Integer.valueOf(tasks[0]);
        var lastTask = Integer.valueOf(tasks[1]);
        return IntStream.rangeClosed(firstTask, lastTask).boxed().collect(Collectors.toList());
    }


}
