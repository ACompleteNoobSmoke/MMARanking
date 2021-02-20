package fighting.Model;

public class FighterModel implements Comparable<FighterModel> {

    private FighterInfo fighterInfo;
    private MeasurementModel fighterMeasurement;
    private FighterRecord fighterRecord;
    private StyleModel fighterStyle;

    public FighterModel() {

    }

    public FighterModel(FighterInfo fighterInfo, MeasurementModel fighterMeasurement, FighterRecord fighterRecord,
            StyleModel fighterStyle) {
        this.fighterInfo = fighterInfo;
        this.fighterMeasurement = fighterMeasurement;
        this.fighterRecord = fighterRecord;
        this.fighterStyle = fighterStyle;
    }

    public void setFighterInfo(FighterInfo fighterInfo) {
        this.fighterInfo = fighterInfo;
    }

    public FighterInfo getFighterInfo() {
        return fighterInfo;
    }

    public MeasurementModel getFighterMeasurement() {
        return fighterMeasurement;
    }

    public void setFighterMeasurement(MeasurementModel fighterMeasurement) {
        this.fighterMeasurement = fighterMeasurement;
    }

    public FighterRecord getFighterRecord() {
        return fighterRecord;
    }

    public void setFighterRecord(FighterRecord fighterRecord) {
        this.fighterRecord = fighterRecord;
    }

    public StyleModel getFighterStyle() {
        return fighterStyle;
    }

    public void setFighterStyle(StyleModel fighterStyle) {
        this.fighterStyle = fighterStyle;
    }

    @Override
    public String toString() {
        return "     \n *** Fighter Profile ***\n" + getFighterInfo().toString() + "\n\n"
                + getFighterMeasurement().toString() + " \n\n" + getFighterStyle().toString() + "\n\n"
                + getFighterRecord().toString();
    }

    @Override
    public int compareTo(FighterModel f) {
        return this.getFighterInfo().getLastName().compareToIgnoreCase(f.getFighterInfo().getLastName());
    }

}