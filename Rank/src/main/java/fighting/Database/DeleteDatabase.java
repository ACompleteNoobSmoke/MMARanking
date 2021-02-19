package fighting.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteDatabase {

    // Method that contains all delete methods
    public static void deleteFighter(int fighterID) {
        boolean deleted = false;
        while (!deleted) {
            deleted = deleteFighterStyle(fighterID);
            deleted = deleteFighterRecord(fighterID);
            deleted = deleteFighterBody(fighterID);
            deleted = deleteFighterInfo(fighterID);
        }
    }

    // Delete Fighter Information From Database
    private static boolean deleteFighterInfo(int fighterID) {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FighterRank?autoReconnect=true&useSSL=false", "root", "codingroot1!");
            PreparedStatement ps = con.prepareStatement("Delete From `FighterInfo` where FighterID = (?)");
            ps.setInt(1, fighterID);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Delete Fighter Body Stats From Database
    private static boolean deleteFighterBody(int fighterID) {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FighterRank?autoReconnect=true&useSSL=false", "root", "codingroot1!");
            PreparedStatement ps = con.prepareStatement("Delete From `FighterBody` where FighterID = (?)");
            ps.setInt(1, fighterID);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Delete Fighter Record From Database
    private static boolean deleteFighterRecord(int fighterID) {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FighterRank?autoReconnect=true&useSSL=false", "root", "codingroot1!");
            PreparedStatement ps = con.prepareStatement("Delete From `FighterRecord` where FighterID = (?)");
            ps.setInt(1, fighterID);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Delete Fighter Fighting Style From Database
    private static boolean deleteFighterStyle(int fighterID) {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FighterRank?autoReconnect=true&useSSL=false", "root", "codingroot1!");
            PreparedStatement ps = con.prepareStatement("Delete From `FighterStyle` where FighterID = (?)");
            ps.setInt(1, fighterID);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
