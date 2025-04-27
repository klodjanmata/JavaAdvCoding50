package sda.javatirana50.Exercise12;

import java.util.Objects;

public class Manufacturer {
    private String name;
    private int yearOfEstablishment;
    private String country;

    public Manufacturer(String name, int yearOfEstablishment, String country) {
        this.name = name;
        this.yearOfEstablishment = yearOfEstablishment;
        this.country = country;
    }

    public Manufacturer(){}

    public String getName() {
        return name;
    }
    public int getYearOfEstablishment() {
        return yearOfEstablishment;
    }
    public String getCountry() {
        return country;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setYearOfEstablishment(int yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void printManufacturer(){
        System.out.println(this);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Manufacturer that)) return false;
        return yearOfEstablishment == that.yearOfEstablishment && Objects.equals(name, that.name) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfEstablishment, country);
    }

    @Override
    public String toString() {
        return "Name=" + name + '\t' +
                "yearOfEstablishment=" + yearOfEstablishment + '\t' +
                "country=" + country;
    }
}
