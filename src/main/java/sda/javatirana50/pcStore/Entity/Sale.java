package sda.javatirana50.pcStore.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sale {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private String manufacturer;
    private String model;
    private int quantity;
    private float price;
    private float totalPrice;
    private Date date;
    private String customer;

    public Sale(float totalPrice, float price, int quantity, String model, String manufacturer, Date date, String customer) {
        this.totalPrice = totalPrice;
        this.price = price;
        this.quantity = quantity;
        this.model = model;
        this.manufacturer = manufacturer;
        this.date = date;
        this.customer = customer;
    }

    public Sale(){}

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return  manufacturer + '\t' + model + '\t' + quantity + '\t' + price + '\t' + totalPrice + '\t' + DATE_FORMAT.format(date) + '\t' + customer;
    }

}
