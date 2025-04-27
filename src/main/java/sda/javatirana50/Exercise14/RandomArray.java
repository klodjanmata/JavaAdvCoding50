package sda.javatirana50.Exercise14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RandomArray{
    private int[] randomNumbers = new int[100000];
    private Map<Integer, Integer> map = new HashMap<>();

    public RandomArray() {
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = (int) (Math.random() * 100000) + 1;
        }
        initMap();
    }

    private void initMap(){
        for (int i = 0; i < randomNumbers.length; i++) {
            if(map.containsKey(randomNumbers[i])){
                map.put(randomNumbers[i], map.get(randomNumbers[i]) + 1);
            }else{
                map.put(randomNumbers[i], 1);
            }
        }
    }

    public List<Integer> getUniqueItems(){
        return new ArrayList<>(
                map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .keySet()
        );
    }

    public List<Integer> repeatedElements(){
        return new ArrayList<>(
                map.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .keySet()
        );
    }

    public Map<Integer, Integer> mostFrequented25Items() {
        return map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(25)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public void deDuplicate(){
        for (int i = 0; i < randomNumbers.length; i++) {
            if(map.get(randomNumbers[i]) > 1){
                System.out.println(randomNumbers[i]);
                while(true){
                    int randomNumber = (int) (Math.random() * 120000) + 1;
                    if (map.containsKey(randomNumber)){
                        continue;
                    }
                    randomNumbers[i] = randomNumber;
                    map.put(randomNumber, 1);
                    int value = map.get(randomNumbers[i]);
                    map.remove(randomNumbers[i]);
                    map.put(randomNumbers[i], value - 1);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        RandomArray randomArray = new RandomArray();
        System.out.println(randomArray.map.size());
        System.out.println("Unique items: " + randomArray.getUniqueItems().size());
        System.out.println("Repeated items: " + randomArray.repeatedElements().size());
        System.out.println("Most frequented 25 items: ");
        for (Map.Entry<Integer, Integer> entry : randomArray.mostFrequented25Items().entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Start deduplication: ");
        randomArray.deDuplicate();
        System.out.println("Unique items after deduplication: " + randomArray.getUniqueItems().size());
        System.out.println("Repeated items after deduplication: " + randomArray.repeatedElements().size());

    }


    /**
     Implement a method that deduplicates items in the list. If a duplicate is found,
     it replaces it with a new random value that did not occur before.
     Check if the method worked correctly by calling method number 2.
     */
}
