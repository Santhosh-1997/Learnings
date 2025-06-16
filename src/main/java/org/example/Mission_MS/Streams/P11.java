package org.example.Mission_MS.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P11 {
    //find the sec largest number
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 1, 8, 7, 2, 8, 4);
        Integer ans = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(ans);
    }
}
