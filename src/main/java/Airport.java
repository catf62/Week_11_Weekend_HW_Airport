import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Airport {

    private ArrayList<Plane> hangars;
    private String airportCode;
    private HashMap<Flight, Double> ticketsSold;

    public Airport(String airportCode){
        this.hangars = new ArrayList<>();
        this.airportCode = airportCode;
        this.ticketsSold = new HashMap<>();
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

    public void addPassengerToFlight(Passenger thisPassenger, Flight thisFlight){
        if(thisFlight.isPlaneAssigned() && thisFlight.getAssignedPlane().doesPlaneHaveCapacityLeft()){
            thisFlight.getAssignedPlane().addPassengerToPlane(thisPassenger);
        }
    }

    public int getLengthOfTicketsSold(){
        return this.ticketsSold.size();
    }

    public HashMap getTicketsSold(){
        return this.ticketsSold;
    }

    public Ticket createNewTicket(Flight thisFlight, Double noSeats){
        double totalPrice = thisFlight.getPrice() * noSeats;
        return new Ticket(thisFlight, noSeats, totalPrice);
    }

    public Integer doubleToInteger(Double thisDouble){
        return thisDouble.intValue();
    }

    public void addTicketToTicketsSold(Ticket thisTicket){
        Double booked = this.ticketsSold.get(thisTicket.getFlight());
        if (booked == null) booked = 0d;
        this.ticketsSold.put(thisTicket.getFlight(), booked + thisTicket.getNoSeatsBooked());
    }

    public void orderPlanesInHangarByCapacity(){
        Collections.sort(this.hangars, new Comparator<Plane>() {
            @Override
            public int compare(Plane o1, Plane o2) {
                return new Integer(o1.getPlaneType().getCapacity()).compareTo(o2.getPlaneType().getCapacity());
            }
        });
    }

    public Flight replaceIfPlaneTooLarge(Flight thisFlight){
        this.orderPlanesInHangarByCapacity();
        if(thisFlight.getAssignedPlane().passengerCount() < thisFlight.getAssignedPlane().getPlaneType().getCapacity()){
            for(Plane plane : this.hangars){
                if(plane.getPlaneType().getCapacity() > thisFlight.getAssignedPlane().passengerCount()){
                    thisFlight.assignPlane(plane);
                    return thisFlight;
                }
            }
        }
        return thisFlight;
    }
}
