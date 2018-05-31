package com.kodilla.good.patterns.challenges.flights;

import static java.time.temporal.ChronoUnit.MINUTES;

public class TransferFlight extends Flight {

    private final Flight beforeTransfer;
    private final Flight afterTransfer;
    private final long transferTime;

    public TransferFlight(final Flight beforeTransfer, final Flight afterTransfer){
        super(0, beforeTransfer.getDepartureAirport(),afterTransfer.getArrivalAirport(),
                beforeTransfer.getDepartureTime(), afterTransfer.getArrivalTime());
        this.beforeTransfer = beforeTransfer;
        this.afterTransfer = afterTransfer;
        this.transferTime = beforeTransfer.getArrivalTime().until(afterTransfer.getDepartureTime(),MINUTES);
    }

    @Override
    public String toString(){
        return "\nTransfer flight:\n" + beforeTransfer + "\n" + afterTransfer + "\nTransfer time: "
                + transferTime + " minutes";
    }

}