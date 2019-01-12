import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Airport edinburghAirport;

    @Before
    public void before(){
        edinburghAirport = new Airport("EDI");
    }

    @Test
    public void hangarsStartAtZero(){
        assertEquals(0, edinburghAirport.countPlanes());
    }

    @Test
    public void canGetAirportCode(){
        assertEquals("EDI", edinburghAirport.getAirportCode());
    }

}

