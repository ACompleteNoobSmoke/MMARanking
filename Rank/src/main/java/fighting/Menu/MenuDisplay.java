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

    // Display weight classes for males
    public int showWeightClassesMale() {
        WeightClass[] classes = WeightClass.values();
        int showPick = 0;
        while (showPick < 1 || showPick > 8) {
            System.out.println("*** WeightClass(Male) ***\n");
            for (int i = 0; i <= 7; i++) {
                System.out.println(i + 1 + ". " + classes[i]);
            }
            System.out.print("\nAction: ");
            showPick = ScannerInputs.getInt();
        }
        return showPick;
    }

    // Display All Weight Class
    public int displayWeightClass() {
        WeightClass[] classes = WeightClass.values();
        int pick = 0;
        while (pick < 1 || pick > 8) {
            System.out.println("*** Weight Classes ***\n");
            for (int i = 0; i < 8; i++) {
                System.out.println(i + 1 + ". " + classes[i]);
            }
            System.out.print("\nAction: ");
            pick = ScannerInputs.getInt();
            System.out.println("");
        }
        return pick;
    }

    // Returns male weight class according to user input
    public WeightClass getWeightClassMale() {
        int maleWeightPick = showWeightClassesMale();
        WeightClass[] classesMale = WeightClass.values();
        WeightClass weightC = null;
        for (int i = 0; i <= 7; i++) {
            weightC = classesMale[i];
            if (maleWeightPick == (i + 1)) {
                break;
            }
        }
        return weightC;
    }

    // Display weight class for females
    public int showWeightClassesFemale() {
        WeightClass[] classes = WeightClass.values();
        int showPick = 0;
        while (showPick < 1 || showPick > 4) {
            System.out.println("*** WeightClass(Female) ***\n");
            int j = 0;
            for (int i = 5; i <= 8; i++) {
                System.out.println(++j + ". " + classes[i]);
            }
            System.out.print("\nAction: ");
            showPick = ScannerInputs.getInt();
        }
        return showPick;
    }

    // Returns female weight class according to user input
    public WeightClass getWeightClassFemale() {
        int femaleWeightPick = showWeightClassesFemale();
        WeightClass[] classesFemale = WeightClass.values();
        WeightClass weightC = null;
        for (int i = 5; i <= 8; i++) {
            weightC = classesFemale[i];
            if (femaleWeightPick == (i - 4)) {
                break;
            }
        }
        return weightC;
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

    // Main View Menu
    public int displayViewMenu() {
        int viewPick = 0;
        while (viewPick < 1 || viewPick > 3) {
            System.out.println("*** View Menu ***\n");
            System.out.println("1. View Search Fighter");
            System.out.println("2. View Fighters");
            System.out.println("3. Back");
            System.out.print("\nAction: ");
            viewPick = ScannerInputs.getInt();
            System.out.println("");
        }
        return viewPick;
    }

    // The menu for the View All option
    public int displayAllMenu() {
        int viewAllPick = 0;
        while (viewAllPick < 1 || viewAllPick > 5) {
            System.out.println("*** View All Menu ***\n");
            System.out.println("1. View All(Male)");
            System.out.println("2. View All(Female)");
            System.out.println("3. View All(Weight Class)");
            System.out.println("4. View All Fighters");
            System.out.println("5. Back");
            System.out.print("\nAction: ");
            viewAllPick = ScannerInputs.getInt();
            System.out.println("");
        }
        return viewAllPick;
    }

    // The menu for the View All(Weight Class) option
    public int displayWeightMenu() {
        int viewAllWeightPick = 0;
        while (viewAllWeightPick < 1 || viewAllWeightPick > 4) {
            System.out.println("*** View All(Weight Class) ***");
            System.out.println("1. Male Weight Class");
            System.out.println("2. Female Weight Class");
            System.out.println("3. Weight Class");
            System.out.println("4. Back");
            System.out.print("\nAction: ");
            viewAllWeightPick = ScannerInputs.getInt();
        }
        return viewAllWeightPick;
    }
}
