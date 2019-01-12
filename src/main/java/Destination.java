public enum Destination {
    LHR("London Heathrow"),
    DBR("Dubrovnik"),
    EWR("Newark Liberty"),
    DXB("Dubai"),
    KOI("Orkney Kirkwall");

    private final String name;

    Destination(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
