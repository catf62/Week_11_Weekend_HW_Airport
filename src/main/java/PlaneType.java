public enum PlaneType {

    BOEING747(10),
    AIRBUSA330(4),
    SAAB340(2);

    private final int capacity;
    
    PlaneType(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity(){
        return this.capacity;
    }
}
