package fighting.Model;

public class MeasurementModel {

    private WeightClass weightClass;
    private double weight;
    private String height;

    public MeasurementModel() {

    }

    public MeasurementModel(WeightClass weightClass, double weight, String height) {
        this.weightClass = weightClass;
        this.weight = weight;
        this.height = height;
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
        return "Weight Class: " + weightClass + "\n" + "Weight: " + weight + " lbs\n" + "Height:  " + height;
    }

}