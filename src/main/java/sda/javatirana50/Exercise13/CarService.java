package sda.javatirana50.Exercise13;

import sda.javatirana50.Exercise12.Car;
import sda.javatirana50.Exercise12.EngineType;
import sda.javatirana50.Exercise12.Manufacturer;

import java.util.List;

public class CarService {
    private List<Car> cars;
    public CarService(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void removeCar(Car car){
        cars.remove(car);
    }

    public List<Car> getCars(){
        return cars;
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

    // TODO 12

    /**
     9. returning a list of all cars sorted according to the passed parameter: ascending / descending,
     12. returning the list of cars manufactured by the manufacturer with the year of establishment <,>, <=,> =,
     =,! = from the given.
     */

}
