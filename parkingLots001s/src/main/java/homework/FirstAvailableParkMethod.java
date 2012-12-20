package main.java.homework;

import java.util.Collection;
import java.util.List;


public class FirstAvailableParkMethod implements ParkMethod{

    @Override
    public ParkPlaceExtInfo getAvailablePark(List<ParkPlaceExtInfo> parks) {
        for(ParkPlaceExtInfo parkPlace:parks){
            if(parkPlace.getAvailableNum()>0)
                return parkPlace;
        }
        throw new ParkFullException("车位满了");
    }

	@Override
	public ParkPlace getAvailablePark(Collection<ParkPlace> parkPlaces) {
		// TODO Auto-generated method stub
		return null;
	}
}
