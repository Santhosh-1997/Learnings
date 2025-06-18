package org.example.MultiThreading.WaitAndNotify;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread evenThread = new Thread(counter::incrementEven);
        Thread oddThread = new Thread(counter::incrementOdd);
        evenThread.start();
        oddThread.start();
    }
}

class Counter{
    private int count = 0;
    int max = 10;
    public synchronized void incrementEven() {
        while(count < max){
            while(count % 2 != 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(count < max){
                System.out.println(count);
                count++;
                notify();
            }
        }
    }

    public synchronized void incrementOdd(){
        while(count < max){
            while(count % 2 == 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(count);
            count++;
            notify();
        }
    }
}
