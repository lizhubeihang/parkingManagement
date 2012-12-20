package main.java.homework;


import  main.java.homework.*;
import java.util.Collection;


public class GeneralParkingBoy {
    private Collection<ParkPlace> parkPlaces;
    private ParkMethod parkMethod;
    public GeneralParkingBoy(Collection<ParkPlace> parkPlaces) {
        this.parkPlaces=parkPlaces;
    }
    public GeneralParkingBoy(Collection<ParkPlace> parkPlaces,ParkMethod parkStrategy) {
        this.parkPlaces=parkPlaces;
        this.parkMethod=parkMethod;
    }
    public Ticket park(Car car) {
       return parkMethod.getAvailablePark(parkPlaces).parkCar(car);
    }
    public Integer getAvailableNum() {
        int availableNum=0;
        for(ParkPlace parkPlace:parkPlaces){
            availableNum+=parkPlace.getAvailableNum();
        }
        return availableNum;
    }
    public Car fetch(Ticket ticket) {
        Car fetchedCar=null;
        for(ParkPlace parkPlace:parkPlaces){
            fetchedCar=parkPlace.fecthCar(ticket);
            if(fetchedCar!=null){return fetchedCar;}
        }
        throw new NoCarException("ÎÞ´Ë³µ");
    }
    public ParkMethod getParkStrategy() {
        return parkMethod;
    }

    public void setParkStrategy(ParkMethod parkStrategy) {
        this.parkMethod = parkMethod;
    }
}
