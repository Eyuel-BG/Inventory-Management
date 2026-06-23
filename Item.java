import java.io.Serializable;

public abstract class Item implements Serializable {
    private String id;
    private String name;
    protected double price;
    private int quantity;
    public static int totalItems = 0;

public Item() {
    this("UNKNOWN", "Unknown Item", 0.0, 0);
}

public Item(String id, String name, double price, int quantity) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    totalItems = totalItems + 1;
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

public final String getId() {
    return this.id;
}

public void addStock(int amount) {
    this.quantity = this.quantity + amount;
}
public abstract void displayDetails();
}