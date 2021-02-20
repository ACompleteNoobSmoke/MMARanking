package fighting.Model;

import fighting.Enums.WeightClass;

public class MeasurementModel {

    private String gender;
    private WeightClass weightClass;
    private double weight;
    private String height;

    public MeasurementModel() {

    }

    public MeasurementModel(String gender, WeightClass weightClass, double weight, String height) {
        this.gender = gender;
        this.weightClass = weightClass;
        this.weight = weight;
        this.height = height;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setWeightClass(WeightClass weightClass) {
        this.weightClass = weightClass;
    }

    public WeightClass getWeightClass() {
        return weightClass;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHeight() {
        return height;
    }

    public String toString() {
        return title() + "Gender: " + gender + "\n" + "Height:  " + height + "\n" + "Weight: " + weight + " lbs\n"
                + "Weight Class: " + weightClass;
    }

    public String title() {
        return "*** Fighter Body Measurements ***\n";
    }

}