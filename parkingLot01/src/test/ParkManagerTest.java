package test;

import homework.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ParkManagerTest {
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
        String[][] parkPlaceStr= new String[][]{{"001","","10"},{"002","","20"}};
        totalAmount=0;
        for(String[] parkstr:parkPlaceStr){
            parkPlaces.add(new ParkPlaceExtInfo(parkstr[0],parkstr[1],Integer.parseInt(parkstr[2])));
            totalAmount+=Integer.parseInt(parkstr[2]);
        }
        return new ParkBoy(parkPlaces, new MaxAvailableParkMethod());
    }

  
    @Test
    public void parkManager_manyParkPlace_ShouldParkCar()
    {
        ParkManager parkManager = new ParkManager();
        ParkBoyInfo parkBoyInfo=new ParkBoyInfo("boy1",true);
        parkManager.addParkBoy(parkBoyInfo,initMany());
        parkBoys.add(parkBoyInfo);

      
        ParkBoy parkBoy = parkManager.getParkBoy(parkBoys.get(0));
        parkBoy.park(new Car());
        System.out.println((totalAmount.intValue() - 1)+":"+parkBoy.getAvailableNum());
        Assert.assertEquals(new Integer(totalAmount - 1), parkBoy.getAvailableNum());

    }

  
  
    @Test(expected = homework.NoCarException.class)
    public void should_fetch_Sucess_when_park_is_empty(){
        ParkManager parkManager = new ParkManager();
        ParkBoyInfo parkBoyInfo=new ParkBoyInfo("boy1");
        parkManager.addParkBoy(parkBoyInfo,initMany());
        parkBoys.add(parkBoyInfo);

        ParkBoy parkBoy = parkManager.getParkBoy(parkBoys.get(0));

        parkBoy.fetch(new Ticket());
    }



    @Test
    public void should_fetch_Sucess_when_park_is_notempty(){

        ParkManager parkManager = new ParkManager();
        ParkBoyInfo parkBoyInfo=new ParkBoyInfo("boy1");
        parkManager.addParkBoy(parkBoyInfo,initMany());
        parkBoys.add(parkBoyInfo);

        ParkBoy parkBoy = parkManager.getParkBoy(parkBoys.get(0));

        for(int i=0;i<totalAmount/2;i++){
            parkBoy.park(new Car());}
        Car car=new Car();
        Ticket ticket=parkBoy.park(car);
        Assert.assertSame(car,parkBoy.fetch(ticket));
    }

  
    @Test(expected = homework.ParkFullException.class)
    public void should_throwParkFullException_if_park_when_park_is_full(){

        ParkManager parkManager = new ParkManager();
        ParkBoyInfo parkBoyInfo=new ParkBoyInfo("boy1");
        parkManager.addParkBoy(parkBoyInfo,initMany());
        parkBoys.add(parkBoyInfo);

        ParkBoy parkBoy = parkManager.getParkBoy(parkBoys.get(0));

        for(int i=0;i<totalAmount;i++){
            parkBoy.park(new Car());}
        parkBoy.park(new Car());
    }

    
    @Test
    public void parkManager_include_self_sub_parkBoy_ShouldParkCar()
    {
        Integer[] integers = new Integer[]{30,40,50,40};
        int index=0;
        ParkManager parkManager = new ParkManager();
        ParkBoyInfo parkBoyInfo=new ParkBoyInfo("boy1");
        parkManager.addParkBoy(parkBoyInfo,init("001", "", integers[index++].intValue()));
        parkBoys.add(parkBoyInfo);

        parkBoyInfo=new ParkBoyInfo("boy2");
        parkManager.addParkBoy(parkBoyInfo,init("002", "", integers[index++].intValue()));
        parkBoys.add(parkBoyInfo);

        parkBoyInfo=new ParkBoyInfo("boy3");
        parkManager.addParkBoy(parkBoyInfo,init("003", "", integers[index++].intValue()));
        parkBoys.add(parkBoyInfo);

        parkBoyInfo=new ParkBoyInfo("myself");
        parkManager.addParkBoy(parkBoyInfo,init("004", "", integers[index++].intValue()));
        parkBoys.add(parkBoyInfo);

        index=0;
        
        for(ParkBoyInfo parkBoyPerson:parkBoys)
        {
            Car car=new Car();
            ParkBoy parkBoy = parkManager.getParkBoy(parkBoyPerson);
            Ticket ticket = parkBoy.park(car);
            System.out.println((index+1)+"、"+(integers[index].intValue()-1)+":"+parkBoy.getAvailableNum());
            Assert.assertEquals(new Integer(integers[index++].intValue()-1),parkBoy.getAvailableNum());
        }
     }

  
    @Test
    public void parkManager_include_self_sub_parkBoy_FetchParkCar()
    {
        Integer[] integers = new Integer[]{10,20,30,40};
        int index=0;
        ParkManager parkManager = new ParkManager();
        ParkBoyInfo parkBoyInfo=new ParkBoyInfo("boy1");
        parkManager.addParkBoy(parkBoyInfo,init("001", "", integers[index++].intValue()));
        parkBoys.add(parkBoyInfo);

        parkBoyInfo=new ParkBoyInfo("boy2");
        parkManager.addParkBoy(parkBoyInfo,init("002", "", integers[index++].intValue()));
        parkBoys.add(parkBoyInfo);

        parkBoyInfo=new ParkBoyInfo("boy3");
        parkManager.addParkBoy(parkBoyInfo,init("003", "", integers[index++].intValue()));
        parkBoys.add(parkBoyInfo);

        parkBoyInfo=new ParkBoyInfo("myself");
        parkManager.addParkBoy(parkBoyInfo,init("004", "", integers[index++].intValue()));
        parkBoys.add(parkBoyInfo);

        index=0;
     
        for(ParkBoyInfo parkBoyPerson:parkBoys)
        {
            Car car=new Car();
            ParkBoy parkBoy = parkManager.getParkBoy(parkBoyPerson);
            Ticket ticket = parkBoy.park(car);
           
            Assert.assertSame(car,parkBoy.fetch(ticket));
        }
    }
}
