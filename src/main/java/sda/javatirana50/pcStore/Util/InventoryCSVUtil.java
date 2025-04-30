package sda.javatirana50.pcStore.Util;

import sda.javatirana50.pcStore.Entity.Inventory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class InventoryCSVUtil {

    private static final String FILENAME = "Files/pcStore/Inventory.csv";
    private static final String SEPARATOR = ",";

    public void writeToFile(List<Inventory> invetoryList) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, false))){
            bw.write(getHeader());
            for (Inventory inventory : invetoryList){
                bw.newLine();
                bw.write(inventory.getManufacturer() + SEPARATOR);
                bw.write(inventory.getModel() + SEPARATOR);
                bw.write(inventory.getQuantity() + SEPARATOR);
                bw.write(inventory.getPrice() + "");
            }
            bw.close();
            System.out.println("Inventory CSV Written");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Inventory> readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            boolean firstLine = true;
            String line;
            List<Inventory> inventoryList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split(SEPARATOR);
                Inventory inventory = new Inventory();
                inventory.setManufacturer(parts[0]);
                inventory.setModel(parts[1]);
                inventory.setQuantity(Integer.parseInt(parts[2]));
                inventory.setPrice(Float.parseFloat(parts[3]));
                inventoryList.add(inventory);
            }
            br.close();
            return inventoryList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private String getHeader(){
        return "Manufacturer,Model,Quantity,Price";
    }
}
