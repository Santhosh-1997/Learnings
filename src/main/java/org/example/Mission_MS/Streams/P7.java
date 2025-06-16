package org.example.Mission_MS.Streams;

import java.util.Arrays;
import java.util.List;

public class P7 {
    //max num in the list
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Integer max = num.stream()
                .max(Integer::compare).get();
        System.out.println(max);
    }
}
