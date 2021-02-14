package fighting.Inputs;

import fighting.Menu.MenuDisplay;
import fighting.Enums.GrapplingStyles;
import fighting.Enums.StrikingStyles;

public class StyleInputs {

    // Get striking input from user
    public static StrikingStyles getStriking() {
        StrikingStyles striking = null;
        MenuDisplay menu = new MenuDisplay();
        int strikePick = menu.displayStriking();
        striking = pickedStrike(strikePick, striking);
        return striking;
    }

    // Returns striking enum
    private static StrikingStyles pickedStrike(int strikePick, StrikingStyles striking) {
        StrikingStyles[] strikeArray = StrikingStyles.values();
        strikePick--;
        for (int i = 0; i <= 4; i++) {
            striking = strikeArray[i];
            if (strikePick == i) {
                break;
            }
        }

        return striking;
    }

    // Get grappling input from user
    public static GrapplingStyles getGrappling() {
        GrapplingStyles grappling = null;
        MenuDisplay grapplingMenu = new MenuDisplay();
        int grapplePick = grapplingMenu.displayGrappling();
        grappling = pickedGrappling(grapplePick, grappling);
        return grappling;
    }

    // Returns grappling enum
    public static GrapplingStyles pickedGrappling(int grapplePick, GrapplingStyles grappling) {
        GrapplingStyles[] grappleArray = GrapplingStyles.values();
        grapplePick--;
        for (int i = 0; i <= 3; i++) {
            grappling = grappleArray[i];
            if (grapplePick == i) {
                break;
            }
        }
        return grappling;
    }

}
