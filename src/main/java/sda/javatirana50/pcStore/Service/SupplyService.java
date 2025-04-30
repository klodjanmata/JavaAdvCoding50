package sda.javatirana50.pcStore.Service;

import sda.javatirana50.pcStore.Entity.Inventory;
import sda.javatirana50.pcStore.Entity.Laptop;
import sda.javatirana50.pcStore.Entity.Supply;

import java.util.ArrayList;
import java.util.List;

public class SupplyService {
    private List<Supply> supplies;

    public List<Inventory> updateInventoryAfterSupply(List<Inventory> inventoryList, List<Laptop> products){
        for (Supply supply : supplies){
            boolean brokeFromLoop = false;
            for (Inventory inventory : inventoryList){
                if (inventory.getManufacturer().equalsIgnoreCase(supply.getManufacturer())
                    && inventory.getModel().equalsIgnoreCase(supply.getModel())){
                    inventory.setQuantity(inventory.getQuantity() + supply.getQuantity());
                    brokeFromLoop = true;
                    break;
                }
            }
            if (brokeFromLoop){
                continue;
            }
            for(Laptop product : products){
                if (product.getManufacturer().equalsIgnoreCase(supply.getManufacturer())
                    && product.getModel().equalsIgnoreCase(supply.getModel())){
                    Inventory inventory = new Inventory();
                    inventory.setManufacturer(supply.getManufacturer());
                    inventory.setModel(supply.getModel());
                    inventory.setQuantity(supply.getQuantity());
                    inventory.setPrice(supply.getPrice());
                    inventoryList.add(inventory);
                    break;
                }
            }
        }
        return inventoryList;
    }

    public List<Supply> getNotRegisteredSupplies(List<Inventory> inventoryList){
        List<Supply> notRegisteredSupplies = new ArrayList<>();
        for (Supply s : supplies){
            boolean found = false;
            for (Inventory i : inventoryList){
                if (i.getManufacturer().equalsIgnoreCase(s.getManufacturer())
                    && i.getModel().equalsIgnoreCase(s.getModel())){
                    found = true;
                    break;
                }
            }
            if (!found){
                notRegisteredSupplies.add(s);
            }

        }
        return notRegisteredSupplies;
    }




    public SupplyService(List<Supply> supplies) {
        this.supplies = supplies;
    }

    public List<Supply> getSupplies() {
        return supplies;
    }
    public void setSupplies(List<Supply> supplies) {
        this.supplies = supplies;
    }
}
