package sda.javatirana50.Exercise12;

import java.util.List;
import java.util.Objects;

public class Car {
    private String name;
    private String model;
    private float price;
    private int yearOfManufacture;
    private List<Manufacturer> manufacturers;
    private EngineType engineType;

    public Car(String name, String model, float price, int yearOfManufacture, List<Manufacturer> manufacturers, EngineType engineType) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.yearOfManufacture = yearOfManufacture;
        this.manufacturers = manufacturers;
        this.engineType = engineType;
    }

    public Car(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Car car)) return false;
        return Float.compare(price, car.price) == 0 && yearOfManufacture == car.yearOfManufacture && Objects.equals(name, car.name) && Objects.equals(model, car.model) && Objects.equals(manufacturers, car.manufacturers) && engineType == car.engineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model, price, yearOfManufacture, manufacturers, engineType);
    }

    @Override
    public String toString() {
        return "name= " + name + '\t' +
                ", model= " + model + '\t' +
                ", price=" + price + '\t'+
                ", yearOfManufacture=" + yearOfManufacture + '\t'+
                ", manufacturers=" + manufacturers + '\t'+
                ", engineType=" + engineType + '\t';
    }
}
