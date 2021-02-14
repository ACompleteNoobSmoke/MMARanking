package fighting.Methods;

import fighting.Enums.WeightClass;
import fighting.Inputs.FighterInputs;
import fighting.Inputs.MeasurementInput;
import fighting.Model.FighterModel;

public class SearchFighter {

    // Search Fighter Method;
    public void search() {
        System.out.println("*** Search Fighter ***");
        String firstName = FighterInputs.getFirstName();
        String lastName = FighterInputs.getLastName();
        String gender = FighterInputs.getGender();
        System.out.println("");
        WeightClass fighterClass = MeasurementInput.getWeightClassGender(gender);
        FighterModel fighter = DatabaseMethods.getSearchedFighter(firstName, lastName, gender, fighterClass);
        System.out.println("\n" + fighter);
    }

}
