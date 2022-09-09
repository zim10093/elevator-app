package core.services;

import core.model.AbstractHumanContainer;
import java.util.List;
import java.util.stream.Collectors;

public class ElevatorPrinter {
    private static final char UP_ARROW = (char) 8593;
    private static final char DOWN_ARROW = (char) 8595;
    private List<AbstractHumanContainer> floors;
    private AbstractHumanContainer elevator;

    public void setFloors(List<AbstractHumanContainer> floors) {
        this.floors = floors;
    }

    public void setElevator(AbstractHumanContainer elevator) {
        this.elevator = elevator;
    }

    public void print(int cycle, int currentFloor, boolean upDirection) {
        System.out.printf("********* cycle %d *********%s", cycle, System.lineSeparator());
        for (int i = floors.size() - 1; i >= 0; i--) {
            if (i == currentFloor) {
                System.out.printf("%2d | %s %15s | %s\n", i,
                        (upDirection ? UP_ARROW : DOWN_ARROW),
                        getHumansInElevator(), getHumansOnFloor(i));
            } else {
                System.out.printf("%2d | %18s| %s\n", i, "", getHumansOnFloor(i));}
        }
    }

    private String getHumansInElevator() {
        return elevator.getHumans()
                .stream()
                .map(h -> String.valueOf(h.getDestinationFloor()))
                .collect(Collectors.joining(" "));
    }

    private String getHumansOnFloor(int floor) {
        return floors.get(floor).getHumans()
                .stream()
                .map(h -> String.valueOf(h.getDestinationFloor()))
                .collect(Collectors.joining(" "));
    }
}
