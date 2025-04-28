package sda.javatirana50.pcStore.Service;

import sda.javatirana50.pcStore.Entity.Inventory;

import java.util.List;

public class InventoryService {
    private List<Inventory> inventoryList;


    public void addQuantity(){
        //TODO
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
