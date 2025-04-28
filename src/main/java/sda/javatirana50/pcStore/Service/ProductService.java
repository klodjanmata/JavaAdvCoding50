package sda.javatirana50.pcStore.Service;

import sda.javatirana50.pcStore.Entity.Laptop;
import sda.javatirana50.pcStore.Helper.Helper;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Laptop> products = new ArrayList<>();

    public void addProduct(){
        System.out.println("Adding product");
        Laptop laptop = new Laptop();
        laptop.setManufacturer(Helper.getStringFromUser("Manufacturer"));
        laptop.setModel(Helper.getStringFromUser("Model"));
        laptop.setCpu(Helper.getStringFromUser("CPU"));
        laptop.setRam(Helper.getIntFromUser("RAM"));
        laptop.setDisk(Helper.getIntFromUser("DISK"));
        laptop.setGraphicsCard(Helper.getStringFromUser("Graphics Card"));
        laptop.setBatteryCapacity(Helper.getFloatFromUser("Hours of Battery (type 0 for PC)"));
        products.add(laptop);
        System.out.println("Product added");
    }

    public void deleteProduct(){
        System.out.println("Enter Data for deletion");
        String producerName = Helper.getStringFromUser("Manufacturer Name");
        String model = Helper.getStringFromUser("Model Name");
        Laptop laptopToDelete = findByManufacturerAndModel(producerName, model);
        if (laptopToDelete == null){
            System.out.println("Product not found");
            return;
        }
        products.remove(laptopToDelete);
        System.out.println("Product deleted");
    }

    public void searchProducts(){
        String data = Helper.getStringFromUser("Enter only one parameter");
        printOnlyTheList(filterList(data));
    }

    public void printProducts(){
        System.out.println(getHeader());
        for (Laptop l : products) {
            System.out.println(l);
        }
    }

    private List<Laptop> filterList(String data){
        List<Laptop> list = new ArrayList<>();
        for (Laptop l : products) {
            if (l.getManufacturer().contains(data) ||
                l.getModel().contains(data) ||
                l.getCpu().contains(data) ||
                l.getGraphicsCard().contains(data)){
                list.add(l);
            }
        }
        return list;
    }

    private void printOnlyTheList(List<Laptop> list){
        if (list.isEmpty()){
            System.out.println("NO PRODUCTS TO DISPLAY");
            return;
        }
        System.out.println(getHeader());
        for (Laptop l : list) {
            System.out.println(l);
        }
    }

    private Laptop findByManufacturerAndModel(String manufacturer, String model){
        for (Laptop l : products) {
            if (l.getManufacturer().equalsIgnoreCase(manufacturer)
                    && l.getModel().equalsIgnoreCase(model)){
                return l;
            }
        }
        return null;
    }

    private String getHeader(){
        return "Manufacturer\tModel\tCPU\tRAM\tDisk\tGraphicsCard\tBattery";
    }

    public ProductService() {}

    public ProductService(List<Laptop> products) {
        this.products = products;
    }

    public List<Laptop> getProducts() {
        return products;
    }

    public void setProducts(List<Laptop> products) {
        this.products = products;
    }
}
