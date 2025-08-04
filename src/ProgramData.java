import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ProgramData {

    public ProgramData(int base, int multiply) {
        baseChoice = base;
        foodChoiceMultiplier = multiply;
    }

    int foodChoiceMultiplier = 0;
    int baseChoice = 0;
    
    File sitDownFile = new File("JavaProjects\\dininer\\src\\SitDown.txt");
    File fastFoodFile = new File("JavaProjects\\dininer\\src\\FastFood.txt");

    public ArrayList<String> getList() throws IOException {

        ArrayList<String> restaurantChoices = new ArrayList<>();

        int i = 1;
        if (baseChoice == 1) {
            try {
                Scanner sitDownReader = new Scanner(sitDownFile);

                while (sitDownReader.hasNextLine()) {
    
                    String currentLine = sitDownReader.nextLine();
                    restaurantChoices.add(i + ". " + currentLine);
                    i++;
                }
                sitDownReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("A biggy back ate the photo..");
            }
        } 
        
        if (foodChoiceMultiplier == 7 || foodChoiceMultiplier == 4) {
            try {
                Scanner fastFoodReader = new Scanner(fastFoodFile);
            
             while (fastFoodReader.hasNextLine()) {
                    String currentLine = fastFoodReader.nextLine();
                    restaurantChoices.add(i + ". " + currentLine);
                    i++;
                }
                fastFoodReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("A REALLY biggy back ate BOTH of the photos..");
            }
        }
        return restaurantChoices;
    }

    public int getChoiceMultiplier(int multiplier, int base) {
        return multiplier - base;
    }

    public int getBaseChoice(int base) {
        return base;
    }

}
