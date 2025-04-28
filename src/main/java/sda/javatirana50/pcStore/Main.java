package sda.javatirana50.pcStore;

import sda.javatirana50.pcStore.Helper.Helper;
import sda.javatirana50.pcStore.Helper.Menu;

public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        boolean nextAction = true;
        while (nextAction) {
            Menu.mainMenu();
            nextAction = app.manageChoice(Helper.getIntFromUser("CHOSE"));
        }
    }
}
