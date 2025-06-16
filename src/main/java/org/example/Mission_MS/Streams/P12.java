package org.example.Mission_MS.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P12 {
    /*
    * Given a list of strings, write a Java program using streams to
    * filter out strings that start with the letter "a" (case-insensitive)
    * and collect the remaining strings into a new list.*/
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "banana", "Avocado", "grape", "Apricot", "orange");
        List<String> w = words.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).collect(Collectors.toList());
        System.out.println(w);

    }
}
