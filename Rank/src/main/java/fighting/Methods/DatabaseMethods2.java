package fighting.Methods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import fighting.Enums.WeightClass;
import fighting.Model.FighterModel;

public class DatabaseMethods2 {

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

    // Converts Arraylist of Fighters by their gender to an array
    public static FighterModel[] genderFighterArray(String gender) {
        ArrayList<FighterModel> convertThis = getFightersByGender(gender);
        if (convertThis == null) {
            return null;
        } else {
            int size = convertThis.size();
            FighterModel[] fighters = new FighterModel[size];
            for (int i = 0; i < size; i++) {
                fighters[i] = convertThis.get(i);
            }
            return fighters;
        }
    }

    // Get Fighter By Gender
    private static ArrayList<FighterModel> getFightersByGender(String gender) {
        ArrayList<FighterModel> genderFighters = new ArrayList<FighterModel>();
        FighterModel fighter = null;
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FighterRank?autoReconnect=true&useSSL=false", "root", "codingroot1!");
            PreparedStatement ps = con.prepareStatement(
                    "Select `FighterInfo`.FighterID, FirstName, LastName, NickName, Age, Gender, Height, Weight, WeightClass, Wins, Losses, Draws, NoContent, Striking, Grappling From `FighterInfo` \n"
                            + "Join `FighterBody` ON `FighterInfo`.FighterID = `FighterBody`.FighterID  \n"
                            + "Join `FighterRecord` ON `FighterInfo`.FighterID = `FighterRecord`.FighterID  \n"
                            + "Join `FighterStyle` ON `FighterInfo`.FighterID = `FighterStyle`.FighterID  \n"
                            + "Where `FighterBody`.Gender = (?)");
            ps.setString(1, gender);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int fighterID = rs.getInt("FighterID");
                fighter = DatabaseMethods.getFighterBySearch(fighterID);
                genderFighters.add(fighter);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return genderFighters;
    }

    // Converts Arraylist of Fighters by their gender and weight class to an array
    public static FighterModel[] genderFighterArray(String gender, WeightClass weightClass) {
        String weightC = weightClass.toString();
        ArrayList<FighterModel> convertThis = getFightersByGenderAndWeight(gender, weightC);
        if (convertThis == null) {
            return null;
        } else {
            int size = convertThis.size();
            FighterModel[] fighters = new FighterModel[size];
            for (int i = 0; i < size; i++) {
                fighters[i] = convertThis.get(i);
            }
            return fighters;
        }
    }

    // Get Fighter By Gender And Weight
    private static ArrayList<FighterModel> getFightersByGenderAndWeight(String gender, String weightClass) {
        ArrayList<FighterModel> genderWeightFighters = new ArrayList<FighterModel>();
        FighterModel fighter = null;
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FighterRank?autoReconnect=true&useSSL=false", "root", "codingroot1!");
            PreparedStatement ps = con.prepareStatement(
                    "Select `FighterInfo`.FighterID, FirstName, LastName, NickName, Age, Gender, Height, Weight, WeightClass, Wins, Losses, Draws, NoContent, Striking, Grappling From `FighterInfo` \n"
                            + "Join `FighterBody` ON `FighterInfo`.FighterID = `FighterBody`.FighterID  \n"
                            + "Join `FighterRecord` ON `FighterInfo`.FighterID = `FighterRecord`.FighterID  \n"
                            + "Join `FighterStyle` ON `FighterInfo`.FighterID = `FighterStyle`.FighterID  \n"
                            + "Where `FighterBody`.Gender = (?) AND `FighterBody`.WeightClass = (?)");
            ps.setString(1, gender);
            ps.setString(2, weightClass);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int fighterID = rs.getInt("FighterID");
                fighter = DatabaseMethods.getFighterBySearch(fighterID);
                genderWeightFighters.add(fighter);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return genderWeightFighters;
    }

}