package org.example.Concurrency;

public class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Print new thread " + Thread.currentThread().getName());
    }
}
