public class Flight {
    private Plane assignedPlane;
    private Integer flightNo;
    private Destination destination;
    private double price;

    public Flight (Integer flightNo, Destination destination){
        this.destination = destination;
        this.flightNo = flightNo;
        this.assignedPlane = null;
        this.price = 0;

    }

    public Plane getAssignedPlane(){

        return this.assignedPlane;
    }

    public void assignPlane(Plane plane) {

        this.assignedPlane = plane;
    }

    public boolean isPlaneAssigned(){
        if (this.assignedPlane != null){
            return true;
        }
            return false;
    }

    public int getFlightNo() {
        return this.flightNo;
    }

    public Destination getDestination() {
        return this.destination;
    }

    public double getPrice(){
        return this.price;
    }

    public void addPriceToFlight(double price){
        this.price = price;
    }

}
