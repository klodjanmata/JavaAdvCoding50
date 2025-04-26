package sda.javatirana48.Exercise8;

public class Parcel implements Validator{
    private int xLength;
    private int yLength;
    private  int zLength;
    private float weight;
    private boolean isExpress;

    public Parcel(int xLength, int yLength, int zLength, float weight, boolean isExpress) {
        this.xLength = xLength;
        this.yLength = yLength;
        this.zLength = zLength;
        this.weight = weight;
        this.isExpress = isExpress;
    }

    public boolean validate(Parcel parcel){
        if (parcel.xLength + parcel.yLength + parcel.zLength >= 300){
            System.out.println("Sum of dimensions is greater than 300! Parcel is invalid.");
            return false;
        }
        if (parcel.xLength < 30 ||
            parcel.yLength < 30 ||
            parcel.zLength < 30){
            System.out.println("One or more dimensions are less than 30! Parcel is invalid.");
            return false;
        }
        if (isExpress && parcel.weight > 15.0){
            System.out.println("Parcel is Express and more than 15kg! Parcel is invalid.");
            return false;
        }
        if (!isExpress && parcel.weight > 30.0){
            System.out.println("Parcel is not Express and more than 30kg! Parcel is invalid.");
            return false;
        }
        return true;
    }
}
