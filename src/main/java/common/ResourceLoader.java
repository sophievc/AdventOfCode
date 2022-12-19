package main.java.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResourceLoader {
    public static List<String> getInputAsStringList(String resourcePath) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(ResourceLoader.class.getClassLoader().getResourceAsStream(resourcePath)))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Integer> getInputAsIntList(String resourcePath, int defaultValue) {
        List<Integer> numbers = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(ResourceLoader.class.getClassLoader().getResourceAsStream(resourcePath)))) {
            String line;
            while((line = reader.readLine()) != null) {
                try {
                    numbers.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    numbers.add(defaultValue);
                }

            }
            return numbers;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String getInputAsString(String resourcePath) {
        String input = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(ResourceLoader.class.getClassLoader().getResourceAsStream(resourcePath)))) {
            String line;
            while((line = reader.readLine()) != null) {
                input += line;
            }
            return input;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
