import org.junit.Before;

public class PassengerTest {

    Airport edinburghAirport;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Flight flight1;
    Flight flight2;
    Flight flight3;
    Plane plane1;
    Plane plane2;
    Plane plane3;
    Ticket ticket1;
    Ticket ticket2;
    Ticket ticket3;


    @Before
    public void before(){
        edinburghAirport = new Airport("EDI");
        flight1 = new Flight(1, Destination.LHR);
        flight2 = new Flight(2, Destination.EWR);
        flight3 = new Flight(3, Destination.KOI);
        plane1 = new Plane(PlaneType.BOEING747);
        plane2 = new Plane(PlaneType.AIRBUS330);
        plane3 = new Plane(PlaneType.SAAB340);
        passenger1 = new Passenger();
        passenger2 = new Passenger();
        passenger3 = new Passenger();
        ticket1 = new Ticket(flight1, 2, 160.00);
        ticket2 = new Ticket(flight2, 1, 350.00);
        ticket3 = new Ticket(flight3, 3, 150.00);

    }
}
