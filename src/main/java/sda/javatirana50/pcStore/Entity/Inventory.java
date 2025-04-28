package sda.javatirana50.pcStore.Entity;

public class Inventory {
    private String manufacturer;
    private String model;
    private int quantity;
    private float price;

    public Inventory(float price, int quantity, String model, String manufacturer) {
        this.price = price;
        this.quantity = quantity;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public Inventory() {
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  manufacturer + '\t' + model + '\t' + quantity + '\t' + price;
    }
}
