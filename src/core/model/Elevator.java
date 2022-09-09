package core.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Elevator extends AbstractHumanContainer implements Workable {
    private final int maxPayload;
    private final List<AbstractHumanContainer> floors;
    private int destinationFloor;
    private boolean upDirection;

    public Elevator(int maxPayload, List<AbstractHumanContainer> floors, int floor) {
        super(floor);
        this.maxPayload = maxPayload;
        this.floors = floors;
    }

    @Override
    public void work(int cycles) {
        destinationFloor = -1;
        for (int i = 0; i < cycles; i++) {
            exchangeHumans();
            calculateDestinationFloor();
            print(i);
            move();
        }
    }

    private void print(int cycle){
        System.out.println("********* cycle "  + cycle + " *********");
        for (int i = floors.size() - 1; i >= 0; i--) {
            String humansInElevator = getHumans().stream().map(h -> String.valueOf(h.getDestinationFloor()))
                    .collect(Collectors.joining(" "));
            String humansOnFloor = floors.get(i).getHumans().stream().map(h -> String.valueOf(h.getDestinationFloor()))
                    .collect(Collectors.joining(" "));
            if (i == currentFloor) {
                System.out.printf("%2d | %s %15s | %s\n", i,
                        (upDirection ? (char) 8593 : (char) 8595), humansInElevator, humansOnFloor);
            } else {
            System.out.printf("%2d | %18s| %s\n", i, "", humansOnFloor);}
        }
    }

    private void move() {
        if (upDirection) {
            currentFloor++;
        } else {
            currentFloor--;
        }
    }

    private void exchangeHumans() {
        Set<Human> preparedToOutHumans = getPreparedToOutHumans();
        AbstractHumanContainer floor = floors.get(currentFloor);
        if (numbersOfPassengers() == 0) {
            calculateDirection();
        }

        while (numbersOfPassengers() < maxPayload) {
            Human human = upDirection ? floor.removeUp() : floor.removeDown();
            if (human == null) {
                break;
            }
            addHumans(human);
        }

        preparedToOutHumans.forEach(floor::addHumans);
    }

    public void addHumans(Human human) {
        if (human.getDestinationFloor() > currentFloor) {
            putUp(human);
        } else {
            putDown(human);
        }
    }

    private Set<Human> getPreparedToOutHumans() {
        Collection<Human> humans = null;

        if (destinationFloor == -1 ) {
            humans = currentFloor == 0 ? downHumans : upHumans;
        } else {
            humans = upDirection ? upHumans : downHumans;
        }

        Set<Human> sameFloorHumans = humans.stream()
                .filter(h -> h.getDestinationFloor() == currentFloor)
                .collect(Collectors.toSet());
        humans.removeAll(sameFloorHumans);
        return sameFloorHumans;
    }

    private void calculateDestinationFloor() {
        if (upDirection) {
            destinationFloor = upHumans.stream()
                    .mapToInt(Human::getDestinationFloor)
                    .max().orElse(-1);
        } else {
            destinationFloor = downHumans.stream()
                    .mapToInt(Human::getDestinationFloor)
                    .min().orElse(-1);
        }
    }

    private void calculateDirection() {
        AbstractHumanContainer floor = floors.get(currentFloor);
        int difference = floor.upHumans.size() - floor.downHumans.size();
        if (difference > 0) {
            upDirection = true;
        } else if (difference != 0) {
            upDirection = false;
        }
    }

//    private void checkDirection() {
//        if (currentFloor == 0) {
//            upDirection = true;
//        } else if (currentFloor == floors.size() - 1) {
//            upDirection = false;
//        }
//    }
//
//    private void checkDestination() {
//        if (currentFloor == destinationFloor) {
//            destinationFloor = -1;
//        }
//    }

    private int numbersOfPassengers() {
        return upHumans.size() + downHumans.size();
    }
}
