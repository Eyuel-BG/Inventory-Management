public abstract class Item {
    private String id;
    private String name;
    private double price;
    private int quantity;

public Item(String id, String name, double price, int quantity) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
}

public double getPrice() {
    return this.price;
}

public int getQuantity() {
    return this.quantity;
}

public String getName() {
    return this.name;
}

public void addStock(int amount) {
    this.quantity = this.quantity + amount;
}
public abstract void displayDetails();
}