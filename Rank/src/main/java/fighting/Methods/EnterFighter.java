package fighting.Methods;

import fighting.Enums.GrapplingStyles;
import fighting.Enums.StrikingStyles;
import fighting.Enums.WeightClass;
import fighting.Inputs.FighterInputs;
import fighting.Inputs.MeasurementInput;
import fighting.Inputs.StyleInputs;
import fighting.Model.FighterModel;
import fighting.Model.FighterRecord;
import fighting.Model.MeasurementModel;
import fighting.Model.StyleModel;

public class EnterFighter {

    public void enterNewFighter() {
        System.out.println("*** Enter New Fighter ***");
        String firstName = FighterInputs.getFirstName();
        String lastName = FighterInputs.getLastName();
        String nickName = FighterInputs.getNickName();
        String gender = FighterInputs.getGender();
        int age = FighterInputs.getAge();
        System.out.println("");

        // Fighter Measurement
        MeasurementModel fighterMeasurement = enterMeasurement(gender);

        // Fighter Fighting Style
        StyleModel fighterStyle = enterStyle();

        // Fighter Record
        FighterRecord fighterRecords = enterRecord();

        FighterModel newFighter = new FighterModel(firstName, lastName, nickName, age, gender, fighterMeasurement,
                fighterRecords, fighterStyle);
        System.out.println(newFighter);

    }

    // Enter Fighter Measurement
    private MeasurementModel enterMeasurement(String gender) {
        System.out.println("*** Fighter Body Measurements ***\n");
        String height = MeasurementInput.getHeight();
        double weight = MeasurementInput.getWeight(gender);
        WeightClass weightClass = MeasurementInput.getWeightClass(gender, weight);
        System.out.println("According to your weight of " + weight + "lbs");
        System.out.println("Your weight class is " + weightClass.toString());
        System.out.println("");
        return new MeasurementModel(weightClass, weight, height);
    }

    // Enter Fighter Record
    private FighterRecord enterRecord() {
        System.out.println("*** Fighter Record ***\n");
        int wins = FighterInputs.getWins();
        int losses = FighterInputs.getLosses();
        int draws = FighterInputs.getDraws();
        int noContest = FighterInputs.getNoContest();
        System.out.println("");
        return new FighterRecord(wins, losses, draws, noContest);
    }

    // Enter Fighter Styles
    private StyleModel enterStyle() {
        System.out.println("*** Fighter Style ***\n");
        StrikingStyles striking = StyleInputs.getStriking();
        GrapplingStyles grappling = StyleInputs.getGrappling();
        System.out.println("");
        return new StyleModel(striking, grappling);
    }

    public static void main(String[] args) {
        EnterFighter fighter = new EnterFighter();
        fighter.enterNewFighter();
    }

}
