public class Main {
    public static void main(String[] args) {
        Inventory pharmacy = new Inventory();
        Medication med = new Medication("D6T6", "Painkiller", 4000, 100, "12/2027");
        MedicalDevices equip = new MedicalDevices("E202", "Thermometer", 4000, 15, 24);
        pharmacy.addItem(med);
        pharmacy.addItem(equip);
        pharmacy.showInventory();

    }
}
// trigger workflow