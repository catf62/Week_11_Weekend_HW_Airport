public enum PlaneType {

    BOEING747(10),
    AIRBUS330(4),
    SAAB340(2),
    BOEING787(335);

    private final int capacity;

    PlaneType(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity(){
        return this.capacity;
    }
}
