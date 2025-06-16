package org.example.Mission_MS.Comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Comparator {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Alice", 22),
                new Person("Bob", 30)
        );

        Collections.sort(people, new PersonAgeComparator());
        System.out.println(people);
    }
}

class PersonAgeComparator implements java.util.Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.age, o2.age);
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
