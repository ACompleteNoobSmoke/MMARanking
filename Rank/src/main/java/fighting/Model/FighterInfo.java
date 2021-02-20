package fighting.Model;

public class FighterInfo {
    private int fighterID;
    private String firstName;
    private String lastName;
    private String nickName;
    private int age;

    public FighterInfo(int fighterID, String firstName, String lastName, String nickName, int age) {
        this.fighterID = fighterID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.age = age;
    }

    public int getFighterID() {
        return fighterID;
    }

    public void setFighterID(int fighterID) {
        this.fighterID = fighterID;
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

    public String toString() {
        return "Name: " + firstName + " " + ((nickName.isBlank()) ? "" : "\"" + nickName + "\" ") + lastName + "\n"
                + "Age " + age;
    }

}
