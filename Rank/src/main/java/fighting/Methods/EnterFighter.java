package fighting.Methods;

import java.util.Random;

import fighting.Database.InsertDatabase;
import fighting.Enums.GrapplingStyles;
import fighting.Enums.StrikingStyles;
import fighting.Enums.WeightClass;
import fighting.Inputs.FighterInputs;
import fighting.Inputs.MeasurementInput;
import fighting.Inputs.StyleInputs;

public class EnterFighter {

    // Contains all the methods to add fighter to database
    public void enterNewFighter() {
        System.out.println("*** Enter New Fighter ***");
        int fighterID = getFighterID();
        enterFighterInfo(fighterID);
        // Fighter Measurement
        enterMeasurement(fighterID);
        // Fighter Fighting Style
        enterStyle(fighterID);
        // Fighter Record
        enterRecord(fighterID);
    }

    // Get Random ID For Fighter
    private int getFighterID() {
        boolean exists = true;
        int fighterID = 0;
        Random rando = new Random();
        while (exists) {
            fighterID = rando.nextInt(2000);
            exists = InsertDatabase.checkFighterID(fighterID);
        }
        return fighterID;

    }

    // Enter Fighter Information
    private void enterFighterInfo(int fighterID) {
        String firstName = FighterInputs.getFirstName();
        String lastName = FighterInputs.getLastName();
        String nickName = FighterInputs.getNickName();
        int age = FighterInputs.getAge();
        System.out.println("");
        InsertDatabase.insertFighterInfo(fighterID, firstName, lastName, nickName, age);
    }

    // Enter Fighter Measurement
    private void enterMeasurement(int fighterID) {
        System.out.println("*** Fighter Body Measurements ***\n");
        String gender = FighterInputs.getGender();
        String height = MeasurementInput.getHeight();
        double weight = MeasurementInput.getWeight(gender);
        WeightClass weightClass = MeasurementInput.getWeightClass(gender, weight);
        System.out.println("According to your weight of " + weight + "lbs");
        System.out.println("Your weight class is " + weightClass.toString());
        System.out.println("");
        InsertDatabase.insertFighterBody(fighterID, gender, height, weight, weightClass);
    }

    // Enter Fighter Record
    private void enterRecord(int fighterID) {
        System.out.println("*** Fighter Record ***\n");
        int wins = FighterInputs.getWins();
        int losses = FighterInputs.getLosses();
        int draws = FighterInputs.getDraws();
        int noContest = FighterInputs.getNoContest();
        System.out.println("");
        InsertDatabase.insertFighterRecord(fighterID, wins, losses, draws, noContest);
    }

    // Enter Fighter Styles
    private void enterStyle(int fighterID) {
        System.out.println("*** Fighter Style ***\n");
        StrikingStyles striking = StyleInputs.getStriking();
        GrapplingStyles grappling = StyleInputs.getGrappling();
        System.out.println("");
        InsertDatabase.insertFighterStyle(fighterID, striking, grappling);
    }

}
