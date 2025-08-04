import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        int foodChoiceMultiplier = 0;
        int baseChoice = 1;

        System.out.println("Would you like to include Sit Down Restaurant Options? (y/n)\n");
        Scanner sitDown = new Scanner(System.in);
        String SsitDown = sitDown.nextLine();
        if (SsitDown.equals("y")) {
            foodChoiceMultiplier += 3;
        } else {
            baseChoice += 3;
        }

        System.out.println("Would you like to include Fast Food Options? (y/n)\n");
        Scanner fastFood = new Scanner(System.in);
        String SfastFood = fastFood.nextLine();
        if (SfastFood.equals("y")) {
            foodChoiceMultiplier += 4;
        }

        int foodChoice = (int) (Math.random() * foodChoiceMultiplier) + baseChoice;

        ProgramData data = new ProgramData(baseChoice, foodChoiceMultiplier);


        //Removes the [] and , from the final printed list
        ArrayList<String> list = data.getList();


        for (int i = 0; i < list.size(); i++) {
            
            String currentString = list.get(i);
            currentString.toString().replace("[", "").replace("]", "").replace(",", "");


            if (currentString.substring(0, 1) == "\\s") {
                currentString = list.get(i).substring(1);
            }
            System.out.println(currentString);
        }
        sitDown.close();
        fastFood.close();

        
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

        System.out.println(getCHoice(list, foodChoice) + "!!!!!");
    }

    public static String getCHoice(ArrayList<String> list, int foodChoice)
    {
        return list.get(foodChoice);
    }
}