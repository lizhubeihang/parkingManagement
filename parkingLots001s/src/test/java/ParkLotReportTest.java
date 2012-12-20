package test.java;

import main.java.homework.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ParkLotReportTest {

    private List<ParkBoyInfo> parkBoys = null;

    @Before
    public void init()
    {
        parkBoys = new ArrayList<ParkBoyInfo>();
    }

    private ParkBoy init(String parkNo,String parkName,int maxParkingNum)
    {
        ParkPlaceExtInfo parkPlace=
                new ParkPlaceExtInfo(parkNo,parkName,maxParkingNum);
        ArrayList<ParkPlaceExtInfo> parkPlaces=new ArrayList<ParkPlaceExtInfo>();
        parkPlaces.add(parkPlace) ;
        return new ParkBoy(parkPlaces, new FirstAvailableParkMethod());
    }

    private Integer totalAmount;
    private ParkBoy initMany()
    {
        List<ParkPlaceExtInfo> parkPlaces=new ArrayList<ParkPlaceExtInfo>();
        String[][] parkPlaceStr= new String[][]{{"m001","","20"},{"m002","","30"}};
        totalAmount=0;
        for(String[] parkstr:parkPlaceStr){
            parkPlaces.add(new ParkPlaceExtInfo(parkstr[0],parkstr[1],Integer.parseInt(parkstr[2])));
            totalAmount+=Integer.parseInt(parkstr[2]);
        }
        return new ParkBoy(parkPlaces, new MaxAvailableParkMethod());
    }

   @Test
   public void parkingManager_show_reporter()
   {
    
	  Integer[] integers = new Integer[]{15,50,35,45};
       int index=0;
       ParkManager parkManager = new ParkManager();
       ParkBoyInfo parkBoyInfo=new ParkBoyInfo("小平",true);
       parkManager.addParkBoy(parkBoyInfo,init("001", "", integers[index++].intValue()));
      
       parkBoys.add(parkBoyInfo);

       parkBoyInfo=new ParkBoyInfo("小强",false);
       parkManager.addParkBoy(parkBoyInfo,init("002", "", integers[index++].intValue()));
       parkBoys.add(parkBoyInfo);

       parkBoyInfo=new ParkBoyInfo("小涛");
       parkManager.addParkBoy(parkBoyInfo,init("003", "", integers[index++].intValue()));
       parkBoys.add(parkBoyInfo);

       index=0;
      
       for(ParkBoyInfo parkBoyPerson:parkBoys)
       {
           Car car=new Car();
           ParkBoy parkBoy = parkManager.getParkBoy(parkBoyPerson);
           Ticket ticket = parkBoy.park(car);
      
           Assert.assertEquals(new Integer(integers[index++].intValue() - 1), parkBoy.getAvailableNum());
       }

       parkManager.showParkManagerReporter();

   }

    @Test
    public void parkingboy_show_reporter()
    {
        Integer[] integers = new Integer[]{30,20,10,40};  	
        int index=0;
        ParkManager parkManager = new ParkManager();
        ParkBoyInfo parkBoyInfo=new ParkBoyInfo("小宝");
 
        parkManager.addParkBoy(parkBoyInfo,init("001", "", integers[index++].intValue()));
        parkBoys.add(parkBoyInfo);

        parkBoyInfo=new ParkBoyInfo("小华");
        parkManager.addParkBoy(parkBoyInfo,init("002", "", integers[index++].intValue()));
        parkBoys.add(parkBoyInfo);

        index=0;
        
        for(ParkBoyInfo parkBoyPerson:parkBoys)
        {
            Car car=new Car();
            ParkBoy parkBoy = parkManager.getParkBoy(parkBoyPerson);
            Ticket ticket = parkBoy.park(car);
         
            Assert.assertEquals(new Integer(integers[index++].intValue() - 1), parkBoy.getAvailableNum());
        }

     
        for(ParkBoyInfo parkBoyPerson:parkBoys)
        {
           parkManager.showParkingBoyReporter(parkBoyPerson);
        }

    }


}
