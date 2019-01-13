public class Ticket {

    private Flight flight;
    private double noSeatsBooked;
    private double totalCost;

    public Ticket(Flight flight, Double noSeatsBooked, Double totalCost){
        this.flight = flight;
        this.noSeatsBooked = noSeatsBooked;
        this.totalCost = totalCost;
    }

    public Flight getFlight(){
        return this.flight;
    }

    public double getNoSeatsBooked(){
        return this.noSeatsBooked;
    }

    public double getTotalCost(){
        return this.totalCost;
    }
}
