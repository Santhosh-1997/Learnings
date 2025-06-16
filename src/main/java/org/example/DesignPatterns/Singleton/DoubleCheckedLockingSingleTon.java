package org.example.DesignPatterns.Singleton;


/**
 * It uses volatile keyword as any change to that variable is immediately reflected to other threads.
 * Declaring volatile prevents caching. Every read of this variable goes to main memory.
 */
public class DoubleCheckedLockingSingleTon {
    public static volatile DoubleCheckedLockingSingleTon instance;
    private DoubleCheckedLockingSingleTon() {}

    public static DoubleCheckedLockingSingleTon getInstance(){
        if(instance == null){
            synchronized (DoubleCheckedLockingSingleTon.class){
                if(instance == null){
                    instance = new DoubleCheckedLockingSingleTon();
                }
            }
        }
        return instance;
    }
}
