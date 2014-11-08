package MIB13;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonActionListener  implements ActionListener{

    public static int[][] gameField = new int[10][4];

    public void actionPerformed(ActionEvent e) {
        if (MasterGUI.gameHelper.gameIsRunning()) {
            if (e.getSource() == MasterGUI.ballButton[0] && MasterGUI.ballButton[0].getIcon()!=MasterGUI.icon) {
                if (MasterGUI.anzahlFarbWahlen < GameHelper.LINESIZE) {
                    if (!(MasterGUI.gameHelper.isMultiColors())){
                        MasterGUI.ballButton[0].setIcon(MasterGUI.icon);
                    }
                    MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconRed);
                    MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconRed);
                    MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(Ball.RED);
                    fillgameField();
                    MasterGUI.anzahlFarbWahlen++;
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte erst Tipp abgeben", "Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            }

            if (e.getSource() == MasterGUI.ballButton[1]&& MasterGUI.ballButton[1].getIcon()!=MasterGUI.icon) {
                if (MasterGUI.anzahlFarbWahlen < GameHelper.LINESIZE) {
                    if (!(MasterGUI.gameHelper.isMultiColors())){
                        MasterGUI.ballButton[1].setIcon(MasterGUI.icon);
                    }
                    MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconMagenta);
                    MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(Ball.MAGENTA);
                    fillgameField();
                    MasterGUI.anzahlFarbWahlen++;
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte erst Tipp abgeben", "Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            }
            if (e.getSource() == MasterGUI.ballButton[2]&& MasterGUI.ballButton[2].getIcon()!=MasterGUI.icon) {
                if (MasterGUI.anzahlFarbWahlen < GameHelper.LINESIZE) {
                    if (!(MasterGUI.gameHelper.isMultiColors())){
                        MasterGUI.ballButton[2].setIcon(MasterGUI.icon);
                    }
                    MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconYellow);
                    MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(Ball.YELLOW);
                    fillgameField();
                    MasterGUI.anzahlFarbWahlen++;
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte erst Tipp abgeben", "Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            }


            if (e.getSource() == MasterGUI.ballButton[3]&& MasterGUI.ballButton[3].getIcon()!=MasterGUI.icon) {
                if (MasterGUI.anzahlFarbWahlen < GameHelper.LINESIZE) {
                    if (!(MasterGUI.gameHelper.isMultiColors())){
                        MasterGUI.ballButton[3].setIcon(MasterGUI.icon);
                    }
                    MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconGreen);
                    MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(Ball.GREEN);
                    fillgameField();
                    MasterGUI.anzahlFarbWahlen++;
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte erst Tipp abgeben", "Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            }

            if (e.getSource() == MasterGUI.ballButton[4]&& MasterGUI.ballButton[4].getIcon()!=MasterGUI.icon) {
                if (MasterGUI.anzahlFarbWahlen < GameHelper.LINESIZE) {
                    if (!(MasterGUI.gameHelper.isMultiColors())){
                        MasterGUI.ballButton[4].setIcon(MasterGUI.icon);
                    }
                    MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconBlue);
                    MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(Ball.BLUE);
                    fillgameField();
                    MasterGUI.anzahlFarbWahlen++;
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte erst Tipp abgeben", "Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            }

            if (e.getSource() == MasterGUI.ballButton[5]&& MasterGUI.ballButton[5].getIcon()!=MasterGUI.icon) {
                if (MasterGUI.anzahlFarbWahlen < GameHelper.LINESIZE) {
                    if (!(MasterGUI.gameHelper.isMultiColors())){
                        MasterGUI.ballButton[5].setIcon(MasterGUI.icon);
                    }
                    MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconCyan);
                    MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(Ball.CYAN);
                    fillgameField();
                    MasterGUI.anzahlFarbWahlen++;
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte erst Tipp abgeben", "Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            }

            if (e.getSource() == MasterGUI.ballButton[6]&& MasterGUI.ballButton[6].getIcon()!=MasterGUI.icon) {
                if (MasterGUI.anzahlFarbWahlen < GameHelper.LINESIZE) {
                    if (!(MasterGUI.gameHelper.isMultiColors())){
                        MasterGUI.ballButton[6].setIcon(MasterGUI.icon);
                    }
                    MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconWhite);
                    MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(Ball.WHITE);
                    fillgameField();
                    MasterGUI.anzahlFarbWahlen++;
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte erst Tipp abgeben", "Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            }
            if (e.getSource() == MasterGUI.ballButton[7] && MasterGUI.ballButton[7].getIcon()!=MasterGUI.icon) {
                if (MasterGUI.anzahlFarbWahlen < GameHelper.LINESIZE) {
                    if (!(MasterGUI.gameHelper.isMultiColors())){
                        MasterGUI.ballButton[7].setIcon(MasterGUI.icon);
                    }
                    MasterGUI.ballLabel[9 - MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.iconBlack);
                    MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen] = new Ball(Ball.BLACK);
                    fillgameField();
                    MasterGUI.anzahlFarbWahlen++;
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte erst Tipp abgeben", "Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            }
            if (e.getSource() == MasterGUI.readTippButton) {
                if (MasterGUI.anzahlFarbWahlen >= GameHelper.LINESIZE) {
                    MasterGUI.lineArray[MasterGUI.derzeitigeRunde] = new Line(MasterGUI.ballArray[0], MasterGUI.ballArray[1], MasterGUI.ballArray[2], MasterGUI.ballArray[3]);
                    MasterGUI.anzahlFarbWahlen = 0;

                    MasterGUI.ballButton[0].setIcon(MasterGUI.iconRed);
                    MasterGUI.ballButton[1].setIcon(MasterGUI.iconMagenta);
                    MasterGUI.ballButton[2].setIcon(MasterGUI.iconYellow);
                    MasterGUI.ballButton[3].setIcon(MasterGUI.iconGreen);
                    MasterGUI.ballButton[4].setIcon(MasterGUI.iconBlue);
                    MasterGUI.ballButton[5].setIcon(MasterGUI.iconCyan);
                    MasterGUI. ballButton[6].setIcon(MasterGUI.iconWhite);
                    MasterGUI. ballButton[7].setIcon(MasterGUI.iconBlack);

                    MasterGUI.del[9-MasterGUI.derzeitigeRunde].setIcon(new ImageIcon("./res/img/backButtontrans.png"));
                    if(MasterGUI.derzeitigeRunde < 9){
                        MasterGUI.del[9-MasterGUI.derzeitigeRunde - 1].setIcon(new ImageIcon("./res/img/backButton.png"));
                    }

                    int[] anzSticks;
                    anzSticks = MasterGUI.gameHelper.checkLine(MasterGUI.gameHelper.getMasterLine(), MasterGUI.lineArray[MasterGUI.derzeitigeRunde]);
                    System.out.println(anzSticks[0] + " " + anzSticks[1]); //TODO debug entfernen vor release
                    int k = 0;
                    for (int i = anzSticks[1]; i > 0; i--) {
                        MasterGUI.labelResultDisplay[9 - MasterGUI.derzeitigeRunde][k].setIcon(MasterGUI.pinWhite);
                        k++;
                    }
                    k = 0;
                    for (int i = anzSticks[0]; i > 0; i--) {
                        MasterGUI.labelResultDisplay[9 - MasterGUI.derzeitigeRunde][k].setIcon(MasterGUI.pinBlack);
                        k++;
                    }
                    if (anzSticks[0] == 4) MasterGUI.gameHelper.gameWon();

                    MasterGUI.derzeitigeRunde++;

                    if (MasterGUI.derzeitigeRunde == GameHelper.MAXROUNDS && MasterGUI.gameHelper.gameIsRunning())
                        MasterGUI.gameHelper.gameLost();

                } else {
                    JOptionPane.showMessageDialog(null, "Bitte erst vier Kugeln auswählen.", "Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            } //readTippButton
        } //gameIsRunning
        if (e.getSource() == MasterGUI.newGameButton){
            int auswahl = 0;
            if (MasterGUI.gameHelper.gameIsRunning()) {
                auswahl = JOptionPane.showConfirmDialog(null, "Möchten Sie ein neues Spiel anfangen?", "Warnung", JOptionPane.YES_NO_OPTION);
            }
            if (auswahl == 0) {
                auswahl = JOptionPane.showConfirmDialog(null, "Neues Spiel im Multicolor mode?\n(Zielkombination kann die gleiche Farbe mehrfach aufweisen.)", "Warnung", JOptionPane.YES_NO_OPTION);
                if (auswahl == 0) {
                    MasterGUI.gameHelper.setMultiColors(true);
                    //MasterGUI.buttonGroup.isSelected(MasterGUI.menuItemMultiColorOn);
                    MasterGUI.menuItemMultiColorOn.setSelected(true);
                } else {
                    MasterGUI.gameHelper.setMultiColors(false);
                    MasterGUI.menuItemMultiColorOff.setSelected(true);
                }
                MasterGUI.repaint();
                MasterGUI.derzeitigeRunde = 0;
                MasterGUI.anzahlFarbWahlen = 0;
                MasterGUI.gameHelper.start();
                for (int i = 0; i < 9; i++) {
                    MasterGUI.del[i].setIcon(new ImageIcon("./res/img/backButtontrans.png"));
                }
                MasterGUI.del[9 - MasterGUI.derzeitigeRunde].setIcon(new ImageIcon("./res/img/backButton.png"));
            }

        } //newGameButton

        if ((e.getSource() == MasterGUI.del[9] || e.getSource() == MasterGUI.del[8]||e.getSource() == MasterGUI.del[7]||e.getSource() == MasterGUI.del[6]||
        e.getSource() == MasterGUI.del[5]||e.getSource() == MasterGUI.del[4]||e.getSource() == MasterGUI.del[3]||e.getSource() == MasterGUI.del[2]||
                e.getSource() == MasterGUI.del[1]||e.getSource() == MasterGUI.del[0])&& MasterGUI.anzahlFarbWahlen>0){
            MasterGUI.anzahlFarbWahlen--;
            int i =MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen].getColor();
            MasterGUI.ballButton[i].setIcon(new ImageIcon("./res/img/" + MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen].getColorString() + ".png"));
            MasterGUI.ballLabel[9-MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen].setIcon(MasterGUI.icon);
            MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen]=null;
        }


        if (e.getSource() == MasterGUI.musicButton){
            /*AudioPlayer ap = AudioPlayer.player;
            AudioStream stream;
        	AudioData data;
        	ContinuousAudioDataStream loop = null;
        	if(MasterGUI.musicplaying == false) {
        		MasterGUI.musicplaying = true;
        		try{
        			stream = new AudioStream(new FileInputStream("./res/snd/bgm.wav"));
        			data = stream.getData();
        			loop = new ContinuousAudioDataStream(data);
        		} catch(IOException error) {}
        			ap.start(loop);
        	} else {
        		//hier soll der scheiß wieder geschlossen werden.. also stumm, stream aus und so
        		ap.stop();
                MasterGUI.musicplaying = false;
        	}*/

            if (!MasterGUI.musicplaying) {
                MasterGUI.player.loop();
                MasterGUI.musicplaying = true;
                MasterGUI.musicButton.setIcon(new ImageIcon("./res/img/audio_on.png"));
            } else {
                MasterGUI.player.stop();
                MasterGUI.musicplaying = false;
                MasterGUI.musicButton.setIcon(new ImageIcon("./res/img/audio_off.png"));
            }
        }
        
        if (e.getSource() == MasterGUI.screenButton) {
            if (!MasterGUI.nyanMode) {
                if ((MasterGUI.activeBG + 1) <= 14) {
                    MasterGUI.activeBG++;
                } else {
                    MasterGUI.activeBG = 0;
                }
                MasterGUI.backGroundLabel.setIcon(new ImageIcon("./res/img/background" + MasterGUI.activeBG + ".png"));
            }
        }
    }

    public void fillgameField() {
        gameField[MasterGUI.derzeitigeRunde][MasterGUI.anzahlFarbWahlen] = MasterGUI.ballArray[MasterGUI.anzahlFarbWahlen].getColor();
    }
}
