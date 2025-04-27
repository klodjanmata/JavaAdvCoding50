package sda.javatirana50.Exercise13;

import sda.javatirana50.Exercise12.Car;
import sda.javatirana50.Exercise12.EngineType;
import sda.javatirana50.Exercise12.Manufacturer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CarCSVUtil {
    private static final String CSV_FILE_PATH = "Files/Cars.csv";
    private static final String SEPARATOR = ",";

    public List<Car> readCSV(List<Manufacturer> manufacturers){
        try(BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))){
            List<Car> cars = new ArrayList<>();
            boolean firstLine = true;
            String line;
            while( (line = br.readLine()) != null){
                if (firstLine){
                    firstLine = false;
                    continue;
                }
                String[] data = line.split(SEPARATOR);
                Car c = new Car();
                c.setName(data[0]);
                c.setModel(data[1]);
                c.setPrice(Float.parseFloat(data[2]));
                c.setYearOfManufacture(Integer.parseInt(data[3]));
                c.setManufacturers(manageManufacturers(manufacturers, data[4].split(";")));
                c.setEngineType(EngineType.valueOf(data[5]));
                cars.add(c);
            }
            br.close();
            return cars;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeCSV(List<Car> cars){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE_PATH))){
            bw.write(getHeadline());
            for (Car c : cars){
                bw.newLine();
                bw.write(c.getName() + SEPARATOR);
                bw.write(c.getModel() + SEPARATOR);
                bw.write(c.getPrice() + SEPARATOR);
                bw.write(c.getYearOfManufacture() + SEPARATOR);
                bw.write(String.join(";", c.getManufacturers().stream().map(m -> m.getName()).toList()) + SEPARATOR);
                bw.write(c.getEngineType().name());
            }
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private List<Manufacturer> manageManufacturers(List<Manufacturer> manufacturers, String[] data){
        List<Manufacturer> myManufacturers = new ArrayList<>();
        for (String str : data){
            Manufacturer m = manufacturers.stream().filter(man -> man.getName().equals(str)).findFirst().get();
            myManufacturers.add(m);
        }
        return myManufacturers;
    }

    private String getHeadline(){
        return "Name" + SEPARATOR + "Model" + SEPARATOR + "Price" + SEPARATOR + "Year of manufacture" + SEPARATOR + "Manufacturers" + SEPARATOR + "Engine type";
    }
}
