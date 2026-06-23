public class MedicalDevices extends Item {
    private int WarrantyMonths;

public MedicalDevices(String id, String name, double price, int quantity, int warrantyMonths) {
    super(id, name, price, quantity);
    this.WarrantyMonths = warrantyMonths;
    }

public void displayDetails() {
    System.out.println("Equipment Name: " + getName());
    System.out.println("Warranty Period: " + this.WarrantyMonths + " months");
    }
}

