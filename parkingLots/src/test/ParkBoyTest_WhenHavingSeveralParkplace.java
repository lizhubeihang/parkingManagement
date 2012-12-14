package test;

import homework.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ParkBoyTest_WhenHavingSeveralParkplace {
    private Integer totalAmount;
    private ParkBoy parkBoy;
    private  List<ParkPlaceExtInfo> parkPlacesExtInfo;

    @Before
    public void init(){
        List<ParkPlaceExtInfo> parkPlacesExtInfo=new ArrayList<ParkPlaceExtInfo>();
        String[][] parkPlaceStr= new String[][]{{"001","","10"},{"002","","20"}};
        totalAmount=0;
        for(String[] parkstr:parkPlaceStr){
            parkPlacesExtInfo.add(new ParkPlaceExtInfo(parkstr[0],parkstr[1],Integer.parseInt(parkstr[2])));
            totalAmount+=Integer.parseInt(parkstr[2]);
        }
        parkBoy= new ParkBoy(parkPlacesExtInfo, new MaxAvailableParkMethod());
        this.parkPlacesExtInfo=parkPlacesExtInfo;
    }


    @Test
    public void should_park_Sucess_when_park_is_empty(){
        parkBoy.park(new Car())  ;
        Assert.assertEquals(new Integer(totalAmount - 1), parkBoy.getAvailableNum());
    }

 
    @Test(expected = homework.NoCarException.class)
    public void should_fetch_Sucess_when_park_is_empty(){
        parkBoy.fetch(new Ticket());
    }

    
    @Test
    public void should_fetch_Sucess_when_park_is_notempty(){
        for(int i=0;i<totalAmount/2;i++){
            parkBoy.park(new Car());}
        Car car=new Car();
        Ticket ticket=parkBoy.park(car);
        Assert.assertSame(car,parkBoy.fetch(ticket));
    }

 
    @Test(expected = homework.ParkFullException.class)
    public void should_throwParkFullException_if_park_when_park_is_full(){
        for(int i=0;i<totalAmount;i++){
            parkBoy.park(new Car());}
        parkBoy.park(new Car());
    }

  
    @Test
    public  void should_park_in_the_more_empty_parkplace(){
        parkBoy.park(new Car());
        Assert.assertEquals(19, parkPlacesExtInfo.get(1).getAvailableNum());
    }

    @Test
    public void  should_park_in_the_first_parkplace_if_park_availableSize_same(){
        for(int i=0;i<10;i++){
            parkBoy.park(new Car());}
        parkBoy.park(new Car());
        Assert.assertEquals(9, parkPlacesExtInfo.get(0).getAvailableNum());
    }


}
