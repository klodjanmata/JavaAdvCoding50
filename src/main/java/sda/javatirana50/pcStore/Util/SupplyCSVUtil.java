package sda.javatirana50.pcStore.Util;

import sda.javatirana50.pcStore.Entity.Inventory;
import sda.javatirana50.pcStore.Entity.Supply;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SupplyCSVUtil {
    private static final String CSV_FILE_PATH = "Files/pcStore/Incomming/Supply.csv";
    private static final String SEPARATOR = ",";

    public List<Supply> readFromFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))){
            List<Supply> supplies = new ArrayList<>();
            boolean firstLine = true;
            String line;
            while ((line = br.readLine()) != null) {
                if (firstLine){
                    firstLine = false;
                    continue;
                }
                String[] data = line.split(SEPARATOR);
                Supply s = new Supply();
                s.setManufacturer(data[0]);
                s.setModel(data[1]);
                s.setQuantity(Integer.parseInt(data[2]));
                s.setPrice(Float.parseFloat(data[3]));
                supplies.add(s);
            }
            br.close();
            return supplies;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeToFile(List<Supply> supplies){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE_PATH, false))){
            bw.write(getHeader());
            for (Supply supply : supplies){
                bw.newLine();
                bw.write(supply.getManufacturer() + SEPARATOR);
                bw.write(supply.getModel() + SEPARATOR);
                bw.write(supply.getQuantity() + SEPARATOR);
                bw.write(supply.getPrice() + "");
            }
            bw.close();
            System.out.println("Supply CSV UPDATED");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String getHeader(){
        return "Manufacturer,Model,Quantity,Price";
    }
}
