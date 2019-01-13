import java.util.ArrayList;

public class Passenger {
    private ArrayList<Ticket> tickets;

    public Passenger(){
        this.tickets = new ArrayList<>();
    }

    public int ticketCount(){
      return  this.tickets.size();
    }
}
