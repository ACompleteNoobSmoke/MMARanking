package fighting.Methods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fighting.Enums.GrapplingStyles;
import fighting.Enums.StrikingStyles;
import fighting.Enums.WeightClass;
import fighting.Model.FighterInfo;
import fighting.Model.FighterModel;
import fighting.Model.FighterRecord;
import fighting.Model.MeasurementModel;
import fighting.Model.StyleModel;

public class DatabaseMethods {

    public static boolean checkFighterID(int fighterID) {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FighterRank?autoReconnect=true&useSSL=false", "root", "codingroot1!");
            PreparedStatement ps = con.prepareStatement("Select FighterID From `FighterInfo` Where FighterID = (?)");
            ps.setInt(1, fighterID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int found = rs.getInt("FighterID");
                if (found == fighterID) {
                    return true;
                }
            }
            ps.close();
            rs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nCheck ID Function Not Working\n");
        }
        return false;
    }

    // Insert Fighter Information Into Database
    public static void insertFighterInfo(int fighterID, String firstName, String lastName, String nickName, int age) {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FighterRank?autoReconnect=true&useSSL=false", "root", "codingroot1!");
            PreparedStatement ps = con.prepareStatement("Insert Into `FighterInfo` values(?, ?, ?, ?, ?)");
            ps.setInt(1, fighterID);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, nickName);
            ps.setInt(5, age);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Insert Fighter Body Stats Information Into Database
    public static void insertFighterBody(int fighterID, String gender, String height, double weight,
            WeightClass weightClass) {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FighterRank?autoReconnect=true&useSSL=false", "root", "codingroot1!");
            PreparedStatement ps = con.prepareStatement("Insert Into `FighterBody` values(?, ?, ?, ?, ?)");
            ps.setInt(1, fighterID);
            ps.setString(2, gender);
            ps.setString(3, height);
            ps.setDouble(4, weight);
            ps.setString(5, weightClass.toString());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Insert Fighter Record Information Into Database
    public static void insertFighterRecord(int fighterID, int wins, int losses, int draws, int noContest) {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FighterRank?autoReconnect=true&useSSL=false", "root", "codingroot1!");
            PreparedStatement ps = con.prepareStatement("Insert Into `FighterRecord` values(?, ?, ?, ?, ?)");
            ps.setInt(1, fighterID);
            ps.setInt(2, wins);
            ps.setInt(3, losses);
            ps.setInt(4, draws);
            ps.setInt(5, noContest);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Insert Fighter Style Information Into Database
    public static void insertFighterStyle(int fighterID, StrikingStyles strikes, GrapplingStyles grapple) {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FighterRank?autoReconnect=true&useSSL=false", "root", "codingroot1!");
            PreparedStatement ps = con.prepareStatement("Insert Into `FighterStyle` values(?, ?, ?)");
            ps.setInt(1, fighterID);
            ps.setString(2, strikes.toString());
            ps.setString(3, grapple.toString());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get FighterID from the database according to the first name, last name,
    // gender and weightclass
    private static int getFighterIDBySearch(String firstName, String lastName, String gender, WeightClass weightClass) {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FighterRank?autoReconnect=true&useSSL=false", "root", "codingroot1!");
            PreparedStatement ps = con.prepareStatement("Select `FighterInfo`.FighterID From `FighterInfo` \n"
                    + "Join `FighterBody` ON `FighterInfo`.FighterID = `FighterBody`.FighterID  \n"
                    + "Where `FighterInfo`.FirstName = (?) AND `FighterInfo`.LastName = (?) AND `FighterBody`.Gender = (?) AND `FighterBody`.WeightClass = (?)");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, gender);
            ps.setString(4, weightClass.toString());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int fighterID = rs.getInt("FighterID");
                return fighterID;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Get fighter using fighterID from the database
    public static FighterModel getFighterBySearch(int fighterID) {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FighterRank?autoReconnect=true&useSSL=false", "root", "codingroot1!");
            PreparedStatement ps = con.prepareStatement(
                    "Select `FighterInfo`.FighterID, FirstName, LastName, NickName, Age, Gender, Height, Weight, WeightClass, Wins, Losses, Draws, NoContent, Striking, Grappling From `FighterInfo` \n"
                            + "Join `FighterBody` ON `FighterInfo`.FighterID = `FighterBody`.FighterID  \n"
                            + "Join `FighterRecord` ON `FighterInfo`.FighterID = `FighterRecord`.FighterID  \n"
                            + "Join `FighterStyle` ON `FighterInfo`.FighterID = `FighterStyle`.FighterID  \n"
                            + "Where `FighterInfo`.FighterID = (?)");
            ps.setInt(1, fighterID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int fID = rs.getInt("FighterID");
                if (fighterID == fID) {
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String nickName = rs.getString("NickName");
                    int age = rs.getInt("Age");
                    FighterInfo fighterInfo = new FighterInfo(fID, firstName, lastName, nickName, age);
                    String gender = rs.getString("Gender");
                    String height = rs.getString("Height");
                    double weight = rs.getDouble("Weight");
                    WeightClass weightClass = WeightClass.valueOf(rs.getString("WeightClass"));
                    MeasurementModel fighterMeasurement = new MeasurementModel(gender, weightClass, weight, height);
                    int wins = rs.getInt("Wins");
                    int losses = rs.getInt("Losses");
                    int draws = rs.getInt("Draws");
                    int noContest = rs.getInt("NoContent");
                    FighterRecord fighterRecord = new FighterRecord(wins, losses, draws, noContest);
                    StrikingStyles striking = StrikingStyles.valueOf(rs.getString("Striking"));
                    GrapplingStyles grappling = GrapplingStyles.valueOf(rs.getString("Grappling"));
                    StyleModel fighterStyle = new StyleModel(striking, grappling);
                    return new FighterModel(fighterInfo, fighterMeasurement, fighterRecord, fighterStyle);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // This method is used to get searched fighter from the Database
    public static FighterModel getSearchedFighter(String firstName, String lastName, String gender,
            WeightClass weightClass) {
        int fighterID = getFighterIDBySearch(firstName, lastName, gender, weightClass);
        if (fighterID >= 0) {
            FighterModel returnFighter = getFighterBySearch(fighterID);
            return returnFighter;
        } else {
            return null;
        }
    }

}
