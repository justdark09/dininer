import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int foodChoiceMultiplier = 0;
        int baseChoice = 1;

        System.out.println("Would you like to include Fast Food Options? (y/n)\n");
        Scanner fastFood = new Scanner(System.in);
        String SfastFood = fastFood.nextLine();
        if (SfastFood.equals("y")) {
            foodChoiceMultiplier +=4;
        }

        System.out.println("Would you like to include Sit Down Restaurant Options? (y/n)\n");
        Scanner sitDown = new Scanner(System.in);
        String SsitDown = fastFood.nextLine();
        if (SsitDown.equals("y")) {
            foodChoiceMultiplier += 3;
        } else {
            baseChoice += 3;
        }



        int foodChoice = (int) (Math.random() * foodChoiceMultiplier) + baseChoice;

        //if (foodChoice == ) {

        //}

        System.out.println("Let's find out where to EAT!!!\n" +
                "Here are your choices:\n" +
                "1. Olive Garden\n" +
                "2. Buffalo Wild Wings\n" +
                "3. Texas Roadhouse\n" +
                "4. McDonalds\n" +
                "5. Culvers\n" +
                "6. Chick Fil A\n" +
                "7. Panda Express\n\n" +
                "Let's figure this out!\n");

        System.out.println("Checking Sources...");
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

        System.out.println(getCHoice(foodChoice) + "!!!!!");
    }

    public static String getCHoice(int foodChoice)
    {
        switch (foodChoice)
        {
            case 1:
                return "Olive Garden";
            case 2:
                return "Buffalo Wild Wings";
            case 3:
                return "Texas Roadhouse";
            case 4:
                return "McDonalds";
            case 5:
                return "Culvers";
            case 6:
                return "Chick Fil A";
            case 7:
                return "Panda Express";
        }
        return null;
    }
}