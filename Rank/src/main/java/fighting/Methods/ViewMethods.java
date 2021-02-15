package fighting.Methods;

import fighting.Enums.WeightClass;
import fighting.Inputs.FighterInputs;
import fighting.Inputs.MeasurementInput;
import fighting.Model.FighterModel;

public class ViewMethods {

    // View Fighter that are searched for
    private FighterModel viewSearchFighter() {
        SearchAndRemoveFighter searching = new SearchAndRemoveFighter();
        FighterModel searchFighter = searching.search();
        System.out.println("*** View Fighter ***\n");
        if (searchFighter != null) {
            System.out.println(searchFighter);
        } else {
            System.out.println(" \nFighter Cannot Be Found\n");
        }
        return searchFighter;
    }

    // View all fighters according to their gender
    private FighterModel[] viewAllGender() {
        String gender = FighterInputs.getGender();
        FighterModel[] fightersGender = DatabaseMethods2.genderFighterArray(gender);
        System.out.println("*** View All (" + gender + ") Fighters ***\n");
        if (fightersGender != null) {
            for (FighterModel fighters : fightersGender) {
                System.out.println(fighters);
            }
            return fightersGender;
        } else {
            System.out.println("\n" + gender + " Fighters Ranking Is Currently Empty\n");
        }
        return null;
    }

    // View fighters according to their gender and weightclass
    private FighterModel[] viewAllGenderWeight() {
        String gender = FighterInputs.getGender();
        WeightClass weightClass = MeasurementInput.getWeightClassGender(gender);
        FighterModel[] fighterWeight = DatabaseMethods2.genderFighterArray(gender, weightClass);
        System.out.println("*** View All (" + gender + ") Fighters ***\n");
        if (fighterWeight != null) {
            for (FighterModel fighters : fighterWeight) {
                System.out.println(fighters);
            }
            return fighterWeight;
        } else {
            System.out.println("\n" + gender + " Fighters Ranking Is Currently Empty\n");
        }
        return null;
    }

    public static void main(String[] args) {
        ViewMethods viewing = new ViewMethods();
        // viewing.viewSearchFighter();
        viewing.viewAllGenderWeight();
    }

}
