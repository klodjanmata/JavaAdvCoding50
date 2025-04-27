package sda.javatirana50.Exercise13;

import sda.javatirana50.Exercise12.Car;
import sda.javatirana50.Exercise12.EngineType;
import sda.javatirana50.Exercise12.Manufacturer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService {
    private List<Car> cars;
    private List<Manufacturer> manufacturers;
    public CarService(List<Car> cars, List<Manufacturer> manufacturers) {
        this.cars = cars;
        this.manufacturers = manufacturers;
    }

    public void addCar(){
        Car c = new Car();
        System.out.println("Enter car details:");
        System.out.println("Name: ");
        Scanner scanner = new Scanner(System.in);
        c.setName(scanner.nextLine());
        System.out.println("Model: ");
        c.setModel(scanner.nextLine());
        System.out.println("Price: ");
        c.setPrice(scanner.nextFloat());
        System.out.println("Year of manufacture: ");
        c.setYearOfManufacture(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Engine type: ");
        c.setEngineType(EngineType.valueOf(scanner.nextLine()));
        System.out.println("Manufacturers: ");
        String[] manufacturers = scanner.nextLine().split(";");
        List<Manufacturer> manufacturerList = new ArrayList<>();
        for (String str : manufacturers){
            Manufacturer m = this.manufacturers.stream().filter(man -> man.getName().equals(str)).findFirst().get();
            manufacturerList.add(m);
        }
        c.setManufacturers(manufacturerList);
        cars.add(c);
        System.out.println("Car added successfully to the list!");
    }

    public void removeCar(){
        printAllCars();
        System.out.println("Enter the name of the car you want to remove:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try{
            Car car = cars.stream().filter(c -> c.getName().equals(name)).findFirst().get();
            cars.remove(car);
            System.out.println("Car removed successfully!");
        } catch (Exception e) {
            System.out.println("Car not found!");
            e.printStackTrace();
        }
    }

    public void getCarsByEngineType(){
        for (EngineType et : EngineType.values()) {
            System.out.print(et.name() +", ");
        }
        System.out.println();
        System.out.println("Enter the engine type you want to filter by:");
        Scanner scanner = new Scanner(System.in);
        EngineType engineType = EngineType.valueOf(scanner.nextLine());
        printOnlyTheList(cars.stream().filter(car -> car.getEngineType().equals(engineType)).toList());
    }

    private void printOnlyTheList(List<Car> cars){
        System.out.println(Car.getHeadline());
        cars.forEach(System.out::println);
    }

    public void getCarsBeforeGivenYear(){
        System.out.println("Enter the year you want to filter by:");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        printOnlyTheList(cars.stream().filter(car -> car.getYearOfManufacture() < year).toList());
    }

    public void getTheMostExpensiveCar(){
        printOnlyTheList(List.of(cars.stream().max((car1, car2) -> Double.compare(car1.getPrice(), car2.getPrice())).get()));
    }

    public void getTheCheapestCar(){
        printOnlyTheList(List.of(cars.stream().min((car1, car2) -> Double.compare(car1.getPrice(), car2.getPrice())).get()));
    }

    public void getCarsWithAtLeast3Man(){
        printOnlyTheList(cars.stream().filter(car -> car.getManufacturers().size() >= 2).toList());
    }

    public boolean isCarOnTheList(){
        System.out.println("Enter the name of the car you want to check:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return cars.stream().anyMatch(c -> c.getName().equals(name));
    }

    public void getCarsByManufacturer(){
        System.out.println("Enter the name of the manufacturer you want to filter by:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Manufacturer m = this.manufacturers.stream().filter(man -> man.getName().equals(name)).findFirst().get();
        printOnlyTheList(cars.stream().filter(car -> car.getManufacturers().contains(m)).toList());
    }

    public List<Car> getCars(){
        return cars;
    }

    public void printAllCars(){
        System.out.println(Car.getHeadline());
        cars.forEach(System.out::println);
    }

    // TODO 12

    /**
     9. returning a list of all cars sorted according to the passed parameter: ascending / descending,
     12. returning the list of cars manufactured by the manufacturer with the year of establishment <,>, <=,> =,
     =,! = from the given.
     */

}
