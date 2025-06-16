package org.example.Mission_MS.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class P1 {
    //print all duplicate numbers
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 1, 1, 4, 6, 3, 4, 5, 8, 8, 9, 10, 11);
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicate = list.stream()
                .filter(x -> !set.add(x))
                .collect(Collectors.toSet());
        System.out.println(duplicate);

    }
}
