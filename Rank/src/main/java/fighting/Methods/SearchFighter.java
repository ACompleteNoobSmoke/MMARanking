package fighting.Methods;

import fighting.Inputs.FighterInputs;
import fighting.Inputs.ScannerInputs;

public class SearchFighter {

    public void search() {
        System.out.println("*** Search Fighter ***");
        String firstName = FighterInputs.getFirstName();
        String lastName = FighterInputs.getLastName();
        String gender = FighterInputs.getGender();
    }

}
