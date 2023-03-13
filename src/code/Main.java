package code;

import code.preslayer.Controller;
import code.preslayer.MainGUI;

public class Main {

    public static void main(String[] args) {

        MainGUI mg = new MainGUI();

        mg.setVisible(true);
        Controller c = new Controller(mg);

    }

}
