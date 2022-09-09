package core;

import core.model.AbstractHumanContainer;
import core.model.Elevator;
import core.model.Floor;
import core.model.Human;
import core.model.Workable;
import core.services.FloorDestinationGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int numberOfFloors = random.nextInt(16) + 5;
        FloorDestinationGenerator generator = new FloorDestinationGenerator(random, numberOfFloors);
        List<AbstractHumanContainer> containers = new ArrayList<>();
        for (int i = 0; i <= numberOfFloors; i++) {
            Floor floor = new Floor(i, generator);
            containers.add(floor);
            int numberOfHumans = random.nextInt(11);
            for (int j = 0; j < numberOfHumans; j++) {
                floor.addHumans(new Human("name " + i + ":" + j));
            }
        }
        Workable elevator = new Elevator(5, containers, 0);
        elevator.work(50);
    }
}
