package org.example.Mission_MS.Streams;

public class P2 {
    //multiply 2 no using functional interface
    public static void main(String[] args) {
        MathOperation multiplyOperation = (a, b) -> a*b;
        MathOperation addOperation = (a, b) -> a+b;
        Integer multiplyTotal = multiplyOperation.operation(4, 5);
        Integer addTodal = addOperation.operation(4, 5);
        System.out.println(addTodal);
        System.out.println(multiplyTotal);

    }
}

@FunctionalInterface
interface MathOperation{
    public Integer operation(int a, int b);
}
