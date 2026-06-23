import java.io.*;

public class Inventory {
    private Item[] stock = new Item[50];
    private int itemCount = 0;

public void addItem(Item newItem) throws InvalidQuantityException {
    if (newItem.getQuantity() < 0) {
        throw new InvalidQuantityException("Quantity cannot be negative!");
    }
    stock[itemCount] = newItem;
    itemCount = itemCount + 1;
    System.out.println("Item added successfully!");
}

public void addItem(Item newItem, int bonusQuantity) throws InvalidQuantityException {
    if (newItem.getQuantity() < 0 || bonusQuantity < 0) {
        throw new InvalidQuantityException("Quantity cannot be negative!");
    }
    newItem.addStock(bonusQuantity);
    this.addItem(newItem);
}

public void showInventory() {
    System.out.println("Current Stock");
    for (int i = 0; i < itemCount; i++) {
        stock[i].displayDetails(); 
    }
}

public void displayMedicationsOnly() {
    System.out.println("Medication Filter:");
    for (int i = 0; i < itemCount; i++) {
        if (stock[i] instanceof Medication) {
            Medication med = (Medication) stock[i];
            med.displayDetails();
        }
    }
}

public void saveInventoryToFile(String filename) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
        writer.println("Total Items Tracked: " + Item.totalItems);
        writer.println("--- Current Stock Details ---");
        for (int i = 0; i < itemCount; i++) {
            writer.println(stock[i].getName() + " - Stock: " + stock[i].getQuantity());
        }
        System.out.println("Inventory text saved to " + filename);
    } catch (IOException e) {
        System.out.println("Error saving file.");
    }
}

public void loadInventoryFromFile(String filename) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        System.out.println("--- Reading from " + filename + " ---");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        System.out.println("Error reading file.");
    }
}
}

