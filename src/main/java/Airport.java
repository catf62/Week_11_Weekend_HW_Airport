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
}
