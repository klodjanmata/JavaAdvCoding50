package sda.javatirana50.Exercise13;

import sda.javatirana50.Exercise12.Car;
import sda.javatirana50.Exercise12.EngineType;
import sda.javatirana50.Exercise12.Manufacturer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
/**
public List<Lecturer> readFromFile(){
    try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
        List<Lecturer> lecturerList = new ArrayList<>();
        boolean firstLine = true;
        String line;
        while( (line = br.readLine()) != null){
            if (firstLine){
                firstLine = false;
                continue;
            }
            String[] data = line.split(SEPARATOR);
            Lecturer l = new Lecturer();
            l.setId(data[0]);
            l.setName(data[1]);
            l.setSurname(data[2]);
            l.setDepartment(Department.valueOf(data[3]));
            l.setStartDate(dateFormat.parse(data[4]));
            l.setEmail(data[5]);
            l.setPhoneNumber(data[6]);
            l.setGender(data[7].charAt(0));
            l.setBirthday(dateFormat.parse(data[8]));
            //SUBJECT LIST
            lecturerList.add(l);
        }
        br.close();
        return lecturerList;
    }catch (IOException e){
        System.out.println("Error while reading Lecturers from file");
        e.printStackTrace();
    }catch (ParseException pe){
        System.out.println("Error while parsing the date");
        pe.printStackTrace();
    }

    return null;
}
 */

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

    private List<Manufacturer> manageManufacturers(List<Manufacturer> manufacturers, String[] data){
        List<Manufacturer> myManufacturers = new ArrayList<>();
        for (String str : data){
            Manufacturer m = manufacturers.stream().filter(man -> man.getName().equals(str)).findFirst().get();
            myManufacturers.add(m);
        }
        return myManufacturers;
    }
}
