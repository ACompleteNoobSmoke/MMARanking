package fighting.Methods;

import fighting.Enums.WeightClass;

import fighting.Inputs.MeasurementInput;
import fighting.Menu.MenuDisplay;
import fighting.Model.FighterModel;

public class ViewMethods {

    public void viewOption() {
        MenuDisplay DM = new MenuDisplay();
        int viewChoicePick = DM.displayViewMenu();
        if (viewChoicePick != 3) {
            Object fighterView = null;
            if (viewChoicePick == 1) {
                fighterView = viewSearchFighter();
            } else if (viewChoicePick == 2) {
                fighterView = viewAllChoices(DM);
            }
            viewFighters(fighterView);
        }
    }

    // View Fighter that are searched for
    private FighterModel viewSearchFighter() {
        SearchAndRemoveFighter searching = new SearchAndRemoveFighter();
        FighterModel searchFighter = searching.search();
        System.out.println("*** View Fighter ***\n");
        if (searchFighter == null) {
            System.out.println(" \nFighter Cannot Be Found\n");
        }
        return searchFighter;
    }

    // Get all from the Display all choice
    private FighterModel[] viewAllChoices(MenuDisplay menu) {
        int viewAllChoicesPick = menu.displayAllMenu();
        FighterModel[] viewAllFighters = null;
        if (viewAllChoicesPick != 5) {
            if (viewAllChoicesPick == 1 || viewAllChoicesPick == 2) {
                viewAllFighters = viewAllGender(viewAllChoicesPick);
            } else if (viewAllChoicesPick == 3) {
                viewAllFighters = viewAllInWeightClassChoices(menu);
            } else if (viewAllChoicesPick == 4) {
                viewAllFighters = viewAllFighters();
            }
            return viewAllFighters;
        }
        return null;
    }

    // View all fighters according to their gender
    private FighterModel[] viewAllGender(int genderChoice) {
        String gender = genderChoice == 1 ? "Male" : "Female";
        FighterModel[] fightersGender = DatabaseMethods2.genderFighterArray(gender);
        System.out.println("*** View All (" + gender + ") Fighters ***\n");
        if (fightersGender == null) {
            System.out.println("\n" + gender + " Fighters Ranking Is Currently Empty\n");
        }
        return fightersGender;
    }

    // Option for the view all in the weight class
    private FighterModel[] viewAllInWeightClassChoices(MenuDisplay menu) {
        int viewGenderChoicesPick = menu.displayWeightMenu();
        FighterModel[] viewGenderFighters = null;
        if (viewGenderChoicesPick != 4) {
            if (viewGenderChoicesPick == 1 || viewGenderChoicesPick == 2) {
                viewGenderFighters = viewAllGenderWeight(viewGenderChoicesPick);
            } else if (viewGenderChoicesPick == 3) {
                viewGenderFighters = viewAllWeight();
            }
            return viewGenderFighters;
        }
        return viewGenderFighters;
    }

    // View fighters according to their gender and weightclass
    private FighterModel[] viewAllGenderWeight(int genderChoice) {
        String gender = genderChoice == 1 ? "Male" : "Female";
        WeightClass weightClass = MeasurementInput.getWeightClassGender(gender);
        FighterModel[] fighterWeight = DatabaseMethods2.genderFighterArray(gender, weightClass);
        System.out.println("*** View All (" + gender + ") Fighters ***\n");
        if (fighterWeight == null) {
            System.out.println("\n" + gender + " Fighters Ranking Is Currently Empty\n");
        }
        return fighterWeight;
    }

    // View all fighters in 1 specific weight class
    private FighterModel[] viewAllWeight() {
        WeightClass weightClass = MeasurementInput.getWeightClass();
        FighterModel[] weightFighters = DatabaseMethods2.weightFighterArray(weightClass);
        if (weightFighters == null) {
            System.out.println("\n Weight Class: " + weightClass + " Currently Empty\n");
        }
        return weightFighters;
    }

    // View all fighters in the database
    private FighterModel[] viewAllFighters() {
        FighterModel[] allFighters = DatabaseMethods2.allFighterArray();
        if (allFighters == null) {
            System.out.println("\n Fighter Rankings Are Currently Empty\n");
        }
        return allFighters;
    }

    // View FighterModel Objects
    private void viewFighters(Object viewFighters) {
        if (viewFighters instanceof FighterModel) {
            System.out.println(viewFighters);
        } else if (viewFighters instanceof FighterModel[]) {
            FighterModel[] viewThese = (FighterModel[]) viewFighters;
            for (FighterModel fighter : viewThese) {
                System.out.println(fighter);
                System.out.println("");
            }
        }
    }
}
