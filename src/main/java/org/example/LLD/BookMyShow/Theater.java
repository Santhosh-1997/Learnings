package org.example.LLD.BookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Theater {
    private final String name;
    private List<Seat> seats;

    public Theater(String name, List<Seat> seats) {
        this.name = name;
        this.seats = seats;
    }

    public List<Seat> fetchFreeSeats(SeatType seatType){
        return this.seats.stream().filter(seat -> seat.getSeatType().equals(seatType)).collect(Collectors.toList());
    }

    public boolean bookSeat(Map<String, SeatType> requestedSeats){
        Set<String> requestedSeatNumbers = requestedSeats.keySet();
        List<Seat> seats = this.seats.stream().filter(seat -> requestedSeatNumbers.contains(seat.getNumber())).collect(Collectors.toList());
        seats.forEach(s -> s.bookTheSeat(requestedSeats.get(s.getNumber())));
        return true;
    }
}
