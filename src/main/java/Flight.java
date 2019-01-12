public class Flight {
    private Plane assignedPlane;
    private Integer flightNo;
    private Destination destination;

    public Flight (Integer flightNo, Destination destination){
        this.destination = destination;
        this.flightNo = flightNo;
        this.assignedPlane = null;

    }
}
