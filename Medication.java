public class Medication extends Item {
    private String expirationDate; 
    public Medication(String id, String name, double price, int quantity, String expirationDate) {
        super(id, name, price, quantity);
        this.expirationDate = expirationDate; 
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Medication Item: " + getName() + " | Price: Birr " + getPrice() + " | Stock: " + getQuantity() + " | Expires: " + expirationDate);
    }
}
