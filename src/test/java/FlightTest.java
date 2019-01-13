import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight1;
    Flight flight2;
    Flight flight3;
    Plane plane1;
    Plane plane2;
    Plane plane3;


    @Before
    public void before(){
        flight1 = new Flight(1, Destination.LHR);
        flight2 = new Flight (2, Destination.EWR);
        flight3 = new Flight (3, Destination.KOI);
        plane1 = new Plane(PlaneType.BOEING747);
        plane2 = new Plane(PlaneType.AIRBUS330);
        plane3 = new Plane(PlaneType.SAAB340);
    }

    @Test
    public void planeStartsAsNull(){
        assertEquals(null, flight1.getAssignedPlane());
    }

    @Test
    public void canAssignPlane(){
        flight2.assignPlane(plane1);
        assertEquals(PlaneType.BOEING747, flight2.getAssignedPlane().getPlaneType());
    }

    @Test
    public void hasFlightNo(){
        assertEquals(3, flight3.getFlightNo());
    }

    @Test
    public void hasDestination(){
        assertEquals(Destination.LHR, flight1.getDestination());
    }

    @Test
    public void canCheckIfPlaneIsAssigned(){
        assertEquals(false, flight2.isPlaneAssigned());
        flight2.assignPlane(plane1);
        assertEquals(true, flight2.isPlaneAssigned());
    }

    @Test
    public void flightPriceStartsAtZero(){
        assertEquals(0, flight1.getPrice(), 0.001);
    }

    @Test
    public void canAddPriceToFlight(){
        flight1.addPriceToFlight(80.00);
        assertEquals(80.00, flight1.getPrice(), 0.0001);
    }
}
