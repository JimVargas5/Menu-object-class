package the_thing;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
//import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    private Date lastEditDate;
    private static ArrayList<MenuItem> theMenu = new ArrayList<>();
    private static int itemID = 0;

    public static void makeNewMenuItem(){
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        System.out.println("Making a new item...");

        System.out.println("Enter the item's name:");
        String aName = in.nextLine();
        System.out.println("Enter the item's price:");
        Double aPrice = in.nextDouble();
        System.out.println("Enter the item's description:");
        String aDescription = in.nextLine();
        System.out.println("Enter the item's category:");
        String aCategory = in2.nextLine();

        MenuItem newMenuIten = new MenuItem(aName, aPrice, aDescription, aCategory);
    }

    public Date getLastEditDate(){
        return lastEditDate;
    }
    public void setLastEditDate() {
        this.lastEditDate = new Date();
    }

    public static void main (String args[]){
        System.out.println("Here is the menu:");
        if (theMenu.size() < 1){
            System.out.println("Nothing on the menu yet.");
            makeNewMenuItem();
        }else {
            for (int i = 0; i < theMenu.size(); i++) {
                System.out.println(theMenu.get(i).getName());
            }
            System.out.println("Last edit date: ");
        }

    }
}
