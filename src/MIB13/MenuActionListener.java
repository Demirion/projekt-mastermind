package MIB13;

import javax.swing.*;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by erikrohkohl on 25.10.14.
 */
public class MenuActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MasterGUI.menuItemClose) {
            if (MasterGUI.gameHelper.gameIsRunning()) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("gamesave"));
                    writer.write((String.valueOf(MasterGUI.derzeitigeRunde)));
                    writer.newLine();
                    writer.write(String.valueOf(Counter.count));
                    writer.newLine();
                    writer.write(Boolean.toString(MasterGUI.gameHelper.isMultiColors()));
                    writer.newLine();
                    for(int i = 0; i < 4; i++){
                        writer.write(String.valueOf(GameHelper.mLine[i]));
                    }
                    writer.newLine();
                    for(int i = 0; i <= 9; i++){
                        for(int j = 0; j <= 3; j++){
                            writer.write(String.valueOf(ButtonActionListener.gameField[i][j]));
                        }
                        writer.newLine();
                    }
                    writer.close();
                } catch (IOException f) {
                    f.printStackTrace();
                }
                System.out.println("Das Spiel wurde erfolgreich gespeichert.");
            }
            System.exit(0);
        }

        if (e.getSource() == MasterGUI.menuItemTipp) {
            if (MasterGUI.gameHelper.gameIsRunning()) {
                if (MasterGUI.derzeitigeRunde != 0) {
                    if (JOptionPane.showConfirmDialog(null, "Möchtest du wirklich einen Tipp?", "Hilfe", JOptionPane.YES_NO_OPTION) == 0) {
                        String help;
                        help = MasterGUI.gameHelper.getHelp(MasterGUI.gameHelper.getMasterLine(), MasterGUI.lineArray[MasterGUI.derzeitigeRunde - 1]);
                        JOptionPane.showConfirmDialog(null, help, "Hilfe", JOptionPane.DEFAULT_OPTION);
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Du möchtest doch nicht schon in der ersten Runde einen Tipp.", "Hilfe", JOptionPane.CLOSED_OPTION);
                }
            }
        }
        if (e.getSource() == MasterGUI.menuItemAbout) {
            JOptionPane.showMessageDialog(null, "MasterMind wurde erstellt von Neil Onasch, Erik Rohkohl, Eric Sowka und Alexander Lisnitzki.", "Über", JOptionPane.PLAIN_MESSAGE);
        }
        if (e.getSource() == MasterGUI.menuItemGameModi) {


        }
        if (e.getSource() == MasterGUI.menuItemNewGame) {
            /*if (MasterGUI.gameHelper.gameIsRunning()) {
                int auswahl = JOptionPane.showConfirmDialog(null, "Möchten Sie ein neues Spiel anfangen?", "Warnung", JOptionPane.YES_NO_OPTION);
                if (auswahl == 0) {
                    MasterGUI.repaint();
                    MasterGUI.gameHelper.start();
                    MasterGUI.derzeitigeRunde = 0;
                    MasterGUI.anzahlFarbWahlen = 0;
                }
            } else {
                MasterGUI.gameHelper.start();
            }*/
            MasterGUI.newGameButton.doClick();

        }
        if (e.getSource() == MasterGUI.menuItemMultiColorOn) {
            //if (!MasterGUI.gameHelper.gameIsRunning())MasterGUI.gameHelper.setMultiColors(true);
        }
        if (e.getSource() == MasterGUI.menuItemMultiColorOff) {
            //MasterGUI.gameHelper.setMultiColors(false);
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
