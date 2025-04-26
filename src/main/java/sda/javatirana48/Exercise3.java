package sda.javatirana48;

import java.util.HashMap;
import java.util.Map;

public class Exercise3 {
    public static void main(String[] args) {
        Map<String, Integer> input = new HashMap<String, Integer>();
        input.put("A", 1);
        input.put("B", 2);
        input.put("C", 3);
        input.put("D", 4);
        input.put("E", 5);
        input.put("F", 6);
        input.put("G", 7);
        input.put("H", 8);
        input.put("I", 9);
        input.put("J", 10);

        printMap(input);
    }

    public static void printMap(Map<String, Integer> input){
        int size = input.entrySet().size();
        int i = 1;
        for (Map.Entry<String, Integer> entry : input.entrySet()) {
            if(i < size){
                System.out.println("Key: <" + entry.getKey() + ">, Value: <" + entry.getValue() + ">" + ";");
            }
            else {
                System.out.println("Key: <" + entry.getKey() + ">, Value: <" + entry.getValue() + ">" + ".");
            }
            i++;
        }

    }


}
