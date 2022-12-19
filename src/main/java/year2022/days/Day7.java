package year2022.days;

import common.Day;

import java.util.ArrayList;
import java.util.List;

public class Day7 extends Day {
    public Day7(){
        super(7);
    }

    public static void main(String args[]) {
        Day d = new Day7();
        var input = d.getInputAsStringList(d.getDefaultInputName());
    }

    static int test1(List<String> input) {
        int sum = 0;
        for (String s: input) {

        }

        return sum;
    }

    class Directory {
        String name;
        //List<Directory> subDirectories;
        List<Integer> files;

        public Directory(String name) {
            this.name = name;
            this.files = new ArrayList<Integer>();
        }

        public void addFile(Integer size) {
            this.files.add(size);
        }

        public int sumFiles() {
            int sum = 0;
            for (int i: this.files
                 ) {
                sum += i;
            }
            return sum;
        }

    }

}
