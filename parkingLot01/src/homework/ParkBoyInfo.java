package homework;

public class ParkBoyInfo {
    private String parkBoyName = null;
    private boolean isManager = false;
    public ParkBoyInfo(String parkBoyName)
    {
        this.parkBoyName = parkBoyName;
    }
    public ParkBoyInfo(String parkBoyName,boolean isManager)
    {
        this.isManager = isManager;
        this.parkBoyName = parkBoyName;
    }

    public String getParkBoyName() {
        return parkBoyName;
    }

    public boolean isManager() {
        return isManager;
    }
}
