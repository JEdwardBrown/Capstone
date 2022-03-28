package Capstone.client;

import io.micronaut.runtime.Micronaut;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
        char choice;
        Scanner kbd = new Scanner(System.in);
        System.out.println("This is a test!");
        System.out.println("I really hope this does what I want it to. Let's begin!");
        do {
            System.out.println("Please choose from one of the following options. Use the first letter of each " +
                    "option to make your choice.");
            System.out.println("Please pick from [V]iew Inventory, View [W]arehouse, [A]lter price," +
                    " Add [I]nventory, or [Q]uit");
            choice = kbd.nextLine().toUpperCase().charAt(0);
            switch (choice) {
                case 'V': ViewInventory();
                    break;
                case 'W': ViewWarehouse();
                    break;
                case 'A': AlterPrice();
                    break;
                case 'I': AddInventory();
                    break;
                case 'Q':
                    break;
                default:
                    break;
                }
        }while(choice != 'Q');
        System.out.println("Thank you, have a good day!");
    }

    public static void ViewInventory() {
        int storeID;
        Scanner kbd = new Scanner(System.in);
        do {
            System.out.println("Please enter the 3-digit id of the store whose inventory you are trying to access: ");
            storeID = kbd.nextInt();
            if(storeID < 100 || storeID > 999)
                System.out.println("Invalid Store Number, please try again.");
        }while(storeID < 100 || storeID > 999);

    }

    public static void ViewWarehouse() {

    }

    public static void AlterPrice() {

    }

    public static void AddInventory() {

    }
}
