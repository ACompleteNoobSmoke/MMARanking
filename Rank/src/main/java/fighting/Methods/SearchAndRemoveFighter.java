package fighting.Methods;

import fighting.Enums.WeightClass;
import fighting.Inputs.FighterInputs;
import fighting.Inputs.MeasurementInput;
import fighting.Model.FighterModel;

public class SearchAndRemoveFighter {

    // Search Fighter Method
    public FighterModel search() {
        System.out.println("*** Search Fighter ***");
        String firstName = FighterInputs.getFirstName();
        String lastName = FighterInputs.getLastName();
        String gender = FighterInputs.getGender();
        System.out.println("");
        WeightClass fighterClass = MeasurementInput.getWeightClassGender(gender);
        FighterModel fighter = DatabaseMethods.getSearchedFighter(firstName, lastName, gender, fighterClass);
        return fighter;
    }

    // Remove Fighter Method
    public void remove() {
        FighterModel removeFighter = search();
        if (removeFighter != null) {
            int fighterID = removeFighter.getFighterInfo().getFighterID();
            DatabaseMethods2.deleteFighter(fighterID);
            System.out.println("\n" + removeFighter.getFighterInfo().getFirstName() + " "
                    + removeFighter.getFighterInfo().getLastName() + " Has Been Removed From The Rankings\n");
            return;
        }
        System.out.println("Fighter Could Not Be Found!");
    }

}
