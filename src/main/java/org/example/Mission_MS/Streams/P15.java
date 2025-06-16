package org.example.Mission_MS.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P15 {
    /*
    * Given a list of integers, use Java streams to
    * find the top 3 highest unique numbers in the list
    * and return them as a list in descending order.*/
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 9, 3, 7, 8, 9, 7, 2);
        List<Integer> result = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
        System.out.println(result);


    }
}
