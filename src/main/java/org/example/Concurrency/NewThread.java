package org.example.Concurrency;

public class NewThread {
    public static void main(String[] args) {
        System.out.println("Current thread is " + Thread.currentThread().getName());
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start();
    }
}

