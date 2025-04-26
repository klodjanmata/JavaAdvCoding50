package sda.javatirana48.Exercise4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Storage {
    private Map<String, List<String>> storages;

    public Storage(Map<String, List<String>> storages){
        this.storages = storages;
    }

    public void addToStorage(String key, List<String> value){
        storages.put(key, value);
    }

    public void addToStorage(String key, String value){
        if (storages.containsKey(key)){
            storages.get(key).add(value);
        }else{
            storages.put(key, generateNewList(value));
        }
    }

    public void findByKey(String key){
        System.out.println("Key: " + key + ", Value: " + printValue(storages.get(key)));
    }

    public void findByValue(String value){
        for (Map.Entry<String, List<String>> entry : storages.entrySet()) {
            for (String s : entry.getValue()) {
                if(s.equals(value)){
                    System.out.println("Key: " + entry.getKey() + ", Value: " + printValue(entry.getValue()));
                }
            }
        }
    }

    public void printAll(){
        for (Map.Entry<String, List<String>> entry : storages.entrySet()){
            System.out.println("Key: " + entry.getKey() + ", Value: " + printValue(entry.getValue()));
        }
    }

    private String printValue(List<String> values){
        String s = "";
        for (String value : values) {
            s += value + ", ";
        }
        return s;
    }

    private List<String> generateNewList(String value){
        List<String> newList = new ArrayList<>();
        newList.add(value);
        return newList;
    }

}
