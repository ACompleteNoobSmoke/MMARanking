package fighting.Menu;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fighting.Model.FighterModel;

public class TableDisplay {
    JFrame f;
    JTable j;

    // Convert FighterModel Object to just default Object for table
    private String[] convertToString(FighterModel fighter) {
        String[] tableContent = new String[10];
        tableContent[0] = fighter.getFighterInfo().getFirstName();
        tableContent[1] = fighter.getFighterInfo().getLastName();
        tableContent[2] = fighter.getFighterInfo().getNickName();
        tableContent[3] = Integer.toString(fighter.getFighterInfo().getAge());
        tableContent[4] = fighter.getFighterMeasurement().getGender();
        tableContent[5] = fighter.getFighterMeasurement().getWeightClass().toString();
        tableContent[6] = Integer.toString(fighter.getFighterRecord().getWins());
        tableContent[7] = Integer.toString(fighter.getFighterRecord().getLosses());
        tableContent[8] = Integer.toString(fighter.getFighterRecord().getDraws());
        tableContent[9] = Integer.toString(fighter.getFighterRecord().getNoContest());
        return tableContent;
    }

    private String[] convertToStringForSpecific(FighterModel fighter) {
        String[] tableContent = new String[8];
        tableContent[0] = fighter.getFighterInfo().getFirstName();
        tableContent[1] = fighter.getFighterInfo().getLastName();
        tableContent[2] = fighter.getFighterInfo().getNickName();
        tableContent[3] = Integer.toString(fighter.getFighterInfo().getAge());
        tableContent[4] = Integer.toString(fighter.getFighterRecord().getWins());
        tableContent[5] = Integer.toString(fighter.getFighterRecord().getLosses());
        tableContent[6] = Integer.toString(fighter.getFighterRecord().getDraws());
        tableContent[7] = Integer.toString(fighter.getFighterRecord().getNoContest());
        return tableContent;
    }

    // Convert an array of FighterModel to an Object array
    public Object[] convertListToObject(boolean table, FighterModel[] fighters) {
        int fighterSize = fighters.length;
        Object[] tableContents = new Object[fighterSize];

        for (int i = 0; i < fighterSize; i++) {
            tableContents[i] = (table) ? convertToString(fighters[i]) : convertToStringForSpecific(fighters[i]);
        }
        // String[] tContent = (String[]) tableContents;
        return tableContents;
    }

    public void genderSpecificTable(String gender, FighterModel[] fighters) {
        String title = "All (" + gender + ")  Fighters";
        Object[] tableContent = convertListToObject(false, fighters);
        String specificHeaders[] = { "First Name", "Last Name", "Nickname", "Age", "Win(s)", "Loss(es)", "Draw(s)",
                "No Contest(s)" };
        tableView(title, specificHeaders, tableContent);
    }

    public void viewAllTable(FighterModel[] fighters) {
        String title = "All Fighters";
        Object[] tableContent = convertListToObject(true, fighters);
        String columnHeaders[] = { "First Name", "Last Name", "Nickname", "Age", "Gender", "Weight Class", "Win(s)",
                "Loss(es)", "Draw(s)", "No Contest(s)" };
        tableView(title, columnHeaders, tableContent);
    }

    public void tableView(String title, String[] tableHead, Object[] tableContents) {
        // Frame initiallization
        Object[] content = tableContents;
        f = new JFrame();
        // Frame Title
        f.setTitle(title);
        // Initializing the JTable
        j = new JTable();
        DefaultTableModel model = (DefaultTableModel) j.getModel();
        model.setColumnIdentifiers(tableHead);
        j.setModel(model);
        int size = tableContents.length;
        for (int i = 0; i < size; i++) {
            model.addRow((String[]) content[i]);
        }

        j.setBounds(30, 40, 200, 300);
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        // Frame Size
        f.setSize(500, 200);
        // Frame Visible = true
        f.setVisible(true);
    }
}
