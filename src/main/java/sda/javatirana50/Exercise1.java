package sda.javatirana50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) {
        List<String> elements = new ArrayList<>();
        elements.add("Minerva");
        elements.add("Kaladin");
        elements.add("Dorin");
        elements.add("Morgana");
        elements.add("Gandalf");
        elements.add("Gimli");
        elements.add("gollum");
        elements.add("Boromir");
        elements.add("Legolas");
        elements.add("Aragorn");

        System.out.println("Elements before sorting:");
        elements.forEach(System.out::println);

        Exercise1 ex = new Exercise1();
        elements = ex.orderList(elements);

        System.out.println("Elements after sorting:");
        elements.forEach(System.out::println);

        System.out.println("Elements after sorting (reverse order):");
        ex.reverseOrderList(elements);
        elements.forEach(System.out::println);
    }

    public List<String> orderList(List<String> inputList){
        List<String> orderedList = new ArrayList<>();
        orderedList = inputList.stream().sorted().collect(Collectors.toList());
        return orderedList;
    }


    public List<String> reverseOrderList(List<String> inputList){
        //Collections.sort(inputList, Collections.reverseOrder());
        inputList.sort(Collections.reverseOrder());
        return inputList;
    }

    // TODO Create a method that takes a string list as a parameter,
    //  then returns that list sorted alphabetically from Z to
    //  A case-insensitive.


}
