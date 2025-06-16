package org.example.Mission_MS.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P14 {
    /*
    * Given a list of employee objects, each with a name, department, and salary,
    * use Java streams to group employees by their department
    * and calculate the total salary for each department.*/
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 3000),
                new Employee("Bob", "Engineering", 5000),
                new Employee("Charlie", "HR", 2000),
                new Employee("Diana", "Engineering", 4000),
                new Employee("Eve", "Sales", 3500)
        );

        Map<String, Double> result = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.summingDouble(e -> e.getSalary())));

        System.out.println(result);


    }
}

class Employee {
    String name;
    String department;
    double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

