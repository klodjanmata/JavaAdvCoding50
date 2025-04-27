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

    public void removeCar(Car car){
        cars.remove(car);
    }



    public List<Car> getCarsByEngineType(EngineType engineType){
        return cars.stream().filter(car -> car.getEngineType().equals(engineType)).toList();
    }

    public List<Car> getCarsBeforeGivenYear(int year){
        return cars.stream().filter(car -> car.getYearOfManufacture() < year).toList();
    }

    public Car getTheMostExpensiveCar(){
        return cars.stream().max((car1, car2) -> Double.compare(car1.getPrice(), car2.getPrice())).get();
    }

    public Car getTheCheapestCar(){
        return cars.stream().min((car1, car2) -> Double.compare(car1.getPrice(), car2.getPrice())).get();
    }

    public List<Car> getCarsWithAtLeast3Man(){
        return cars.stream().filter(car -> car.getManufacturers().size() >= 3).toList();
    }

    public boolean isCarOnTheList(Car car){
        return cars.contains(car);
    }

    public List<Car> getCarsByManufacturer(Manufacturer manufacturer){
        return cars.stream().filter(car -> car.getManufacturers().contains(manufacturer)).toList();
    }

    public List<Car> getCars(){
        return cars;
    }

    public void printAllCars(){
        Car.getHeadline();
        cars.forEach(System.out::println);
    }

    // TODO 12

    /**
     9. returning a list of all cars sorted according to the passed parameter: ascending / descending,
     12. returning the list of cars manufactured by the manufacturer with the year of establishment <,>, <=,> =,
     =,! = from the given.
     */

}
