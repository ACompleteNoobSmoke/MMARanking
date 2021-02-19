package fighting.Database;

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

public class SearchDatabase {

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
