package test.java;

import main.java.homework.*;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class ParkPlaceBoyTest {

    @Test
    public void parkBoy_ShouldParkCar(){
        Car car=new Car();
        int maxParkingNum=20;
        ParkPlaceExtInfo parkPlace=new ParkPlaceExtInfo("1001","1号停车场",maxParkingNum);
        ArrayList<ParkPlaceExtInfo> parkPlaces=new ArrayList<ParkPlaceExtInfo>();
        parkPlaces.add(parkPlace) ;
        ParkBoy parkBoy= new ParkBoy(parkPlaces, new FirstAvailableParkMethod());
        Ticket ticket=parkBoy.park(car);
        Assert.assertEquals(new Integer(maxParkingNum - 1), parkBoy.getAvailableNum());
    }
 
    @Test
    public void parkBoy_ShouldfetchCar(){
        Car car=new Car();
        int maxParkingNum=20;
        ParkPlaceExtInfo parkPlace=new ParkPlaceExtInfo("1001","1号停车场",maxParkingNum);
        ArrayList<ParkPlaceExtInfo> parkPlaces=new ArrayList<ParkPlaceExtInfo>();
        parkPlaces.add(parkPlace) ;
        ParkBoy parkBoy= new ParkBoy(parkPlaces, new FirstAvailableParkMethod());
        Ticket ticket=parkBoy.park(car);
        Assert.assertSame(car,parkBoy.fetch(ticket));


    }


}
