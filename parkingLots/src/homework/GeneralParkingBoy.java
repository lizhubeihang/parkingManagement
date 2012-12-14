package homework;


import homework.*;
import java.util.Collection;


public class GeneralParkingBoy {
    private Collection<ParkPlace> parkPlaces;
    private ParkMethod parkStrategy;
    public GeneralParkingBoy(Collection<ParkPlace> parkPlaces) {
        this.parkPlaces=parkPlaces;
    }
    public GeneralParkingBoy(Collection<ParkPlace> parkPlaces,ParkMethod parkStrategy) {
        this.parkPlaces=parkPlaces;
        this.parkStrategy=parkStrategy;
    }
    public Ticket park(Car car) {
       return parkStrategy.getAvailablePark(parkPlaces).parkCar(car);
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
        throw new NoCarException("没有此车");
    }
    public ParkMethod getParkStrategy() {
        return parkStrategy;
    }

    public void setParkStrategy(ParkMethod parkStrategy) {
        this.parkStrategy = parkStrategy;
    }
}
