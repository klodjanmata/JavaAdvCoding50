package sda.javatirana50.Exercise8;

public class Main {
    public static void main(String[] args) {
        Parcel parcel = new Parcel(30, 50, 30, 30.0f, false);
        System.out.println(parcel.validate(parcel));
    }
}
