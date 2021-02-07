package fighting.Model;

public class FighterModel {

    private String firstName;
    private String lastName;
    private String nickName;
    private int age;
    private String gender;
    private MeasurementModel fighterMeasurement;
    private FighterRecord fighterRecord;
    private StyleModel fighterStyle;

    public FighterModel() {

    }

    public FighterModel(String firstName, String lastName, String nickName, int age, String gender,
            MeasurementModel fighterMeasurement, FighterRecord fighterRecord, StyleModel fighterStyle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.age = age;
        this.gender = gender;
        this.fighterMeasurement = fighterMeasurement;
        this.fighterRecord = fighterRecord;
        this.fighterStyle = fighterStyle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        return "FighterModel [age=" + age + ", fighterMeasurement=" + fighterMeasurement + ", fighterRecord="
                + fighterRecord.quickView() + ", fighterStyle=" + fighterStyle + ", firstName=" + firstName
                + ", gender=" + gender + ", lastName=" + lastName + ", nickName=" + nickName + "]";
    }

}