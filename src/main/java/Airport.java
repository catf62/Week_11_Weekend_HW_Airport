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

    public Plane returnAvailablePlaneOfType(PlaneType thisPlaneType){
        for (Plane plane : this.hangars){
            if(plane.getPlaneType() == thisPlaneType){
                return plane;
            }
        }
        return null;
    }


    public void removePlaneFromHangars(Plane plane){
        this.hangars.remove(plane);
    }

    public Flight assignHangarPlaneToFlight(Flight thisFlight, PlaneType thisPlaneType){
//        if there is a plane of that type in the hangars, and no plane is assigned to the flight,
//          and there are planes in the hangars
//         find the first available plane in the hangars and return it
//         assign the returned plane to the flight
//         remove the assigned plane from the hangars
//         return the flight for testing
        if(this.isPlaneOfTypeAvailable(thisPlaneType) && !thisFlight.isPlaneAssigned() && this.countPlanes() > 0){
          Plane thisPlane = this.returnAvailablePlaneOfType(thisPlaneType);
          thisFlight.assignPlane(thisPlane);
            this.removePlaneFromHangars(thisPlane);
          return thisFlight;
        }
        return null;
    }

    public void assignPriceToFlight(Flight flight, double price) {
        flight.addPriceToFlight(price);
    }
}
