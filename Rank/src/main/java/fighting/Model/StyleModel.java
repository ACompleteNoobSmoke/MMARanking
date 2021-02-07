package fighting.Model;

import fighting.Enums.GrapplingStyles;
import fighting.Enums.StrikingStyles;

public class StyleModel {

    private StrikingStyles striking;
    private GrapplingStyles grappling;

    public StyleModel() {
    }

    public StyleModel(StrikingStyles striking, GrapplingStyles grappling) {
        this.striking = striking;
        this.grappling = grappling;
    }

    public void setStriking(StrikingStyles striking) {
        this.striking = striking;
    }

    public StrikingStyles getStriking() {
        return striking;
    }

    public void setGrappling(GrapplingStyles grappling) {
        this.grappling = grappling;
    }

    public GrapplingStyles getGrappling() {
        return grappling;
    }

    public String toString() {
        return "Striking: " + striking + "\t\tGrappling: " + grappling;
    }

}
