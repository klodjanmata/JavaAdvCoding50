package sda.javatirana50.pcStore.Service;

import sda.javatirana50.pcStore.Entity.Inventory;
import sda.javatirana50.pcStore.Entity.Sale;
import sda.javatirana50.pcStore.Helper.Helper;

import java.util.List;

public class SalesService {
    private List<Sale> salesList;

    public List<Inventory> sellProduct(List<Inventory> inventoryList){
        System.out.println("Enter Data for selling product");
        Sale s = new Sale();
        s.setManufacturer(Helper.getStringFromUser("Manufacturer"));
        s.setModel(Helper.getStringFromUser("Model"));
        s.setQuantity(Helper.getIntFromUser("Quantity"));
        s.setPrice(Helper.getFloatFromUser("Price"));
        s.setDate(Helper.getDateFromUser("Sale Date"));
        s.setCustomer(Helper.getStringFromUser("Customer"));
        s.setTotalPrice(s.getQuantity() * s.getPrice());
        if (!validateSale(inventoryList, s)){
            System.out.println("Sale not valid");
            return inventoryList;
        }
        System.out.println("Total to pay: " + s.getTotalPrice());
        System.out.println("Sale details: " + s);
        salesList.add(s);
        System.out.println("Product sold");
        return inventoryList;
    }

    public void printAllSales(){
        System.out.println(getHeader());
        for (Sale s : salesList) {
            System.out.println(s);
        }
    }

    private boolean validateSale(List<Inventory> inventoryList, Sale sale){
        for (Inventory i : inventoryList){
            if (i.getManufacturer().equalsIgnoreCase(sale.getManufacturer())
                && i.getModel().equalsIgnoreCase(sale.getModel())){
                if(i.getQuantity() < sale.getQuantity()){
                    System.out.println("Not enough quantity in stock");
                    return false;
                }
                i.setQuantity(i.getQuantity() - sale.getQuantity());
                return true;
            }
        }
        System.out.println("Product not found");
        return false;
    }

    private String getHeader(){
        return "Manufacturer\tModel\tQuantity\tPrice\tTotal\tDate\tCustomer";
    }



    public SalesService(List<Sale> salesList) {
        this.salesList = salesList;
    }

    public List<Sale> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sale> salesList) {
        this.salesList = salesList;
    }
}
