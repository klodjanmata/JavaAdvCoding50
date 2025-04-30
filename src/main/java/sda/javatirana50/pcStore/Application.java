package sda.javatirana50.pcStore;

import sda.javatirana50.pcStore.Service.InventoryService;
import sda.javatirana50.pcStore.Service.ProductService;
import sda.javatirana50.pcStore.Service.SalesService;
import sda.javatirana50.pcStore.Service.SupplyService;
import sda.javatirana50.pcStore.Util.InventoryCSVUtil;
import sda.javatirana50.pcStore.Util.ProductCSVUtil;
import sda.javatirana50.pcStore.Util.SalesCSVUtil;
import sda.javatirana50.pcStore.Util.SupplyCSVUtil;


public class Application {
    private ProductService productService;
    private ProductCSVUtil productCSVUtil;
    private InventoryService inventoryService;
    private InventoryCSVUtil inventoryCSVUtil;
    private SalesService salesService;
    private SalesCSVUtil salesCSVUtil;

    public Application() {
        productCSVUtil = new ProductCSVUtil();
        productService = new ProductService(productCSVUtil.readFromFile());
        inventoryCSVUtil = new InventoryCSVUtil();
        inventoryService = new InventoryService(inventoryCSVUtil.readFromFile());
        salesCSVUtil = new SalesCSVUtil();
        salesService = new SalesService(salesCSVUtil.readFromFile());
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
                productService.printProducts();
                inventoryService.addQuantity();
                break;
            case 6:
                inventoryService.printFullInventory();
                break;
            case 7:
                inventoryService.printInventoryValue();
                break;
            case 8:
                inventoryService.printFullInventory();
                inventoryService.setInventoryList(salesService.sellProduct(inventoryService.getInventoryList()));
                break;
            case 9:
                salesService.printAllSales();
                break;
            case 10:
                handleSupply();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        return true;
    }

    private void handleSupply(){
        SupplyCSVUtil supplyCSVUtil = new SupplyCSVUtil();
        SupplyService supplyService = new SupplyService(supplyCSVUtil.readFromFile());
        inventoryService.setInventoryList(supplyService.updateInventoryAfterSupply(inventoryService.getInventoryList(), productService.getProducts()));
        System.out.println("Not registered supplies:");
        supplyService.getNotRegisteredSupplies(inventoryService.getInventoryList()).forEach(System.out::println);
        supplyCSVUtil.writeToFile(supplyService.getNotRegisteredSupplies(inventoryService.getInventoryList()));
    }

    private void shutDown() {
        productCSVUtil.writeToFile(productService.getProducts());
        inventoryCSVUtil.writeToFile(inventoryService.getInventoryList());
        salesCSVUtil.writeToFile(salesService.getSalesList());
    }

}
