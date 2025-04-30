package sda.javatirana50.pcStore.Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static Date getDateFromUser(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message + " FORMAT: dd/MM/yyyy\t");
        String date = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Date d = sdf.parse(date);
            return d;
        }catch (ParseException e){
            Date d = new Date();
            d.setYear(90);
            d.setMonth(0);
            d.setDate(1);
            return d;
        }
    }

}
