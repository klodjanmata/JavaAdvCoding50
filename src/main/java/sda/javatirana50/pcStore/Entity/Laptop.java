package sda.javatirana50.pcStore.Entity;

import java.util.Objects;

public class Laptop extends Computer {
    private float batteryCapacity;

    public Laptop(String manufacturer, String model, String cpu, int ram, int disk, String graphicsCard, float batteryCapacity) {
        super(manufacturer, model, cpu, ram, disk, graphicsCard);
        this.batteryCapacity = batteryCapacity;
    }

    public Laptop(Computer computer, float batteryCapacity) {
        this.manufacturer = computer.getManufacturer();
        this.model = computer.getModel();
        this.cpu = computer.getCpu();
        this.ram = computer.getRam();
        this.disk = computer.getDisk();
        this.graphicsCard = computer.getGraphicsCard();
        this.batteryCapacity = batteryCapacity;
    }

    public Laptop() {}

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Laptop laptop)) return false;
        if (!super.equals(o)) return false;
        return Float.compare(batteryCapacity, laptop.batteryCapacity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), batteryCapacity);
    }

    @Override
    public String toString() {
        return  super.toString() + "\t" + batteryCapacity  ;

    }
}
