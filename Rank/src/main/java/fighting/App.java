package fighting;

import fighting.Inputs.ScannerInputs;
import fighting.Menu.MenuDisplay;
import fighting.Methods.EnterFighter;
import fighting.Methods.SearchAndRemoveFighter;
import fighting.Methods.ViewMethods;
import fighting.Model.FighterModel;

/**
 * Hello world!
 *
 */
public class App {

    public void program() {
        int i = new MenuDisplay().mainMenu();
        SearchAndRemoveFighter searchRemove = new SearchAndRemoveFighter();
        ViewMethods viewing = new ViewMethods();
        switch (i) {
            case 1:
                new EnterFighter().enterNewFighter();
                break;
            case 2:
                FighterModel searchedFighter = searchRemove.search();
                viewing.viewFighters(searchedFighter);
                break;
            case 3:
                searchRemove.remove();
                break;
            case 4:
                viewing.viewOption();
                break;
            case 5:
                exitProgram();
        }
    }

    // Function To close the program
    public void exitProgram() {
        System.out.println("Closing Ranking....");
        ScannerInputs.closeScanner();
        System.exit(0);
    }

    public static void main(String[] args) {
        App runProgram = new App();
        while (true)
            runProgram.program();
    }
}
