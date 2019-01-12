import java.util.ArrayList;

public class Plane {

    private PlaneType planeType;
    private Integer flightNo;
    private ArrayList<Passenger> passengers;

    public Plane(PlaneType planeType){
        this.planeType = planeType;
        this.flightNo = null;
        this.passengers = new ArrayList<>();

    }
}
