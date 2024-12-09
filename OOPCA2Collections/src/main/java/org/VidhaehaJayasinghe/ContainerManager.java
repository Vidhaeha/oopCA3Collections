package main.java.org.VidhaehaJayasinghe;

import java.util.ArrayList;
import java.util.List;

public class ContainerManager {
    // final list to store IMeasurableContainer objects
    private final List<IMeasurableContainer> containers;

    // Constructor
    public ContainerManager() {
        this.containers = new ArrayList<>();
    }

    // Adds the container to the list
    public void add(IMeasurableContainer container) {
        containers.add(container);
    }

    // Returns the total weight of all containers
    public double totalWeight() {
        return containers.stream().mapToDouble(IMeasurableContainer::weight).sum();
    }

    // Returns the total rectangular volume of all containers
    public double totalRectangularVolume() {
        return containers.stream().mapToDouble(IMeasurableContainer::rectangularVolume).sum();
    }

    // Clears all containers
    public void clearAll() {
        containers.clear();
    }

    // Returns the list of all containers
    public List<IMeasurableContainer> getAllContainers() {
        return new ArrayList<>(containers); // Return a copy to avoid external modification
    }
}
