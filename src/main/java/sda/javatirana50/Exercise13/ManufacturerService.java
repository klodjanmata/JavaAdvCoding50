package sda.javatirana50.Exercise13;

import sda.javatirana50.Exercise12.Manufacturer;

import java.util.List;
import java.util.Scanner;

public class ManufacturerService {

    public ManufacturerService() {}

    public void addManufacturer(List<Manufacturer> manufacturerList) {
        Manufacturer m = new Manufacturer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Manufacturer details: ");
        System.out.print("Name: ");  //BMW Group
        m.setName(scanner.nextLine());
        if (containsManufacturer(m, manufacturerList)) {
            System.out.println("Manufacturer already exists!");
            return;
        }
        System.out.print("Enter Manufacturer Country: ");
        m.setCountry(scanner.nextLine());
        System.out.print("Enter Year of Establishment: ");
        m.setYearOfEstablishment(scanner.nextInt());
        manufacturerList.add(m);
        System.out.println("Manufacturer added successfully!");
    }

    private boolean containsManufacturer(Manufacturer m, List<Manufacturer> manufacturerList) {
        for (Manufacturer m1 : manufacturerList) {
            if (m1.getName().equalsIgnoreCase(m.getName())) {
                return true;
            }
        }
        return false;
    }
}
