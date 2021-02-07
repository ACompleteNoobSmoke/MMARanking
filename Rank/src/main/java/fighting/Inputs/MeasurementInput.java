package fighting.Inputs;

import fighting.Model.WeightClass;

public class MeasurementInput {

    public static double getWeight() {
        double weight = 0;
        while (weight < 115 || weight > 265) {
            System.out.print("Enter Weight: ");
            weight = ScannerInputs.getDouble();
        }
        return weight;
    }

    private static int getFeet() {
        int feet = 0;
        while (feet < 5 || feet > 6) {
            System.out.print("Feet: ");
            feet = ScannerInputs.getInt();
        }
        return feet;
    }

    public static int getInch() {
        int inch = -1;
        while (inch < 0 || inch > 11) {
            System.out.print("Inch: ");
            inch = ScannerInputs.getInt();
        }
        return inch;
    }

    public static String getHeight() {
        String height = "";
        int feet = 0;
        int inch = 0;
        while (height.isBlank()) {
            System.out.println("Enter Height");
            feet = getFeet();
            inch = getInch();
            if (inch == 0) {
                height = Integer.toString(feet);
            } else {
                height = feet + "'" + inch + "\"" + "\"";
            }
        }
        return height;
    }

    public static WeightClass getWeightClass(String gender, double weight) {
        WeightClass weightClass = null;
        if (gender.equalsIgnoreCase("Male")) {
            weightClass = getWeightClassMale(weight);
        } else if (gender.equalsIgnoreCase("Female")) {
            weightClass = getWeightClassFemale(weight);
        }
        return weightClass;
    }

    public static WeightClass getWeightClass(double weight) {
        WeightClass weightClass = null;
        if (weight >= 105 && weight <= 116) {
            weightClass = WeightClass.Strawweight;
        } else if (weight > 116 && weight <= 126) {
            weightClass = WeightClass.Flyweight;
        } else if (weight > 126 && weight <= 136) {
            weightClass = WeightClass.Bantamweight;
        } else if (weight > 136 && weight <= 146) {
            weightClass = WeightClass.Featherweight;
        } else if (weight > 146 && weight <= 156) {
            weightClass = WeightClass.Lightweight;
        } else if (weight > 156 && weight <= 171) {
            weightClass = WeightClass.Welterweight;
        } else if (weight > 171 && weight <= 186) {
            weightClass = WeightClass.Middleweight;
        } else if (weight > 186 && weight <= 206) {
            weightClass = WeightClass.LightHeavyweight;
        } else if (weight > 206 && weight <= 266) {
            weightClass = WeightClass.Heavyweight;
        }
        return weightClass;
    }

    public static WeightClass getWeightClassMale(double weight) {
        WeightClass weightClass = null;
        if (weight > 116 && weight <= 126) {
            weightClass = WeightClass.Flyweight;
        } else if (weight > 126 && weight <= 136) {
            weightClass = WeightClass.Bantamweight;
        } else if (weight > 136 && weight <= 146) {
            weightClass = WeightClass.Featherweight;
        } else if (weight > 146 && weight <= 156) {
            weightClass = WeightClass.Lightweight;
        } else if (weight > 156 && weight <= 171) {
            weightClass = WeightClass.Welterweight;
        } else if (weight > 171 && weight <= 186) {
            weightClass = WeightClass.Middleweight;
        } else if (weight > 186 && weight <= 206) {
            weightClass = WeightClass.LightHeavyweight;
        } else if (weight > 206 && weight <= 266) {
            weightClass = WeightClass.Heavyweight;
        }
        return weightClass;
    }

    public static WeightClass getWeightClassFemale(double weight) {
        WeightClass weightClass = null;
        if (weight >= 105 && weight <= 116) {
            weightClass = WeightClass.Strawweight;
        } else if (weight > 116 && weight <= 126) {
            weightClass = WeightClass.Flyweight;
        } else if (weight > 126 && weight <= 136) {
            weightClass = WeightClass.Bantamweight;
        } else if (weight > 136 && weight <= 146) {
            weightClass = WeightClass.Featherweight;
        }
        return weightClass;
    }

}
