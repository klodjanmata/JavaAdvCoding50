package sda.javatirana50.pcStore.Entity;

import java.util.Objects;

public class Computer {
    protected String manufacturer;
    protected String model;
    protected String cpu;
    protected int ram;
    protected int disk;
    protected String graphicsCard;

    public Computer(String manufacturer, String model, String cpu, int ram, int disk, String graphicsCard) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.cpu = cpu;
        this.ram = ram;
        this.disk = disk;
        this.graphicsCard = graphicsCard;
    }

    public Computer(){}

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

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Computer computer)) return false;
        return ram == computer.ram && disk == computer.disk && Objects.equals(manufacturer, computer.manufacturer) && Objects.equals(model, computer.model) && Objects.equals(cpu, computer.cpu) && Objects.equals(graphicsCard, computer.graphicsCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, cpu, ram, disk, graphicsCard);
    }

    @Override
    public String toString() {
        return  manufacturer + '\t' +
                model + '\t' +
                cpu + '\t' +
                ram + '\t' +
                disk + '\t' +
                graphicsCard;
    }
}
