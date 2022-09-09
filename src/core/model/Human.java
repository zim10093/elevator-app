package core.model;

public class Human {
    private int destinationFloor;
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public String getName() {
        return name;
    }
}
