package sda.javatirana50.Exercise4;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage(new java.util.HashMap<>());
        storage.addToStorage("Alma", "Matematike");
        storage.addToStorage("Ana", "Fizike");
        storage.addToStorage("Artur", "Matematike");
        storage.addToStorage("Thanas", "Algjeber");
        storage.addToStorage("Alma", "Kerkime Operacionle");


        storage.printAll();
        System.out.println("\n");
        storage.findByKey("Alma");
        System.out.println("\n");
        storage.findByValue("Matematike");
    }
}
