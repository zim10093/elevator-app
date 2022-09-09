package core.services;

import java.util.Random;

public class FloorDestinationGenerator {
    private final Random random;
    private final int topFloor;

    public FloorDestinationGenerator(Random random, int topFloor) {
        this.random = random;
        this.topFloor = topFloor;
    }

    public int generate() {
        return random.nextInt(topFloor);
    }
}
