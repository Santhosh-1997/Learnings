package org.example.Mission_MS.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P4 {
    //separate odd and even numbers
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Map<Boolean, List<Integer>> result = num.stream()
                .collect(Collectors.partitioningBy(i -> i%2 == 0));
        System.out.println(result);

    }
}
