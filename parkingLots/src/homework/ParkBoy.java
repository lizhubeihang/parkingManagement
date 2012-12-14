package homework;

import java.util.List;


public class ParkBoy {
    protected List<ParkPlaceExtInfo> parkPlaces;
    private final ParkMethod parkStrategy;

    public ParkBoy(List<ParkPlaceExtInfo> parkPlaces,ParkMethod parkStrategy) {
        this.parkPlaces = parkPlaces;
        this.parkStrategy = parkStrategy;
    }

    public Ticket park(Car car) {
        return parkStrategy.getAvailablePark(parkPlaces).parkCar(car);
    }

    public List<ParkPlaceExtInfo> getParkPlaces()
    {
        return this.parkPlaces;
    }

    public Integer getAvailableNum() {
        int availableNum=0;
        for(ParkPlace parkPlace:parkPlaces){
            availableNum+=parkPlace.getAvailableNum();
        }
        return availableNum;
    }

    public Integer getTotalCapacity() {
        int totalCapacity=0;
        for(ParkPlaceExtInfo parkPlace:parkPlaces){
            totalCapacity+=parkPlace.getTotalCapacity();
        }
        return totalCapacity;
    }

    public Car fetch(Ticket ticket) {
        Car fetchedCar=null;
        for(ParkPlace parkPlace:parkPlaces){
            fetchedCar=parkPlace.fecthCar(ticket);
            if(fetchedCar!=null){return fetchedCar;}
        }
        throw new NoCarException("没有此车");
    }

}
