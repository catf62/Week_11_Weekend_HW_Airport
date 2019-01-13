import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AirportTest {

    Airport edinburghAirport;
    Flight flight1;
    Plane plane1;
    Plane plane2;
    Plane plane3;

    @Before
    public void before(){

        edinburghAirport = new Airport("EDI");
        flight1 = new Flight(1, Destination.LHR);
        plane1 = new Plane(PlaneType.BOEING747);
        plane2 = new Plane(PlaneType.AIRBUS330);
        plane3 = new Plane(PlaneType.SAAB340);
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


}

