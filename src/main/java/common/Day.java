package common;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import main.java.common.ResourceLoader;


public abstract class Day {
    protected final int day;
    protected int example = 0;

    public Day(int day) {
        this.day = day;
    }

    public String getDefaultInputName() {
        return String.format("Day%d.txt", this.day);
    }

    public List<String> getInputAsStringList(String resourcePath) {
        return ResourceLoader.getInputAsStringList(resourcePath);
    }

    public List<Integer> getInputAsIntList(String resourcePath, int valueIfEmpty) {
        return ResourceLoader.getInputAsIntList(resourcePath, valueIfEmpty);
    }

    public String getinputAsString(String resourcePath) {
        return ResourceLoader.getInputAsString(resourcePath);
    }

}
