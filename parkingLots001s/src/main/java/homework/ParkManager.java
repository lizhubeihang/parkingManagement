package main.java.homework;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ParkManager {

    private Map<ParkBoyInfo,ParkBoy> parkBoyMap = new HashMap<ParkBoyInfo, ParkBoy>();

    public void addParkBoy(ParkBoyInfo parkBoyInfo,ParkBoy parkBoy)
    {
        this.parkBoyMap.put(parkBoyInfo,parkBoy);
    }
    public ParkBoy getParkBoy(ParkBoyInfo parkBoyInfo)
    {
         return parkBoyMap.get(parkBoyInfo);
    }

    public Map<ParkBoyInfo, ParkBoy> getParkBoyMap() {
        return parkBoyMap;
    }

    private Integer allManageTotalCapacity = 0,allManageAvailableNum = 0;
   
    public void showParkManagerReporter()
    {
        allManageTotalCapacity = 0;
        allManageAvailableNum = 0;
        if(parkBoyMap.isEmpty())
          println(0,"������ͣ��");
        else
        {
            println(0,"------------------------------���ܱ���-----------------------------------");
            ParkBoyInfo[] parkBoyInfos = getParkBoyInfos();


            ParkBoy parkBoy = null;
            List<ParkPlaceExtInfo> parkPlaceExtInfos = null;

            for(int i = 0,m = parkBoyInfos.length;i<m;i++)
            {
                parkBoy = this.getParkBoy(parkBoyInfos[i]);
                if(parkBoyInfos[i].isManager())
                {
        
            if(parkBoy != null)
            {
                parkPlaceExtInfos = parkBoy.getParkPlaces();

                if(parkPlaceExtInfos != null && !parkPlaceExtInfos.isEmpty())
                {
                    for(ParkPlaceExtInfo parkPlaceExtInfo:parkPlaceExtInfos)
                    {
                        allManageAvailableNum += parkPlaceExtInfo.getAvailableNum();
                        allManageTotalCapacity += parkPlaceExtInfo.getTotalCapacity();
                        println(0,"ͣ�������"+parkPlaceExtInfo.getParkPlaceNo());
                        println(8,"��λ����"+parkPlaceExtInfo.getTotalCapacity());
                        println(8,"��λ����"+parkPlaceExtInfo.getAvailableNum());
                    }
                }
              }

            } 
            else
            {
                showParkingBoyReporter(parkBoyInfos[i]);
            }
        } 

            println(0,"���г�λ����"+allManageTotalCapacity);
            println(0,"���п�λ����"+allManageAvailableNum);
      }
    }

    private ParkBoyInfo[] getParkBoyInfos()
    {
        ParkBoyInfo temp = null;
        ParkBoyInfo[] parkBoyInfoArray = parkBoyMap.keySet().toArray(new ParkBoyInfo[parkBoyMap.size()]);
        int index = 0;
        for(int i =0,m = parkBoyInfoArray.length;i<m;i++)
        {
           
            if(parkBoyInfoArray[i].isManager())
            {
                if(i>index)
                {
                  temp = parkBoyInfoArray[index];
                  parkBoyInfoArray[index]=parkBoyInfoArray[i];
                  parkBoyInfoArray[i] = temp;
                }
                index++;
            }
        }

        return parkBoyInfoArray;
    }


    
    public void showParkingBoyReporter(ParkBoyInfo parkBoyInfo)
    {
        Integer allTotalCapacity = 0,allAvailableNum = 0;
        ParkBoy parkBoy = this.getParkBoy(parkBoyInfo);
        List<ParkPlaceExtInfo> parkPlaceExtInfos = parkBoy.getParkPlaces();
        println(0,"-----------ͣ����"+parkBoyInfo.getParkBoyName()+" ����-------------");
        if(parkPlaceExtInfos != null && !parkPlaceExtInfos.isEmpty())
        {
            for(ParkPlaceExtInfo parkPlaceExtInfo:parkPlaceExtInfos)
            {
                allAvailableNum += parkPlaceExtInfo.getAvailableNum();
                allTotalCapacity += parkPlaceExtInfo.getTotalCapacity();
                println(8,"ͣ������ţ�"+parkPlaceExtInfo.getParkPlaceNo());
                println(14,"��λ����"+parkPlaceExtInfo.getTotalCapacity());
                println(14,"��λ����"+parkPlaceExtInfo.getAvailableNum());
            }
            println(8,"����ͣ������λ����"+allTotalCapacity.toString());
            println(8,"����ͣ������λ����"+allAvailableNum.toString());
        }
        allManageTotalCapacity += allTotalCapacity;
        allManageAvailableNum += allAvailableNum;

    }

    private void println(int spaceNum,String content)
    {
        for(int i = 0;i<spaceNum;i++)
           System.out.print(" ");
        System.out.println(content);
    }

}

