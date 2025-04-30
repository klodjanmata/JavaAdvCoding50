package sda.javatirana50.pcStore.Util;

import sda.javatirana50.pcStore.Entity.Sale;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SalesCSVUtil {
    private static final String FILENAME = "Files/pcStore/Sales.csv";
    private static final String SEPARATOR = ",";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public void writeToFile(List<Sale> salesList){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, false))){
            bw.write(getHeader());
            for (Sale sale : salesList){
                bw.newLine();
                bw.write(sale.getManufacturer() + SEPARATOR);
                bw.write(sale.getModel() + SEPARATOR);
                bw.write(sale.getQuantity() + SEPARATOR);
                bw.write(sale.getPrice() + SEPARATOR);
                bw.write(sale.getTotalPrice() + SEPARATOR);
                bw.write(DATE_FORMAT.format(sale.getDate()) + SEPARATOR);
                bw.write(sale.getCustomer());
            }
            bw.close();
            System.out.println("Sales CSV Written");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<Sale> readFromFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            List<Sale> salesList = new ArrayList<>();
            boolean firstLine = true;
            String line;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split(SEPARATOR);
                Sale sale = new Sale();
                sale.setManufacturer(parts[0]);
                sale.setModel(parts[1]);
                sale.setQuantity(Integer.parseInt(parts[2]));
                sale.setPrice(Float.parseFloat(parts[3]));
                sale.setTotalPrice(Float.parseFloat(parts[4]));
                sale.setDate(DATE_FORMAT.parse(parts[5]));
                sale.setCustomer(parts[6]);
                salesList.add(sale);
            }
            br.close();
            return salesList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private String getHeader(){
        return "Manufacturer,Model,Quantity,Price,Total,Date,Customer";
    }
}
