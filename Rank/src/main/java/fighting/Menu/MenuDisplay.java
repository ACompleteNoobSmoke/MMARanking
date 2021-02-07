package fighting.Menu;

import fighting.Inputs.ScannerInputs;
import fighting.Model.GrapplingStyles;
import fighting.Model.StrikingStyles;

public class MenuDisplay {

    // Display all of the striking styles
    public int displayStriking() {
        int strikingChoice = 0;
        StrikingStyles[] striking = StrikingStyles.values();

        while (strikingChoice < 1 || strikingChoice > 5) {
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
}
