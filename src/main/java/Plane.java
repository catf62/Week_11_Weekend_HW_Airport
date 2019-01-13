import java.util.ArrayList;

public class Plane{

    private PlaneType planeType;
    private Integer flightNo;
    private ArrayList<Passenger> passengers;

    public Plane(PlaneType planeType){
        this.planeType = planeType;
        this.flightNo = null;
        this.passengers = new ArrayList<>();

    }

    public PlaneType getPlaneType() {
        return this.planeType;
    }

    public Integer getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(Integer flightNo) {
       this.flightNo = flightNo;
    }

    public int passengerCount() {
       return this.passengers.size();
    }

    public void addPassengerToPlane(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public String toString(){
        return planeType.toString();
    }

    public boolean doesPlaneHaveCapacityLeft(){
        if(this.passengerCount() < this.getPlaneType().getCapacity()){
            return true;
        }
        return false;
    }
}
