package MIB13;

import javax.swing.*;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

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
        if (e.getSource() == MasterGUI.menuItemNyanMode) {
            if (MasterGUI.nyanMode) {
                MasterGUI.backGroundLabel.setIcon(new ImageIcon("./res/img/background" + MasterGUI.activeBG + ".png"));
                MasterGUI.player.stop();
                MasterGUI.musicplaying = false;
                MasterGUI.musicButton.setIcon(new ImageIcon("./res/img/audio_off.png"));

                try {
                    MasterGUI.player = Applet.newAudioClip(MasterGUI.bmgAudioFile.toURL());
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                    System.out.println("Audiodatei nicht gefunden.");
                }
                MasterGUI.nyanMode = false;
            } else {
                MasterGUI.backGroundLabel.setIcon(new ImageIcon("./res/img/nyan.gif"));
                MasterGUI.player.stop();
                try {
                    MasterGUI.player = Applet.newAudioClip(MasterGUI.nyanAudioFile.toURL());
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                    System.out.println("Audiodatei nicht gefunden.");
                }
                MasterGUI.player.loop();
                MasterGUI.musicplaying = true;
                MasterGUI.musicButton.setIcon(new ImageIcon("./res/img/audio_on.png"));
                MasterGUI.nyanMode = true;
            }


        }

    }
}
