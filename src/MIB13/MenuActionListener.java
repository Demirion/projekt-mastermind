package MIB13;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by erikrohkohl on 25.10.14.
 */
public class MenuActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MasterGUI.menuItemOpen) {

        }
        if (e.getSource() == MasterGUI.menuItemClose) {
            System.exit(0);
        }
        if (e.getSource() == MasterGUI.menuItemTutorial) {

        }
        if (e.getSource() == MasterGUI.menuItemTipp) {

        }
        if (e.getSource() == MasterGUI.menuItemAbout) {
            JOptionPane.showMessageDialog(null, "MasterMind wurde erstellt von Neil Onasch, Erik Rohkohl, Eric Sowka und Alexander Lisnitzki.", "Über", JOptionPane.PLAIN_MESSAGE);
        }
        if (e.getSource() == MasterGUI.menuItemGameModi) {


        }
        if (e.getSource() == MasterGUI.menuItemNewGame) {
            if (MasterGUI.gameHelper.gameIsRunning()) {
                int auswahl = JOptionPane.showConfirmDialog(null,"Möchten Sie ein neues Spiel anfangen?","Warnung",JOptionPane.YES_NO_OPTION);
                if(auswahl == 0) {
                    MasterGUI.repaint();
                    MasterGUI.gameHelper.start();
                    MasterGUI.derzeitigeRunde=0;
                    MasterGUI.anzahlFarbWahlen=0;
                }
            } else {
                MasterGUI.gameHelper.start();
            }

        }
        if (e.getSource() == MasterGUI.menuItemMultiColorOn){
            MasterGUI.gameHelper.setMultiColors(true);
            MasterGUI.gameHelper.start();
        }
        if (e.getSource() == MasterGUI.menuItemMultiColorOff){
            MasterGUI.gameHelper.setMultiColors(false);
            MasterGUI.gameHelper.start();
        }

    }
}
