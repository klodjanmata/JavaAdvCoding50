package sda.javatirana48.Exercise7;

import java.util.Stack;
public class WeaponMagazine {
    private int capacity; // Maximum size of the magazine
    private Stack<String> bullets; // Stack to hold the bullets
    // Constructor to define the size of the magazine
    public WeaponMagazine(int capacity) {
        this.capacity = capacity;
        this.bullets = new Stack<>();
    }
    // Method to load a bullet into the magazine
    public void loadBullet(String bullet) {
        if (bullets.size() < capacity) {
            bullets.push(bullet);
            System.out.println("Bullet \"" + bullet + "\" loaded into the magazine.");
        } else {
            System.out.println("Magazine is full. Cannot load more bullets.");
        }
    }
    // Method to check if the weapon is loaded
    public boolean isLoaded() {
        return !bullets.isEmpty();
    }
    // Method to shoot a bullet
    public void shot() {
        if (isLoaded()) {
            String firedBullet = bullets.pop();
            System.out.println("Shot fired: \"" + firedBullet + "\"");
        } else {
            System.out.println("Empty magazine");
        }
    }
    // Main method to demonstrate functionality
    public static void main(String[] args) {
        WeaponMagazine magazine = new WeaponMagazine(3);
        // Loading bullets into the magazine
        magazine.loadBullet("Bullet 1");
        magazine.loadBullet("Bullet 2");
        magazine.loadBullet("Bullet 3");
        magazine.loadBullet("Bullet 4"); // Exceeds capacity
        // Checking if the weapon is loaded
        System.out.println("Is weapon loaded? " + magazine.isLoaded());
        // Firing bullets
        magazine.shot();
        magazine.shot();
        magazine.shot();
        magazine.shot(); // No bullets left
    }
}
