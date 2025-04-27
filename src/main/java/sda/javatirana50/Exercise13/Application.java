package sda.javatirana50.Exercise13;

import sda.javatirana50.Exercise12.Manufacturer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static CarService carService;
    private static List<Manufacturer> manufacturersList;

    public static void main(String[] args) {
        boolean nextAction = true;
        CarCSVUtil csvUtil = new CarCSVUtil();
        ManufacturerCSVUtil manufacturerCSVUtil = new ManufacturerCSVUtil();
        manufacturersList = manufacturerCSVUtil.readCSV();
        carService = new CarService(csvUtil.readCSV(manufacturersList));
        while(nextAction){
            printMenu();
            int input = getInputFromUser();
            nextAction = manageChoice(input);

        }
    }

    private static int getInputFromUser(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static boolean manageChoice(int input){
        switch (input){
            case 1:
                System.out.println("Add a car");
                break;
            case 2:
                System.out.println("Remove a car");
                break;
            case 3:
                System.out.println("Print all cars");
                break;
            case 4:
                System.out.println("Print cars by engine type");
                break;
            case 5:
                System.out.println("Print cars before given year");
                break;
            case 6:
                System.out.println("Print the most expensive car");
                break;
            case 7:
                System.out.println("Print the cheapest car");
                break;
            case 8:
                System.out.println("Print cars with at least 3 manufacturers");
                break;
            case 9:
                System.out.println("I told not to press this option");
                break;
            case 10:
                System.out.println("Check if a car is on the list");
                break;
            case 11:
                System.out.println("Print cars by manufacturer");
                break;
            case 12:
                System.out.println("I told not to press this other as well");
                break;
            case 144:
                System.out.println("Congrats! You got a free FERRARI! xp");
                break;
            case 0:
                System.out.println("Program stopped!");
                return false;
            default:
                System.out.println("Invalid option");
                break;
        }
        return true;
    }

    private static void printMenu(){
        System.out.println("Chose from the following options:");
        System.out.println("1. Add a car");
        System.out.println("2. Remove a car");
        System.out.println("3. Print all cars");
        System.out.println("4. Print cars by engine type");
        System.out.println("5. Print cars before given year");
        System.out.println("6. Print the most expensive car");
        System.out.println("7. Print the cheapest car");
        System.out.println("8. Print cars with at least 3 manufacturers");
        System.out.println("9. DO NOT PRESS THIS OPTION");
        System.out.println("10. Check if a car is on the list");
        System.out.println("11. Print cars by manufacturer");
        System.out.println("12. DO NOT PRESS THIS OTHER AS WELL");
        System.out.println("0. Exit");
    }
}
