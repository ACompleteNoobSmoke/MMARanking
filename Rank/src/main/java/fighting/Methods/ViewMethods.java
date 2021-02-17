package fighting.Methods;

import fighting.Enums.WeightClass;
import fighting.Inputs.MeasurementInput;
import fighting.Menu.MenuDisplay;
import fighting.Menu.TableDisplay;
import fighting.Model.FighterModel;

public class ViewMethods {

    // View Options
    public void viewOption() {
        MenuDisplay DM = new MenuDisplay();
        int viewChoicePick = DM.displayViewMenu();
        if (viewChoicePick != 3) {
            if (viewChoicePick == 1) {
                viewSearchFighter();
            } else if (viewChoicePick == 2) {
                viewAllChoices(DM);
            }
        }
    }

    // View Fighter that are searched for
    private void viewSearchFighter() {
        SearchAndRemoveFighter searching = new SearchAndRemoveFighter();
        FighterModel searchFighter = searching.search();
        System.out.println("*** View Fighter ***\n");
        if (searchFighter == null) {
            System.out.println(" \nFighter Cannot Be Found\n");
            return;
        }
        viewFighters(searchFighter);
    }

    // Get all from the Display all choice
    private void viewAllChoices(MenuDisplay menu) {
        boolean previous = false;
        while (!previous) {
            int viewAllChoicesPick = menu.displayAllMenu();
            if (viewAllChoicesPick != 5) {
                if (viewAllChoicesPick == 1 || viewAllChoicesPick == 2) {
                    viewAllGender(viewAllChoicesPick);
                } else if (viewAllChoicesPick == 3) {
                    previous = viewAllInWeightClassChoices(menu);
                } else if (viewAllChoicesPick == 4) {
                    viewAllFighters();
                }
            } else {
                previous = true;
            }
        }
    }

    // View all fighters according to their gender
    private void viewAllGender(int genderChoice) {
        String gender = genderChoice == 1 ? "Male" : "Female";
        FighterModel[] fightersGender = DatabaseMethods2.genderFighterArray(gender);
        System.out.println("*** View All (" + gender + ") Fighters ***\n");
        if (fightersGender == null) {
            System.out.println("\n" + gender + " Fighters Ranking Is Currently Empty\n");
            return;
        }
        viewFighters(fightersGender);
        new TableDisplay().genderSpecificTable(gender, fightersGender);
    }

    // Option for the view all in the weight class
    private boolean viewAllInWeightClassChoices(MenuDisplay menu) {
        boolean previous = true;
        while (previous) {
            int viewGenderChoicesPick = menu.displayWeightMenu();
            if (viewGenderChoicesPick != 4) {
                if (viewGenderChoicesPick == 1 || viewGenderChoicesPick == 2) {
                    viewAllGenderWeight(viewGenderChoicesPick);
                } else if (viewGenderChoicesPick == 3) {
                    viewAllWeight();
                }
            } else {
                previous = false;
            }
        }
        return previous;
    }

    // View fighters according to their gender and weightclass
    private void viewAllGenderWeight(int genderChoice) {
        String gender = genderChoice == 1 ? "Male" : "Female";
        WeightClass weightClass = MeasurementInput.getWeightClassGender(gender);
        FighterModel[] fighterWeight = DatabaseMethods2.genderFighterArray(gender, weightClass);
        System.out.println("*** View All (" + gender + ") Fighters ***\n");
        if (fighterWeight == null) {
            System.out.println("\n" + gender + " Fighters Ranking Is Currently Empty\n");
            return;
        }
        viewFighters(fighterWeight);
        new TableDisplay().genderSpecificTable(gender, fighterWeight);
    }

    // View all fighters in 1 specific weight class
    private void viewAllWeight() {
        WeightClass weightClass = MeasurementInput.getWeightClass();
        FighterModel[] weightFighters = DatabaseMethods2.weightFighterArray(weightClass);
        if (weightFighters == null) {
            System.out.println("\n Weight Class: " + weightClass + " Currently Empty\n");
            return;
        }
        viewFighters(weightFighters);
        new TableDisplay().viewAllTable(weightFighters);
    }

    // View all fighters in the database
    private void viewAllFighters() {
        FighterModel[] allFighters = DatabaseMethods2.allFighterArray();
        if (allFighters == null) {
            System.out.println("\n Fighter Rankings Are Currently Empty\n");
            return;
        }
        viewFighters(allFighters);
        new TableDisplay().viewAllTable(allFighters);
    }

    // View FighterModel Objects
    public void viewFighters(Object viewFighters) {
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

    public static void main(String[] arg) {
        ViewMethods v = new ViewMethods();
        while (true) {
            v.viewOption();
        }
    }
}
