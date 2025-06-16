package org.example.Mission_MS.Streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class P8 {
    //min in array
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 0, 6, 0};
        int minIndex = IntStream.range(0, nums.length)
                .reduce((i, j) -> nums[i] <= nums[j] ? i : j)
                .orElse(-1);
        System.out.println(minIndex);
    }
}