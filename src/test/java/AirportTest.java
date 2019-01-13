import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AirportTest {

    Airport edinburghAirport;
    Airport glasgowAirport;
    Flight flight1;
    Flight flight2;
    Flight glaflight1;
    Flight glaflight2;
    Flight glaflight3;
    Plane plane1;
    Plane plane2;
    Plane plane3;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;

    @Before
    public void before(){

        edinburghAirport = new Airport("EDI");
        flight1 = new Flight(1, Destination.LHR);
        flight2 = new Flight(2, Destination.DBR);
        plane1 = new Plane(PlaneType.BOEING747);
        plane2 = new Plane(PlaneType.AIRBUS330);
        plane3 = new Plane(PlaneType.SAAB340);
        passenger1 = new Passenger();
        passenger2 = new Passenger();
        passenger3 = new Passenger();

        glasgowAirport = new Airport("GLA");
        glaflight1 = new Flight(10, Destination.LHR);
        glaflight2 = new Flight(11, Destination.DXB);
        glaflight3 = new Flight(12, Destination.KOI);
        glasgowAirport.addPlaneToHangars(plane1);
        glasgowAirport.addPlaneToHangars(plane2);
        glasgowAirport.addPlaneToHangars(plane3);
        glasgowAirport.assignHangarPlaneToFlight(glaflight1,PlaneType.BOEING747 );
        glasgowAirport.assignHangarPlaneToFlight(glaflight3, PlaneType.SAAB340);
        glasgowAirport.assignPriceToFlight(glaflight1, 80.00);
    }

    @Test
    public void hangarsStartAtZero(){

        assertEquals(0, edinburghAirport.countPlanes());
    }

    @Test
    public void canGetAirportCode(){

        assertEquals("EDI", edinburghAirport.getAirportCode());
    }

    @Test
    public void canCreateNewFlight(){
      assertEquals(2, edinburghAirport.createFlight(2, Destination.EWR).getFlightNo());
    }

    @Test
    public void canAddPlanesToHangars(){
        edinburghAirport.addPlaneToHangars(plane1);
        assertEquals(1, edinburghAirport.countPlanes());
        edinburghAirport.addPlaneToHangars(plane2);
        assertEquals(2, edinburghAirport.countPlanes());
        edinburghAirport.addPlaneToHangars(plane3);
        assertEquals(3, edinburghAirport.countPlanes());
    }

    @Test
    public void canTestIfPlaneOfTypeAvailable(){
        edinburghAirport.addPlaneToHangars(plane1);
        edinburghAirport.addPlaneToHangars(plane2);
        edinburghAirport.addPlaneToHangars(plane3);
        assertEquals(3, edinburghAirport.countPlanes());
//        System.out.println(edinburghAirport.isPlaneOfTypeAvailable(PlaneType.BOEING747));
//        System.out.println(edinburghAirport.getHangars());
        assertEquals(true, edinburghAirport.isPlaneOfTypeAvailable(PlaneType.BOEING747));
        assertEquals(false, edinburghAirport.isPlaneOfTypeAvailable(PlaneType.BOEING787));
    }

    @Test
    public void canReturnAvailablePlaneOfType(){
        edinburghAirport.addPlaneToHangars(plane1);
        edinburghAirport.addPlaneToHangars(plane2);
        edinburghAirport.addPlaneToHangars(plane3);
        assertEquals(3, edinburghAirport.countPlanes());
        assertEquals(PlaneType.BOEING747, edinburghAirport.returnAvailablePlaneOfType(PlaneType.BOEING747).getPlaneType());
        assertEquals(null, edinburghAirport.returnAvailablePlaneOfType(PlaneType.BOEING787));
    }

    @Test
    public void canRemovePlaneFromHangar(){
        edinburghAirport.addPlaneToHangars(plane1);
        edinburghAirport.addPlaneToHangars(plane2);
        edinburghAirport.addPlaneToHangars(plane3);
        assertEquals(3, edinburghAirport.countPlanes());
        edinburghAirport.removePlaneFromHangars(plane1);
        assertEquals(2, edinburghAirport.countPlanes());
    }

    @Test
    public void canAssignHangarPlaneToFlight(){
//        if there are no planes in the hangars should return null
//        add planes to hangars
//        if both plane and flight are available assigned plane should be the Boeing 747
//        if both plane and flight are available the assigned plane should be removed from the hangars
//        if plane type is not available in hangars should return null
//        assign plane to flight
//        if the flight already has a plane assigned should return null
        assertEquals(null, edinburghAirport.assignHangarPlaneToFlight(flight1, PlaneType.BOEING787));
        edinburghAirport.addPlaneToHangars(plane1);
        edinburghAirport.addPlaneToHangars(plane2);
        edinburghAirport.addPlaneToHangars(plane3);
        assertEquals(3, edinburghAirport.countPlanes());
        edinburghAirport.assignHangarPlaneToFlight(flight1, PlaneType.BOEING747);
        assertEquals(PlaneType.BOEING747, flight1.getAssignedPlane().getPlaneType());
        assertEquals(2, edinburghAirport.countPlanes());
        assertEquals(null, edinburghAirport.assignHangarPlaneToFlight(flight1, PlaneType.BOEING787));
        edinburghAirport.assignHangarPlaneToFlight(flight1, PlaneType.BOEING747);
        assertEquals(null, edinburghAirport.assignHangarPlaneToFlight(flight1, PlaneType.AIRBUS330));
    }

    @Test
    public void airportCanAssignPriceToFlight(){
        edinburghAirport.assignPriceToFlight(flight1, 90.00);
        assertEquals(90.00, flight1.getPrice(), 0.001);
    }

    @Test
    public void canAddPassengerToFlight(){
        edinburghAirport.addPlaneToHangars(plane1);
        edinburghAirport.addPlaneToHangars(plane2);
        edinburghAirport.addPlaneToHangars(plane3);
        assertEquals(3, edinburghAirport.countPlanes());
        edinburghAirport.assignHangarPlaneToFlight(flight1, PlaneType.SAAB340);
        assertEquals(0, flight1.getAssignedPlane().passengerCount());
        edinburghAirport.addPassengerToFlight(passenger1, flight1);
//        if plane has capacity
        assertEquals(1, flight1.getAssignedPlane().passengerCount());
        edinburghAirport.addPassengerToFlight(passenger2, flight1);
        assertEquals(2, flight1.getAssignedPlane().passengerCount());
//        if plane is full
        edinburghAirport.addPassengerToFlight(passenger2, flight1);
        assertEquals(2, flight1.getAssignedPlane().passengerCount());
//        if flight has no plane assigned
        assertEquals(null, flight2.getAssignedPlane());
        edinburghAirport.addPassengerToFlight(passenger2, flight1);
        assertEquals(null, flight2.getAssignedPlane());

    }

    @Test
    public void canGetLengthOfTicketsSold(){
        assertEquals(0, edinburghAirport.getLengthOfTicketsSold());
    }

    @Test
    public void canCreateNewTicket(){
        assertEquals(160.00, glasgowAirport.createNewTicket(glaflight1, 2.00).getTotalCost(), 0.001);
    }

    @Test
    public void canAddTicketToTickets(){
       Ticket newTicket = glasgowAirport.createNewTicket(glaflight1, 2);
       glasgowAirport.addTicketToTicketsSold();
    }


}

