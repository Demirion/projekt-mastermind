package MIB13;

import javax.swing.*;
import java.io.File;

/**
 * Created by niiru on 08.11.14.
 */
public class Main {
    public static void main(String[] args) {

        MasterGUI gui = new MasterGUI();
        try {
            if ((new File("gamesave")) != null) {
                int auswahl = JOptionPane.showConfirmDialog(null, "Savegame gefunden. Möchten Sie es Laden?", "Laden", JOptionPane.YES_NO_OPTION);
                if (auswahl == 0) {
                    gui.loadFromTxt();
                }
            }
        } catch (Exception e) {
        }

    }

}
