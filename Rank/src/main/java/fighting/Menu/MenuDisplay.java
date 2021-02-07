package fighting.Menu;

import fighting.Inputs.ScannerInputs;
import fighting.Enums.GrapplingStyles;
import fighting.Enums.StrikingStyles;
import fighting.Enums.WeightClass;

public class MenuDisplay {

    // Main Menu Display
    public int mainMenu() {
        int menuChoice = 0;
        while (menuChoice < 1 || menuChoice > 5) {
            System.out.println("*** Main Menu ***\n");
            System.out.println("1. Enter");
            System.out.println("2. Search");
            System.out.println("3. Remove");
            System.out.println("4. View");
            System.out.println("5. Exit");
            System.out.print("\nAction: ");
            menuChoice = ScannerInputs.getInt();
        }
        System.out.println("");
        return menuChoice;
    }

    // Search Menu Display
    // public int searchMenu() {
    // int searchChoice = 0;
    // while (searchChoice < 1 || searchChoice) {
    // System.out.println("*** Search Fighter ***\n");
    // System.out.println("1. Search(Name)")
    // }
    // }

    public void getWeightClassesMale() {
        WeightClass[] classes = WeightClass.values();
        for (int i = 0; i <= 7; i++) {
            System.out.println(i + 1 + ". " + classes[i]);
        }
    }

    // Display all of the striking styles
    public int displayStriking() {
        int strikingChoice = 0;
        StrikingStyles[] striking = StrikingStyles.values();

        while (strikingChoice < 1 || strikingChoice > 5) {
            System.out.println("STRIKING STYLES");
            int i = 0;
            for (StrikingStyles strikes : striking) {
                System.out.println(++i + ". " + strikes);
            }
            System.out.print("\nAction: ");
            strikingChoice = ScannerInputs.getInt();
        }
        System.out.println("");
        return strikingChoice;
    }

    // Display all of the grappling styles
    public int displayGrappling() {
        int grapplingChoice = 0;
        GrapplingStyles[] grappling = GrapplingStyles.values();

        while (grapplingChoice < 1 || grapplingChoice > 4) {
            System.out.println("GRAPPLING STYLES");
            int i = 0;
            for (GrapplingStyles grapple : grappling) {
                System.out.println(++i + ". " + grapple);
            }
            System.out.print("\nAction: ");
            grapplingChoice = ScannerInputs.getInt();
        }
        System.out.println("");
        return grapplingChoice;
    }

    public static void main(String[] args) {
        MenuDisplay menu = new MenuDisplay();
        menu.getWeightClassesMale();
    }
}
