package sda.javatirana50.pcStore;

import sda.javatirana50.pcStore.Entity.Laptop;
import sda.javatirana50.pcStore.Service.InventoryService;
import sda.javatirana50.pcStore.Service.ProductService;
import sda.javatirana50.pcStore.Util.InventoryCSVUtil;
import sda.javatirana50.pcStore.Util.ProductCSVUtil;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private ProductService productService;
    private ProductCSVUtil productCSVUtil;
    private InventoryService inventoryService;
    private InventoryCSVUtil inventoryCSVUtil;

    public Application() {
        productCSVUtil = new ProductCSVUtil();
        productService = new ProductService(productCSVUtil.readFromFile());
        inventoryCSVUtil = new InventoryCSVUtil();
        inventoryService = new InventoryService(inventoryCSVUtil.readFromFile());
    }

    public boolean manageChoice(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Shutting down procedure started...");
                shutDown();
                System.out.println("Program shut down!");
                return false;
            case 1:
                productService.addProduct();
                break;
            case 2:
                productService.deleteProduct();
                break;
            case 3:
                productService.searchProducts();
                break;
            case 4:
                productService.printProducts();
                break;
            case 5:
                inventoryService.addQuantity();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        return true;
    }

    private void shutDown() {
        productCSVUtil.writeToFile(productService.getProducts());
        inventoryCSVUtil.writeToFile(inventoryService.getInventoryList());
    }

}
