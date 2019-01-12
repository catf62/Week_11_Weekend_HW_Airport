import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane1;
    Plane plane2;
    Plane plane3;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;

    @Before
    public void before(){
        plane1 = new Plane(PlaneType.BOEING747);
        plane2 = new Plane(PlaneType.AIRBUSA330);
        plane3 = new Plane(PlaneType.SAAB340);
        passenger1 = new Passenger();
        passenger2 = new Passenger();
        passenger3 = new Passenger();

    }

    @Test
    public void canGetPlaneType(){
        assertEquals(PlaneType.BOEING747, plane1.getPlaneType());
    }

    @Test
    public void flightNoStartsAtNull(){
        assertEquals(null, plane2.getFlightNo());
    }

    @Test
    public void canSetFlightNo(){
        plane1.setFlightNo(1);
        assertEquals(1, plane1.getFlightNo().intValue());
    }

    @Test
    public void passengersStartsOffEmpty(){
        assertEquals(0, plane1.passengerCount());
    }

    @Test
    public void canAddPassengersToPlane(){
        plane1.addPassengerToPlane(passenger1);
        assertEquals(1, plane1.passengerCount());
        plane1.addPassengerToPlane(passenger2);
        assertEquals(2, plane1.passengerCount());
        plane1.addPassengerToPlane(passenger3);
        assertEquals(3, plane1.passengerCount());
    }
}
