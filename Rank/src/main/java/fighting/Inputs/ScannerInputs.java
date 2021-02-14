package fighting.Inputs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInputs {

    private static Scanner scan = new Scanner(System.in);

    // Get scanner
    public static Scanner getScanner() {
        return scan;
    }

    // Get int inputs from user
    public static int getInt() {
        int newInt = 0;
        try {
            while (!scan.hasNextInt()) {
                scan.next();
                return -1;
            }
            newInt = scan.nextInt();
        } catch (InputMismatchException e) {
            scan.nextLine();
        }
        scan.nextLine();
        return newInt;
    }

    // Get string input from user
    public static String getString() {
        String newString = "";
        newString = scan.nextLine();
        return newString;
    }

    // Get double input from user
    public static double getDouble() {
        double newDouble = 0;
        try {
            newDouble = scan.nextDouble();
            scan.nextLine();
        } catch (InputMismatchException e) {
            scan.nextLine();
        }
        return newDouble;
    }

    // Closes scanner
    public static void closeScanner() {
        scan.close();
    }

}
