package org.example.LLD.BookMyShow;

public class Seat {
    private final int number;
    private boolean isAvailable;
    private final SeatType seatType;

    public Seat(int number, SeatType seatType) {
        this.number = number;
        this.seatType = seatType;
        this.isAvailable = true;
    }

    public boolean bookTheSeat(SeatType seatType){
        if(!this.isAvailable)   return false;
        if(this.seatType != seatType)   return false;

        this.isAvailable = false;
        return true;
    }

    public void unblockTheSeat(){
        this.isAvailable = true;
    }

    public int getNumber() {
        return number;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public SeatType getSeatType() {
        return seatType;
    }
}
