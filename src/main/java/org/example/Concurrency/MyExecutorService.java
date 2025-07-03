package org.example.Concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Callable<String> callable = () -> {
            System.out.println(Thread.currentThread().getName());
            return "asdf";
        };
        executorService.submit(callable);
        Future<Integer> future = executorService.submit(() -> 42);
        System.out.println(future.get());
    }

    public static void printName(){
        System.out.println(Thread.currentThread().getName());
    }
}
