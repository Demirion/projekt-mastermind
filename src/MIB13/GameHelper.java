package MIB13;

import javax.swing.*;

import MIB13.Counter;

import java.util.Random;

/**
 * Created by niiru on 17.10.14.
 * <p/>
 * In dieser Klasse werden die Spiellogiken verwaltet.
 */
public class GameHelper {

    public final static int LINESIZE = 4;
    public final static int MAXROUNDS = 10;
    private boolean multiColors = false; //Option zum einstellen der Mehrfachfarbauswahl
    private boolean gameIsRunning = false;
    private int round = 0; //Wird auch in der MasterGUI gehandhabt..
    private MasterLine masterLine;
    //private int sticks[] = new int[2]; //[0] = black; [1] = white;

    public boolean gameIsRunning() {
        return gameIsRunning;
    }

    public boolean isMultiColors() {
        return multiColors;
    }

    public void setMultiColors(boolean multiColors) {
        /**
         * Diese wird von dem Actionlistener der CheckBox aufgerufen!!
         */
        this.multiColors = multiColors;
        System.out.println("Multicolors: " + multiColors);
    }

    public MasterLine getMasterLine() {
        return masterLine;
    }

    public int getRound() {
        return round;
    }

    /**
     * Initialisierung.
     * TODO Alle Werte auf 0 bzw false setzen.
     */
    public void init() {
        round = 0;
        masterLine = null;

    }

    public void setMasterLine(MasterLine masterLine) {
        this.masterLine = masterLine;
    }

    /**
     * Spielstart.
     * Es soll überprüft werden, ob die Multicolors option gesetzt wurde und danach
     * eine MasterLine mit dem Argument multiColors erstellt werden.
     */
    public void start() {
    	Counter.count = 0;
    	Counter.timer.start();
        System.out.println("Spiel Start"); //TODO debug entfernen
        init();
        masterLine = new MasterLine(isMultiColors());
        gameIsRunning = true;


    }

    /**
     * Methode zum vergleichen der derzeitigen Zeile mit der MasterLine.
     * Bei gleichheit (blackSticks == 4) wird die Methode gameWon aufgerufen.
     * <p/>
     * Gibt int Array mit anzahl der Schwarzen und Weißen Sticks zurück.
     *
     * @param line       To be checked Line.
     * @param masterLine The Line with the code needed to win.
     * @return Returns an IntArray with the amount of Black and White sticks. [0] == Black, [1] == White.
     */
    public int[] checkLine(MasterLine masterLine, Line line) { //Fertig(?)
        int sticks[] = new int[2];
        int mLine[] = new int[GameHelper.LINESIZE];
        int cLine[] = new int[GameHelper.LINESIZE];

        if (gameIsRunning) {
            sticks[0] = sticks[1] = 0;

            for (int i = 0; i < GameHelper.LINESIZE; i++) {
                mLine[i] = masterLine.getBall(i).getColor();
                cLine[i] = line.getBall(i).getColor();
                System.out.println("mLine : cLine = " + mLine[i] + " : " + cLine[i]); //debug
            }


            for (int i = 0; i < masterLine.getBalls().size(); i++) {
                if (masterLine.getBall(i).getColor() == line.getBall(i).getColor()) {
                    sticks[0]++;
                }

                for (int j = 0; j < masterLine.getBalls().size(); j++) {

                    if (mLine[i] == cLine[j] && mLine[i] != -1 && cLine[j] != -1) {
                        sticks[1]++;
                        mLine[i] = cLine[j] = -1;
                    }
                }
            }
            if (sticks[0] == 4) gameWon();
            round++;
            if (round == MAXROUNDS) {
                System.out.println("Maximale Runden erreicht. Spielende.");
                gameIsRunning = false;
            }
        }
        return sticks;
    }

    /**
     * Wenn das Spiel gewonnen ist, werden "Highscore" berechnet und das Spiel auf nicht laufend gesetzt.
     */
    public void gameWon() {
    	Counter.timer.stop();
        System.out.println("Gewonnen!"); //Debug
        gameIsRunning = false;
        int time = 0; //TODO durch richtige Zeit ersetzen
        int score = 0; //TODO score berechnen
        JOptionPane.showConfirmDialog(null, "Herzlichen Glückwunsch! Sie sind das Mastermind.\n\n\nBenötigte Zeit: " + time + " Sekunden.\nBenötigte Runden: " + (MasterGUI.derzeitigeRunde + 1) + "\nScore: " + score + " Punkte.", "Gewonnen!", JOptionPane.DEFAULT_OPTION);
    }

    /**
     * Wenn der Spieler Hilfe benötigt, soll ihm mit dieser Funktion ein Tipp gegeben werden.
     *
     * @param currentLine The Line of the current Round.
     * @param masterLine  The Line with the code needed to win.
     * @return String mit einem Lösungsansatz.
     */
    public String getHelp(MasterLine masterLine, Line currentLine) {

        String retString = "";
        int blackWhites[]; //sticks, nur halt für diese Funktion
        blackWhites = checkLine(masterLine, currentLine);
        blackWhites[1] = blackWhites[1] - blackWhites[0];

        if (blackWhites[1] == 0) {
            //0 Weiße
            return "Keine der Farben passt. Schließe diese kategorisch aus!";
        }
        if (blackWhites[1] == 1) {
            //1 Weißer
            retString = "Probier es noch mal ;)";
        }
        if (blackWhites[1] > 1) {
            //2+ Weiße
            //Vector<Ball> tempLine = (Vector<Ball>) masterLine.getBalls().clone();
            int tempLines[] = new int[masterLine.getBalls().size()];
            int position = -1;
            Random random = new Random();
            int randomInt;

            for (int i = 0; i < tempLines.length; i++) {
                tempLines[i] = masterLine.getBall(i).getColor();
            }

            for (int i = 0; i < masterLine.getBalls().size(); i++) {
                if (tempLines[i] == currentLine.getBall(i).getColor()) {
                    tempLines[i] = -1;
                }
            } //Alle Schwarzen raus nehmen.

            do {
                do {
                    randomInt = random.nextInt(tempLines.length);
                } while (tempLines[randomInt] == -1);

                for (int i = 0; i < currentLine.getBalls().size(); i++) {
                    if (tempLines[randomInt] == currentLine.getBall(i).getColor()) {
                        position = randomInt;
                    }
                }
            } while (position == -1);

            retString = "Die Farbe " + masterLine.getBall(randomInt).getColorString() + " gehört an die Position: " + (position + 1) + ".";
        }

        return retString;
    }
}
