import gui.GUI;

import static operationsDB.DatabaseMethods.createTable;

public class Main {
    public static void main(String[] args) {
            createTable();
            GUI gui=new GUI();
            gui.setVisible(true);
            gui.setLocationRelativeTo(null);
    }
}