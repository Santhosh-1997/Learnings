package org.example.Mission_MS.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P6 {
    //frequency of each element in an array
    public static void main(String[] args) {

        List<String> list = Arrays.asList("test", "test", "click", "click", "clikc", "hi");
        Map<String, Long> ocunt = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(ocunt);

    }
}
