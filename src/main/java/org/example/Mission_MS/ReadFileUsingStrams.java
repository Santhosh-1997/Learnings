package org.example.Mission_MS;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFileUsingStrams {
    static String filePath = "/home/santhosh/projects/Learnings/technology.txt";
    public static void main(String[] args) {
        Path path = Paths.get(filePath);
        try {
            Stream<String> lines = Files.lines(path);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Stream.of(1, "a", 3, 5);

    }
}
