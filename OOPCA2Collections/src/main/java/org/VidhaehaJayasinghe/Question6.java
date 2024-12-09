package main.java.org.VidhaehaJayasinghe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Name:
 * Class Group:
 */

public class Question6 { // Flight take-off (Queue)

    public static void main(String[] args) {
        Queue<String> takeoffQueue = new LinkedList<>();
        Queue<String> landingQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter commands to Launch the planes");

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Simulation ended.");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length < 2 && !parts[0].equalsIgnoreCase("next")) {
                System.out.println("Invalid command. Try again.");
                continue;
            }

            String command = parts[0];
            String flightCode = parts.length > 1 ? parts[1] : "";

            switch (command.toLowerCase()) {
                case "takeoff":
                    takeoffQueue.add(flightCode);
                    System.out.println(flightCode + " is queued for takeoff.");
                    break;

                case "land":
                    landingQueue.add(flightCode);
                    System.out.println(flightCode + " is queued for landing.");
                    break;

                case "next":
                    if (!landingQueue.isEmpty()) {
                        String landingFlight = landingQueue.poll();
                        System.out.println("Landing completed for " + landingFlight);
                    } else if (!takeoffQueue.isEmpty()) {
                        String takeoffFlight = takeoffQueue.poll();
                        System.out.println("Takeoff cmpleted for " + takeoffFlight);
                    } else {
                        System.out.println("No flights in the queue.");
                    }
                    break;

                default:
                    System.out.println("You have entered an unknown command. Try 'takeoff', 'land', 'next', or 'quit'.");
            }
        }

        scanner.close();
    }
}
