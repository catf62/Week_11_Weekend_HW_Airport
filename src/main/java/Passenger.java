import java.util.ArrayList;

public class Passenger {
    private ArrayList<Ticket> tickets;

    public Passenger(){
        this.tickets = new ArrayList<>();
    }

    public int ticketCount(){
      return  this.tickets.size();
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public ArrayList<Ticket> getTickets(){
        return this.tickets;
    }
}
