package fighting.Inputs;

public class FighterInputs {

    // Get first name input from user
    public static String getFirstName() {
        String firstName = "";
        while (firstName.isBlank()) {
            System.out.print("Enter First Name: ");
            firstName = ScannerInputs.getString();
        }
        return firstName;
    }

    // Get last name input from user
    public static String getLastName() {
        String lastName = "";
        while (lastName.isBlank()) {
            System.out.print("Enter Last Name: ");
            lastName = ScannerInputs.getString();
        }
        return lastName;
    }

    // Get age input from user
    public static int getAge() {
        int age = 0;
        while (age < 19 || age > 45) {
            System.out.print("Enter Age: ");
            age = ScannerInputs.getInt();
        }
        return age;
    }

    // Get nickname input from user
    public static String getNickName() {
        String nickName = "";
        while (nickName.isBlank()) {
            System.out.print("Enter Nickname: ");
            nickName = ScannerInputs.getString();
        }
        return nickName;
    }

    // Get gender input from user
    public static String getGender() {
        String gender = "";
        while (gender.isBlank()) {
            System.out.print("Enter Gender(M/F): ");
            gender = ScannerInputs.getString();
            gender = pickGender(gender);
        }
        return gender;
    }

    // Get gender according to input
    private static String pickGender(String gender) {
        if (gender.equalsIgnoreCase("Male") || (gender.charAt(0) == 'M') || (gender.charAt(0) == 'm')) {
            gender = "Male";
        } else if (gender.equalsIgnoreCase("Female") || (gender.charAt(0) == 'F') || (gender.charAt(0) == 'f')) {
            gender = "Female";
        } else {
            return "";
        }
        return gender;
    }

    // Get wins input from user
    public static int getWins() {
        int wins = -1;
        while (wins < 0 || wins > 45) {
            System.out.print("Enter Wins: ");
            wins = ScannerInputs.getInt();
            winsStatement(wins);
        }
        return wins;
    }

    // Get wins statement display
    private static void winsStatement(int wins) {
        if (wins < 0) {
            System.err.println("Wins Cannot Be Less Than 0\n");
        } else if (wins > 45) {
            System.err.println("Wins Cannot Be More Than 45\n");
        } else {
            System.out.println(wins + " Win(s) Has Been Saved\n");
        }
    }

    // Get losses input from user
    public static int getLosses() {
        int losses = -1;
        while (losses < 0 || losses > 20) {
            System.out.print("Enter Losses: ");
            losses = ScannerInputs.getInt();
            lossStatement(losses);
        }
        return losses;
    }

    // Get losses statement display
    private static void lossStatement(int losses) {
        if (losses < 0) {
            System.err.println("Losses Cannot Be Less Than 0\n");
        } else if (losses > 20) {
            System.err.println("Wins Cannot Be More Than 20\n");
        } else {
            System.out.println(losses + " Loss(es) Has Been Saved\n");
        }
    }

    // Get draws input from user
    public static int getDraws() {
        int draws = -1;
        while (draws < 0 || draws > 10) {
            System.out.print("Enter Draws: ");
            draws = ScannerInputs.getInt();
            drawsStatement(draws);
        }
        return draws;
    }

    // Get draws statement display
    private static void drawsStatement(int draws) {
        if (draws < 0) {
            System.err.println("Draws Cannot Be Less Than 0\n");
        } else if (draws > 10) {
            System.err.println("Draws Cannot Be More Than 10\n");
        } else {
            System.out.println(draws + " Draw(s) Has Been Saved\n");
        }
    }

    // Get no contest input from user
    public static int getNoContest() {
        int noContest = -1;
        while (noContest < 0 || noContest > 5) {
            System.out.print("Enter No Contest: ");
            noContest = ScannerInputs.getInt();
            noContestStatement(noContest);
        }
        return noContest;
    }

    // Get no contest statement display
    private static void noContestStatement(int noContest) {
        if (noContest < 0) {
            System.err.println("No Contest Cannot Be Less Than 0\n");
        } else if (noContest > 5) {
            System.err.println("No Contest Cannot Be More Than 5\n");
        } else {
            System.out.println(noContest + " No Contest(s) Has Been Saved\n");
        }
    }
}