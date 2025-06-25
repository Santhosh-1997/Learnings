package org.example.Concurrency;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("New thread via callable " + Thread.currentThread().getName());
        return "Done";
    }
}
