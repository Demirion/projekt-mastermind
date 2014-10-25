package MIB13;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonActionListener  implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MasterGUI.ballButton[0]) {
            if (MasterGUI.anzahlFarbWahlen < 4) {
                MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconRed);
                MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(1);
                MasterGUI.anzahlFarbWahlen++;
            }else{
                JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben","Warnung", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if (e.getSource() == MasterGUI.ballButton[1]) {
            if (MasterGUI.anzahlFarbWahlen < 4) {
                MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconMagenta);
                MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(2);
                MasterGUI.anzahlFarbWahlen++;
            }else{
                JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben","Warnung", JOptionPane.PLAIN_MESSAGE);
            }
        }
        if (e.getSource() == MasterGUI.ballButton[2]) {
            if (MasterGUI.anzahlFarbWahlen < 4) {
                MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconYellow);
                MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(2);
                MasterGUI.anzahlFarbWahlen++;
            }else{
                JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben","Warnung", JOptionPane.PLAIN_MESSAGE);
            }
        }


        if (e.getSource() == MasterGUI.ballButton[3]) {
            if (MasterGUI.anzahlFarbWahlen < 4) {
                MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconGreen);
                MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(3);
                MasterGUI.anzahlFarbWahlen++;
            }else{
                JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben","Warnung", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if (e.getSource() == MasterGUI.ballButton[4]) {
            if (MasterGUI.anzahlFarbWahlen < 4) {
                MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconBlue);
                MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(4);
                MasterGUI.anzahlFarbWahlen++;
            }else{
                JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben","Warnung", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if (e.getSource() == MasterGUI.ballButton[5]) {
            if (MasterGUI.anzahlFarbWahlen < 4) {
                MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconCyan);
                MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(5);
                MasterGUI.anzahlFarbWahlen++;
            }else{
                JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben","Warnung", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if (e.getSource() == MasterGUI.ballButton[6]) {
            if (MasterGUI.anzahlFarbWahlen < 4) {
                MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconWhite);
                MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(6);
                MasterGUI.anzahlFarbWahlen++;
            }else{
                JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben","Warnung", JOptionPane.PLAIN_MESSAGE);
            }
        }
        if (e.getSource() == MasterGUI.ballButton[7]) {
            if (MasterGUI.anzahlFarbWahlen < 4) {
                MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconBlack);
                MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(7);
                MasterGUI.anzahlFarbWahlen++;
            }else{
                JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben","Warnung", JOptionPane.PLAIN_MESSAGE);
            }
        }
        if (e.getSource() == MasterGUI.readTippButton){
            if (MasterGUI.anzahlFarbWahlen > 3) {
                MasterGUI.lineArray[MasterGUI.derzeitigeRunde] = new Line(MasterGUI.ballArray[0], MasterGUI.ballArray[1], MasterGUI.ballArray[2], MasterGUI.ballArray[3]);
                MasterGUI.anzahlFarbWahlen = 0;

                int[] anzSticks = new int[2];
                anzSticks = MasterGUI.gameHelper.checkLine(MasterGUI.gameHelper.getMasterLine(), MasterGUI.lineArray[MasterGUI.derzeitigeRunde]);
                System.out.println(anzSticks[0] + " " + anzSticks[1]);
                int k = 0;
                for (int i = anzSticks[0]; i > 0; i--) {
                    MasterGUI.labelResultDisplay[9 - MasterGUI.derzeitigeRunde][k].setIcon(MasterGUI.pinBlack);
                    k++;
                }
                for (int i = anzSticks[1]; i > 0; i--) {
                    MasterGUI.labelResultDisplay[9 - MasterGUI.derzeitigeRunde][k].setIcon(MasterGUI.pinWhite);
                    k++;
                }
                MasterGUI.derzeitigeRunde++;

            }else {
                JOptionPane.showMessageDialog(null,"Bitte erst vier Kugeln auswählen.","Warnung", JOptionPane.PLAIN_MESSAGE);
            }
        }
        if (e.getSource() == MasterGUI.newGameButton){
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

    }
}
