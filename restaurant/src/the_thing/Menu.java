package the_thing;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    private static Date lastEditDate;
    private static ArrayList<MenuItem> theMenu = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public static void makeNewMenuItem(){
        System.out.println("Making a new item...");

        System.out.println("Enter the item's name:");
        String aName = in.nextLine();
        System.out.println("Enter the item's price:");
        Double aPrice = in.nextDouble();
        in.nextLine();
        System.out.println("Enter the item's description:");
        String aDescription = in.nextLine();
        //in.nextLine();
        System.out.println("Enter the item's category:");
        String aCategory = in.nextLine();

        MenuItem newMenuItem = new MenuItem(aName, aPrice, aDescription, aCategory);
        theMenu.add(newMenuItem);
        setLastEditDate();
    }

    public static Date getLastEditDate(){
        if (lastEditDate != null){
            return lastEditDate;
        }else{
            setLastEditDate();
        }
        return lastEditDate;
    }
    public static void setLastEditDate() {
        lastEditDate = new Date();
    }

    public static void main (String args[]){
        MenuItem poop = new MenuItem("Poop", 6.66,
                "It is just a piece of poop.","bestsellers");
        MenuItem Pie = new MenuItem("Pie", 2.05,
                "It's not the mathematical pi.","cheap");
        MenuItem apple = new MenuItem("Apple", .05,
                "froot snecc","cheap");
        theMenu.add(poop);
        theMenu.add(Pie);
        theMenu.add(apple);

        ArrayList<String> topChoices = new ArrayList<>();
        topChoices.add("0:\tQuit");
        topChoices.add("1:\tPick from the menu");
        topChoices.add("2:\tAdd a new item to the menu");

        ArrayList<String> getOrSet = new ArrayList<>();
        getOrSet.add("0:\tQuit");
        getOrSet.add("1:\tGet a field");
        getOrSet.add("2:\tSet a field");
        getOrSet.add("3:\tBuy it");

        ArrayList<String> getterSelection = new ArrayList<>();
        getterSelection.add("0:\nQuit");
        getterSelection.add("1:\tGet name (this is a dumb choice)");
        getterSelection.add("2:\tGet price (this is a dumb choice)");
        getterSelection.add("3:\tGet description (this is a dumb choice)");
        getterSelection.add("4:\tGet category");
        getterSelection.add("5:\tGet date added");

        ArrayList<String> setterSelection = new ArrayList<>();
        getterSelection.add("0:\nQuit");
        getterSelection.add("1:\tSet name");
        getterSelection.add("2:\tSet price");
        getterSelection.add("3:\tSet description");
        getterSelection.add("4:\tSet category");

        ArrayList<String> nameChoices = new ArrayList<>();
        for (int i = 0; i < theMenu.size(); i++) {
            nameChoices.add(i+":\t"+theMenu.get(i).getName());
        }

        Boolean keepGoing = true;
        while (keepGoing) {
            if (theMenu.size() < 1) {
                System.out.println("Nothing on the menu yet.");
                makeNewMenuItem();
            }
            System.out.println("\nHere is the menu:");
            System.out.println("Last menu edit date: "+getLastEditDate());
            for (int i = 0; i < theMenu.size(); i++) {
                System.out.println((i+1)+": "+"\t"+theMenu.get(i).getName()+"\t"+
                        "$"+theMenu.get(i).getPrice()+"\t"+
                        theMenu.get(i).getDescription()+"\t");
                if (theMenu.get(i).getCategory().equalsIgnoreCase("bestsellers")){
                    System.out.println("One of our bestsellers!");
                }
            }

            String input = userInterface(topChoices);
            if (input.equalsIgnoreCase(topChoices.get(0))){
                System.out.println("Goodbye, good riddance.");
                keepGoing = false;
            }else if (input.equalsIgnoreCase(topChoices.get(1))){
                String itemPicked = userInterface(nameChoices);

                System.out.println("Now for "+itemPicked.substring(3)+":");
                String whatToDo = userInterface(getOrSet);
                if (whatToDo.equalsIgnoreCase(getOrSet.get(0))){
                    System.out.println("Goodbye, good riddance.");
                    keepGoing = false;
                }else if (whatToDo.equalsIgnoreCase(getOrSet.get(1))) {
                    //todo
                    String getterPick = userInterface(getterSelection);

                }else if (whatToDo.equalsIgnoreCase(getOrSet.get(2))){
                    //todo
                    String setterPick = userInterface(setterSelection);

                }else if (whatToDo.equalsIgnoreCase(getOrSet.get(3))){
                    System.out.println("That will be $"+theMenu.get(
                            Integer.parseInt(itemPicked.substring(0,1))
                    ).getPrice());
                    System.out.println("Thanks and GOODBYE");
                    keepGoing = false;
                }
            }else if (input.equalsIgnoreCase(topChoices.get(2))){
                makeNewMenuItem();
            }
        }
    }
    public static String userInterface(ArrayList<String> choices){
        Boolean validChoice = false;

        Integer userChoice;

        do {
            System.out.println("\nHere are the choices:");

            for (Integer i = 0; i < choices.size(); i++) {
                System.out.println(choices.get(i));
            }
            userChoice = in.nextInt();
            in.nextLine();
            if (userChoice < 0 || userChoice >= choices.size()) {
                System.out.println("Invalid choice. Try again.");
            } else {
                validChoice = true;
            }
        } while (!validChoice);
        return choices.get(userChoice);
    }

}
