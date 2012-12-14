package homework;

import java.util.Collection;
import java.util.List;


public class MaxAvailableParkMethod implements ParkMethod {
    @Override
    public ParkPlaceExtInfo getAvailablePark(List<ParkPlaceExtInfo> parks) {
        int maxsizeIndex=0;
        for(int i=1;i< parks.size();i++){
            if(parks.get(i).getAvailableNum()> parks.get(maxsizeIndex).getAvailableNum())
                maxsizeIndex=i;
        }
        if(parks.get(maxsizeIndex).getAvailableNum()==0)
            throw new ParkFullException("无车位");
        return   parks.get(maxsizeIndex);
    }

	@Override
	public ParkPlace getAvailablePark(Collection<ParkPlace> parkPlaces) {
		// TODO Auto-generated method stub
		return null;
	}
}
