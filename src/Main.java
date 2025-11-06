import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/* Test from Laptop
 * todo:
 * 
 * add the "Edit List" functionality
 * add the "cancel" functionality
 * make it so i can leave the program after editing without receiving a random restuarant
 * 
 * src/FastFood.txt
 */


public class Main
{
    protected static ProgramData data;
    protected static void createData() {
        data = new ProgramData();
    }
    public static void main(String[] args)
    {
        createData();

        ArrayList<String> fullList = data.getFullList();
        ArrayList<String> sitDownList = data.getSitList();
        ArrayList<String> fastFoodList = data.getFastList();
        ArrayList<String> currentList;

        System.out.println("Here is your complete list of restaurants:\n");
        printList(fullList);

        System.out.println("\nWould you like to edit or add to this list? (y/n)");
        Scanner user = new Scanner(System.in);
        String response = user.nextLine();
        if (response.equals("y")) {
            System.out.println("\nWhich list would you like to edit?\n" +
            "1) Sit-Down List\n" + 
            "2) Fast-Food List\n" +
            "3) Go Back\n");
            response = user.nextLine();

            if (response.equals("1")) {
                editList(sitDownList);
            } else if (response.equals("2")) {
                editList(fastFoodList);
            } else if (!response.equals("n")) {
                System.out.println("Please enter either \"y\" or \"n\"\n");
            }
        }

        System.out.println("\nWould you like to include Sit Down Restaurants? (y/n)");
        response = user.nextLine();
        if (response.equals("y")) {
            System.out.println("\nWould you like to include Fast Food Restaurants? (y/n)");
                response = user.nextLine();
                if (response.equals("y")) {
                    currentList = fullList;
                } else {
                currentList = sitDownList;
            } 
        } else {
            System.out.println("\nWould you like to include Fast Food Restaurants? (y/n)");
                response = user.nextLine();
                if (response.equals("y")) {
                    currentList = fastFoodList;
                } else {
                currentList = sitDownList;
            }
        }

        user.close();

        int foodChoice = (int) (Math.random() * currentList.size());
        System.out.println("\nHere is the list of choices currently being chosen from: \n");
        printList(currentList);
         
        System.out.println("\nChecking Sources...");
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }

        System.out.println("Contacting Professionals...");
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }

        System.out.println("Conducting Surveys...");
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }

        System.out.println("And the choice is...\n");
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println(getCHoice(currentList, foodChoice) + "!!!!!");
    }

    public static String getCHoice(ArrayList<String> list, int foodChoice)
    {
        return list.get(foodChoice);
    }

    public static void printList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String currentString = list.get(i);
            System.out.println((i+1) + ". " + currentString);
        }
    }

    private static void editList(ArrayList<String> list) {

        Scanner user = new Scanner(System.in);
        String response = "";

        System.out.println("\n");
        System.out.println("Here is the current List:");
        printList(list);
        System.out.println("\nWhat would you like to do?\n" +
        "1) Add Restaurant\n" + 
        "2) Edit Restaurant\n" +
        "3) Go Back\n");
        response = user.nextLine();

        if (response.equals("1")) {
            addRestaurant(list);
        } else if (response.equals("2")) {
            editRestuarant(list);
        } else {
            System.out.println("make everything into methods so you can call them to go back to them");
        }
        
    }

    private static void addRestaurant(ArrayList<String> list) {

        Scanner user = new Scanner(System.in);
        String response = "";

        System.out.println("Enter Name of the Restaurant you would like to add\n");
        response = user.nextLine();

        list.add(response);
        try (PrintWriter writer = new PrintWriter(new FileWriter(data.getCurrentFile(list)), true)) {
            for (String line : list) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.err.println("error writing to file: " + e.getMessage());
        }
    }

    private static void editRestuarant(ArrayList<String> list) {
        Scanner user = new Scanner(System.in);
        String response = "";

        System.out.println("\nWhich restuarant would you like to edit?");
        printList(list);
        
        System.out.println();
        response = user.nextLine();
        String restaurant = response;

        System.out.println("What is the new restaurant?");
        response = user.nextLine();

        list.set(Integer.parseInt(restaurant)-1, response);
        try (PrintWriter writer = new PrintWriter(new FileWriter(data.getCurrentFile(list)), true)) {
            for (String line : list) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.err.println("error writing to file: " + e.getMessage());
        }
        System.out.println("Here is the new list:");
        printList(list);
    }
}
