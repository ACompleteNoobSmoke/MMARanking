package fighting.Inputs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInputs {

    private static Scanner scan = new Scanner(System.in);

    public static int getInt() {
        int newInt = 0;
        try {
            newInt = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException e) {
            scan.nextLine();
        }
        return newInt;
    }

    public static String getString() {
        String newString = "";
        newString = scan.nextLine();
        return newString;
    }

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

    public static void closeScanner() {
        scan.close();
    }

}
