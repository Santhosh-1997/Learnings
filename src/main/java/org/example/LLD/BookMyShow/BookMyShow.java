package org.example.LLD.BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class BookMyShow {
    private static volatile BookMyShow instance;

    private static List<Theater> theaters;
    private BookMyShow() {
        theaters = new ArrayList<>();
    }
    public BookMyShow getInstance(){
        if(instance == null){
            synchronized (BookMyShow.class){
                if(instance == null){
                    instance = new BookMyShow();
                }
            }
        }
        return instance;
    }


}



/*
* List of theaters
*   map of show timing and movies
*   list of Seats
*       seat number
*       booked
*       isPremium
*
* enum
* show timing
*
* */
