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
        System.out.println(edinburghAirport.isPlaneOfTypeAvailable(PlaneType.BOEING747));
        System.out.println(edinburghAirport.getHangars());
    }

}

