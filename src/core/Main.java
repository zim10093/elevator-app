package core;

import core.model.AbstractHumanContainer;
import core.model.Elevator;
import core.model.Floor;
import core.model.Human;
import core.model.Workable;
import core.services.ElevatorPrinter;
import core.services.FloorDestinationGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int MIN_HEIGHT = 5;
    private static final int ADD_HEIGHT = 15;
    private static final int NUMBER_OF_HUMANS_ON_FLOOR = 10;
    private static final int ELEVATOR_PAYLOAD = 5;
    private static final int ELEVATOR_START_POSITION = 0;
    private static final int NUMBERS_OF_MOVING_CYCLES = 50;

    public static void main(String[] args) {
        Random random = new Random();
        int numberOfFloors = random.nextInt(ADD_HEIGHT + 1) + MIN_HEIGHT;
        FloorDestinationGenerator generator = new FloorDestinationGenerator(random, numberOfFloors);
        List<AbstractHumanContainer> containers = new ArrayList<>();
        for (int i = 0; i <= numberOfFloors; i++) {
            Floor floor = new Floor(i, generator);
            containers.add(floor);
            int numberOfHumans = random.nextInt(NUMBER_OF_HUMANS_ON_FLOOR + 1);
            for (int j = 0; j < numberOfHumans; j++) {
                floor.addHumans(new Human());
            }
        }

        Workable elevator = new Elevator(ELEVATOR_PAYLOAD, containers, ELEVATOR_START_POSITION,
                new ElevatorPrinter());
        elevator.work(NUMBERS_OF_MOVING_CYCLES);
    }
}
