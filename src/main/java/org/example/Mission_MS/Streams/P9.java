package org.example.Mission_MS.Streams;

import java.util.*;

public class P9 {
    //find first duplicate element
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 5, 5, 6, 7, 7);
        Set<Integer> seen = new HashSet<>();
        Optional<Integer> firstDup = list.stream()
                .filter(num -> !seen.add(num))
                .findFirst();
        if(firstDup.isPresent())
            System.out.println(firstDup.get());
        else
            System.out.println(-1);
    }
}
