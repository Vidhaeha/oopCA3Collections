package main.java.org.VidhaehaJayasinghe;

public class Block {
    private final int quantity;
    private final double price;

    public Block(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
