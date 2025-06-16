package org.example.Mission_MS.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P3 {
    //count no of occurrences of word in string
    public static void main(String[] args) {
        String test = "I am Santhosh and Santhosh is me and She is Janani";
        List<String> string = Arrays.asList(test.split(" "));
        Map<String, Long> wordCount = string.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(wordCount);

    }
}
