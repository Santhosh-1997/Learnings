package org.example.Mission_MS.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P13 {

    /*Given a list of Person objects, where each person has a name and age,
    use Java streams to find the names of all people who are above 18 years old
    and collect them into a comma-separated string.*/
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 22),
                new Person("Bob", 17),
                new Person("Charlie", 25),
                new Person("Diana", 16)
        );

        String result = people.stream()
                .filter(p -> p.getAge() > 18)
                .map(Person::getName)
                .collect(Collectors.joining(", "));

        System.out.println(result);


    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

