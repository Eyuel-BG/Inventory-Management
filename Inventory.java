public class Inventory {
    private Item[] stock = new Item[50];
    private int itemCount = 0;

public void addItem(Item newItem) {
    stock[itemCount] = newItem;
    itemCount = itemCount + 1;
    System.out.println("Item added successfully!");
    }

public void showInventory() {
    System.out.println("Current Stock");
    for (int i = 0; i < itemCount; i++) {
        stock[i].displayDetails(); 
    }
}
}

