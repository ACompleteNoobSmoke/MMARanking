package fighting.Inputs;

public class FighterInputs {

    public static String getFirstName() {
        String firstName = "";
        while (firstName.isBlank()) {
            System.out.print("Enter First Name: ");
            firstName = ScannerInputs.getString();
        }
        return firstName;
    }

    public static String getLastName() {
        String lastName = "";
        while (lastName.isBlank()) {
            System.out.print("Enter Last Name: ");
            lastName = ScannerInputs.getString();
        }
        return lastName;
    }

    public static int getAge() {
        int age = 0;
        while (age < 19 || age > 45) {
            System.out.print("Enter Age: ");
            age = ScannerInputs.getInt();
        }
        return age;
    }

    public static String getNickName() {
        String nickName = "";
        while (nickName.isBlank()) {
            System.out.print("Enter Nickname: ");
            nickName = ScannerInputs.getString();
        }
        return nickName;
    }
}