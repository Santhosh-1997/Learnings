package org.example.Mission_MS.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P5 {
    //frequency of each char in a string
    public static void main(String[] args) {
        String s = "asasasfsasasdaass";
        Map<Character, Long> result = s.chars()
                .mapToObj(a -> (char) a)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
    }
}
