package main.java.homework;
import  main.java.homework.ParkPlace;

import java.util.Collection;
import java.util.List;


public interface ParkMethod {
    ParkPlace getAvailablePark(Collection<ParkPlace> parkPlaces);

	ParkPlace getAvailablePark(List<ParkPlaceExtInfo> parkPlaces);
}
