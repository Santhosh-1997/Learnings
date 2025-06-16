package org.example.Mission_MS.Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P10 {
    //write a Java program using Streams to group the strings by their lengths and
    // return the group with the maximum number of strings.
    // If multiple groups have the same size, return any one of them.

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "bat", "cat", "dog", "elephant", "ant", "fox", "hat");
        Map<Integer, List<String>> groupByLen = strings.stream()
                .collect(Collectors.groupingBy(x -> x.length()));
        System.out.println(groupByLen);
        List<String> maxGroup = groupByLen.values().stream()
                .max(Comparator.comparingInt(x -> x.size()))
                .orElse(Collections.emptyList());
        System.out.println(maxGroup);

    }
}
