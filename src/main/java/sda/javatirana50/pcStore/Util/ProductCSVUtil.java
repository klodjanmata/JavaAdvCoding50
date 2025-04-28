package sda.javatirana50.pcStore.Util;

import sda.javatirana50.pcStore.Entity.Laptop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ProductCSVUtil {
    private static final String FILENAME = "Files/pcStore/Product.csv";
    private static final String SEPARATOR = ",";

    public void writeToFile(List<Laptop> computers) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, false))) {
            bw.write(getHeader());
            for (Laptop l : computers) {
                bw.newLine();
                bw.write(l.getManufacturer() + SEPARATOR);
                bw.write(l.getModel() + SEPARATOR);
                bw.write(l.getCpu() + SEPARATOR);
                bw.write(l.getRam() + SEPARATOR);
                bw.write(l.getDisk() + SEPARATOR);
                bw.write(l.getGraphicsCard() + SEPARATOR);
                bw.write(l.getBatteryCapacity() + "");
            }
            bw.close();
            System.out.println("Product CSV Written");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<Laptop> readFromFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            boolean firstLine = true;
            List<Laptop> computers = new ArrayList<Laptop>();
            String line;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split(SEPARATOR);
                Laptop l = new Laptop();
                l.setManufacturer(parts[0]);
                l.setModel(parts[1]);
                l.setCpu(parts[2]);
                l.setRam(Integer.parseInt(parts[3]));
                l.setDisk(Integer.parseInt(parts[4]));
                l.setGraphicsCard(parts[5]);
                l.setBatteryCapacity(Float.parseFloat(parts[6]));
                computers.add(l);
            }
            br.close();
            return computers;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private String getHeader(){
        return "Manufacturer,Model,CPU,RAM,Disk,GraphicsCard,Battery";
    }
}
