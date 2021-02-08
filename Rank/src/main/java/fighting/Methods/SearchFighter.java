package fighting.Methods;

import fighting.Enums.WeightClass;
import fighting.Inputs.FighterInputs;
import fighting.Inputs.MeasurementInput;

public class SearchFighter {

    public void search() {
        System.out.println("*** Search Fighter ***");
        String firstName = FighterInputs.getFirstName();
        String lastName = FighterInputs.getLastName();
        String gender = FighterInputs.getGender();
        System.out.println("");
        WeightClass fighterClass = MeasurementInput.getWeightClassGender(gender);
        System.out.println("\n" + fighterClass);
    }

    public static void main(String[] args) {
        SearchFighter sFighter = new SearchFighter();
        sFighter.search();

    }

}
