public class Ticket {

    private Flight flight;
    private double noSeatsBooked;
    private double totalCost;

    public Ticket(Flight flight, double noSeatsBooked, double totalCost){
        this.flight = flight;
        this.noSeatsBooked = noSeatsBooked;
        this.totalCost = totalCost;
    }
}
