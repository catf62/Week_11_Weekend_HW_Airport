import java.util.ArrayList;

public class Airport {

    private ArrayList<Plane> hangars;
    private String airportCode;

    public Airport(String airportCode){
        this.hangars = new ArrayList<>();
        this.airportCode = airportCode;
    }

    public int countPlanes(){
        return this.hangars.size();
    }

    public String getAirportCode() {
        return this.airportCode;
    }

    public Flight createFlight(Integer flightNo, Destination destination) {
        return new Flight(flightNo, destination);
    }

    public ArrayList<Plane> getHangars(){
        return this.hangars;
    }

    public void addPlaneToHangars(Plane plane) {
        this.hangars.add(plane);
    }

    public boolean isPlaneOfTypeAvailable(PlaneType thisPlaneType) {
        for (Plane plane : this.hangars){
            if(plane.getPlaneType() == thisPlaneType) {
                return true;
            }
        }
        return false;
    }
}
