package main.java.org.VidhaehaJayasinghe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Name:
 * Class Group:
 */

public class Question7 {
    public static void main(String[] args) {
        Queue<Block> queue = new LinkedList<>();
        Scanner in = new Scanner(System.in);

        System.out.println("Commands: buy qty price or sell qty or quit");

        while (true) {
            System.out.print(">");
            String command = in.next();

            if (command.equalsIgnoreCase("quit")) {
                System.out.println("Exiting program.");
                break;
            }

            if (command.equalsIgnoreCase("buy")) {
                int qty = in.nextInt();
                double price = in.nextDouble();
                queue.add(new Block(qty, price));
                System.out.println("Bought " + qty + " shares at $" + price + " each.");

            }
            else if (command.equalsIgnoreCase("sell")) {
                int qtyToSell = in.nextInt();
                System.out.print("Enter selling price: ");
                double sellPrice = in.nextDouble();
                double totalGain = 0.0;

                while (qtyToSell > 0 && !queue.isEmpty()) {
                    Block block = queue.peek(); // Get the oldest block
                    int availableQty = block.getQuantity();
                    double buyPrice = block.getPrice();

                    if (availableQty <= qtyToSell) {
                        totalGain += availableQty * (sellPrice - buyPrice);
                        qtyToSell -= availableQty;
                        queue.poll(); // Remove the block
                    } else {
                        totalGain += qtyToSell * (sellPrice - buyPrice);
                        queue.poll();
                        queue.add(new Block(availableQty - qtyToSell, buyPrice));
                        qtyToSell = 0;
                    }
                }

                if (qtyToSell > 0) {
                    System.out.println("Not enough shares to sell!");
                } else {
                    System.out.printf("Total gain: $%.2f%n", totalGain);
                }
            }

        }

        in.close();
    }

}
