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
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("%2d | ", i));
            if (i == currentFloor) {
                builder.append(String.format("%s %15s ", (upDirection ? UP_ARROW : DOWN_ARROW),
                        getHumansInElevator()));
            } else {
                builder.append(String.format("%18s", ""));
            }
            builder.append("| ").append(getHumansOnFloor(i));
            System.out.println(builder);
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
