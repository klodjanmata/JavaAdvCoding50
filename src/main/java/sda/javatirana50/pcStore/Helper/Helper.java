package sda.javatirana50.pcStore.Helper;

import java.util.Scanner;

public class Helper {

    public static int getIntFromUser(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message + ": ");
        return scanner.nextInt();
    }

    public static String getStringFromUser(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message + ": ");
        return scanner.nextLine();
    }

    public static float getFloatFromUser(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message + ": ");
        return scanner.nextFloat();
    }

}
