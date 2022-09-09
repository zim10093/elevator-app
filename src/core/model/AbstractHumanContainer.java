package core.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class AbstractHumanContainer {
    final Queue<Human> upHumans;
    final Queue<Human> downHumans;
    int currentFloor;

    public AbstractHumanContainer(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    {
        upHumans = new LinkedList<>();
        downHumans = new LinkedList<>();
    }

    public List<Human> getHumans () {
        ArrayList<Human> humans = new ArrayList<>();
        humans.addAll(upHumans);
        humans.addAll(downHumans);
        return humans;
    }

    Human removeUp() {
        return upHumans.poll();
    }

    Human removeDown() {
        return downHumans.poll();
    }

    void putUp(Human human) {
        upHumans.offer(human);
    }

    void putDown(Human human) {
        downHumans.offer(human);
    }

    abstract void addHumans(Human human);
}
