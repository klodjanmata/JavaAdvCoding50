package sda.javatirana50.Exercise13;

import sda.javatirana50.Exercise12.Manufacturer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerCSVUtil {
    private static final String CSV_FILE_PATH = "Files/Manufacturers.csv";
    private static final String SEPARATOR = ",";

    public List<Manufacturer> readCSV(){
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))){
            List<Manufacturer> manufacturers = new ArrayList<>();
            boolean firstLine = true;
            String line;
            while ((line = br.readLine()) != null){
                if (firstLine){
                    firstLine = false;
                    continue;
                }
                Manufacturer m = new Manufacturer();
                String data[] = line.split(SEPARATOR);
                m.setName(data[0]);
                m.setYearOfEstablishment(Integer.parseInt(data[1]));
                m.setCountry(data[2]);
                manufacturers.add(m);
            }
            br.close();
            return manufacturers;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
