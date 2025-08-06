import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ProgramData {

    public ProgramData() {
        createLists();
    }

    protected ArrayList<String> restaurantChoices = new ArrayList<>();
    protected ArrayList<String> sitDownList = new ArrayList<>();
    protected ArrayList<String> fastFoodList = new ArrayList<>();
    
    File sitDownFile = new File("JavaProjects\\dininer\\src\\SitDown.txt");
    File fastFoodFile = new File("JavaProjects\\dininer\\src\\FastFood.txt");

    public void createLists() {
        try {
            Scanner sitDownReader = new Scanner(sitDownFile);

            while (sitDownReader.hasNextLine()) {
    
                String currentLine = sitDownReader.nextLine();
                restaurantChoices.add(currentLine);
                sitDownList.add(currentLine);
            }
            sitDownReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("A biggy back ate the photo..");
        }
        
        try {
            Scanner fastFoodReader = new Scanner(fastFoodFile);
            
            while (fastFoodReader.hasNextLine()) {
                String currentLine = fastFoodReader.nextLine();
                restaurantChoices.add(currentLine);
                fastFoodList.add(currentLine);
            }
            fastFoodReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("A REALLY biggy back ate BOTH of the photos..");
        }
    }

    public ArrayList<String> getFullList() {
        return restaurantChoices;
    }

    public ArrayList<String> getSitList() {
        return sitDownList;
    }

    public ArrayList<String> getFastList() {
        return fastFoodList;
    }

    public File getSitFile() {
        return sitDownFile;
    }

    public File getFastFile() {
        return fastFoodFile;
    }

    public File getThisFUckingFileNowPleasee(File file) {
        return file;
    }

    public File getCurrentFile(ArrayList<String> list) {
        File file = new File("null");
        if (getSitList().equals(list)) {
            file = getSitFile();
        } else if (getFastList().equals(list)) {
            file = getFastFile();
        }
        return file;
    }
}
