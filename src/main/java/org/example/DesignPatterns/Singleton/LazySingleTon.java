package org.example.DesignPatterns.Singleton;

class LazySingleTon{

    public static LazySingleTon instance;

    private LazySingleTon() {
    }

    /**
     * Drawback is, it is not thread safe
     */
    public static LazySingleTon getInstance(){
        if(instance == null){
            instance = new LazySingleTon();
        }
        return instance;
    }
}
