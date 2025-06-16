package org.example.DesignPatterns.Singleton;

/**
 * synchronization makes sure that only one thread using
 * the method
 * but there will be performance issue as more threads try to
 * call getInstance() method
 */
public class ThreadSafeSingleTon {
    public static ThreadSafeSingleTon instance;

    private ThreadSafeSingleTon() {
    }

    public static synchronized ThreadSafeSingleTon getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleTon();
        }
        return instance;
    }
}
