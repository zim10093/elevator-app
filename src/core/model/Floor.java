package core.model;

import core.services.FloorDestinationGenerator;

public class Floor extends AbstractHumanContainer{
    private final FloorDestinationGenerator generator;
    public Floor(int floor, FloorDestinationGenerator generator) {
        super(floor);
        this.generator = generator;
    }

    public void addHumans(Human human) {
        int destFloor = generator.generate();
        if (destFloor >= currentFloor) {
            human.setDestinationFloor(destFloor + 1);
            putUp(human);
        } else {
            human.setDestinationFloor(destFloor);
            putDown(human);
        }
    }
}
