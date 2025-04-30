package sda.javatirana50.pcStore.Service;

import sda.javatirana50.pcStore.Entity.Inventory;
import sda.javatirana50.pcStore.Helper.Helper;

import java.util.List;

public class InventoryService {
    private List<Inventory> inventoryList;


    public void addQuantity(){
        System.out.println("Enter Data for adding quantity");
        Inventory inventory = new Inventory();
        inventory.setManufacturer(Helper.getStringFromUser("Manufacturer"));
        inventory.setModel(Helper.getStringFromUser("Model"));
        inventory.setQuantity(Helper.getIntFromUser("Quantity"));
        inventory.setPrice(Helper.getFloatFromUser("Price"));
        inventoryList.add(inventory);
        System.out.println("Inventory updated");
    }

    public void printFullInventory(){
        System.out.println(getHeader());
        for (Inventory inventory : inventoryList) {
            System.out.println(inventory);
        }
    }

    public void printInventoryValue(){
        float totalValue = 0;
        for (Inventory inventory : inventoryList){
            totalValue += inventory.getQuantity() * inventory.getPrice();
        }
        System.out.println("Total value: " + totalValue);
    }

    private String getHeader(){
        return "Manufacturer\tModel\tQuantity\tPrice";
    }

    public InventoryService(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public InventoryService() {}

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }
    public void setInventoryList(List<Inventory> inventoryList) {}
}
