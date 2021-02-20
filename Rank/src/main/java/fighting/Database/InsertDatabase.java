package fighting.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fighting.Enums.GrapplingStyles;
import fighting.Enums.StrikingStyles;
import fighting.Enums.WeightClass;

public class InsertDatabase {

    // Check to see if Fighter ID exists in database
    public static boolean checkFighterID(int fighterID) {
        try {
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

}
