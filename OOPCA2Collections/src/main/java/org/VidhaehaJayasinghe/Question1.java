package main.java.org.VidhaehaJayasinghe;

import java.util.ArrayList;
import java.util.List;

/**
 * Your Name:
 * Class Group:
 */
public class Question1 {    // Interfaces
    public static void main(String[] args) {
        ContainerManager manager = new ContainerManager();

        // Create various containers
        Box box1 = new Box(3, 1, 6, 15);
        Box box2 = new Box(1, 1, 1, 4);
        Cylinder cylinder1 = new Cylinder(1, 2, 15);
        Pyramid pyramid1 = new Pyramid(3, 2, 6);

        // Add containers to the manager
        manager.add(box1);
        manager.add(box2);
        manager.add(cylinder1);
        manager.add(pyramid1);

        // Calculate and display total weight and volume
        System.out.println("Total Weight: " + manager.totalWeight());
        System.out.println("Total Rectangular Volume: " + manager.totalRectangularVolume());

        // Get all containers and print their details
        System.out.println("\nThe details of all containers:");
        List<IMeasurableContainer> containers = manager.getAllContainers();
        for (IMeasurableContainer container : containers) {
            if (container instanceof Box) {
                Box box = (Box) container;
                System.out.println("Box Length is: " + box.getLength() + ", Width is: " + box.getWidth() +
                        ", Depth is: " + box.getDepth() + ", Weight is: " + box.getWeight());
            } else if (container instanceof Cylinder) {
                Cylinder cylinder = (Cylinder) container;
                System.out.println("Cylinder Height is: " + cylinder.getHeight() + ", Diameter is: " +
                        cylinder.getDiameter() + ", Weight is: " + cylinder.getWeight());
            } else if (container instanceof Pyramid) {
                Pyramid pyramid = (Pyramid) container;
                System.out.println("Pyramid Length is: " + pyramid.getLength() + ", Side Length is: " +
                        pyramid.getSideLength() + ", Weight is: " + pyramid.getWeight());
            }
        }
    }
}

// Define the IMeasurableContainer interface. This is how I saw it was like in w3 school
interface IMeasurableContainer {
    double weight();
    double rectangularVolume();
}




