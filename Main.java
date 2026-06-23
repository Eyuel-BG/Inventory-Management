import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory pharmacy = new Inventory();
        
        while (true) {
            System.out.println("1. Add Medication");
            System.out.println("2. Add Medical Device");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            
            if (!scanner.hasNextInt()) {
                break;
            }
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 3) {
                break;
            }
            
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
            
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            
            try {
                if (choice == 1) {
                    System.out.print("Enter Expiry Date: ");
                    String expiry = scanner.nextLine();
                    Medication med = new Medication(id, name, price, quantity, expiry);
                    pharmacy.addItem(med);
                } else if (choice == 2) {
                    System.out.print("Enter Warranty Period (months): ");
                    int warranty = scanner.nextInt();
                    scanner.nextLine();
                    MedicalDevices equip = new MedicalDevices(id, name, price, quantity, warranty);
                    pharmacy.addItem(equip);
                } else {
                    System.out.println("Invalid option.");
                    continue;
                }
                
                pharmacy.saveInventoryToFile("data/inventory.txt");
            } catch (InvalidQuantityException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}
