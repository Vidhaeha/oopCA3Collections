package main.java.org.VidhaehaJayasinghe;

import java.util.Scanner;
import java.util.Stack;

/**
 * Name:
 * Class Group:
 */
public class Question2 { // Car Parking - Stack
    public static void runSimulation() {
        Stack<Integer> driveway = new Stack<>();
        Stack<Integer> street = new Stack<>();
        Scanner keyboard = new Scanner(System.in);

        int carToRemove = 0;

        System.out.println("Input a positive numbers to add a car and negative numbers to retrieve a car. if u want to exit, input 0:");

        while (true) {
            int input = keyboard.nextInt();

            if (input == 0) {
                System.out.println("Simulation Finished");
                break;
            }

            if (input > 0) {
                driveway.push(input);
                System.out.println("Car " + input + " added to the driveway.");
            } else if (input < 0) {
                carToRemove = -input;

                if (driveway.contains(carToRemove)) {
                    //This will move cars blocking the target car to the street stack
                    while (driveway.peek() != carToRemove) {
                        street.push(driveway.pop());
                        System.out.println("Temporarily moved car " + street.peek() + " to the street.");
                    }

                    // To remove the target car
                    driveway.pop();
                    System.out.println("Car " + carToRemove + " removed from the driveway.");

                    // Return cars from the street stack to the driveway stack
                    while (!street.isEmpty()) {
                        driveway.push(street.pop());
                        System.out.println("Moved car " + driveway.peek() + " back to the driveway.");
                    }
                } else {
                    System.out.println("Car " + carToRemove + " is not in the driveway.");
                }
            }

            // Prints the state of the stacks
            System.out.println("Current driveway state: " + driveway);
            System.out.println("Current street state: " + street);
        }

        keyboard.close();
    }

    public static void main(String[] args) {
        runSimulation();
    }
}
