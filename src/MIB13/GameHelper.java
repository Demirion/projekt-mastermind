package MIB13;

/**
 * Created by niiru on 17.10.14.
 * <p/>
 * In dieser Klasse werden die Spiellogiken verwaltet.
 */
public class GameHelper {
    private boolean multiColors = false; //Option zum einstellen der Mehrfachfarbauswahl
    private boolean gameIsRunning = false;
    private int round = 0;

    public boolean gameIsRunning() {
        return gameIsRunning;
    }

    public boolean isMultiColors() {
        return multiColors;
    }

    public int getRound() {
        return round;
    }

    public void init() {
        /**
         * Initialisierung.
         * TODO Alle Werte auf 0 bzw false setzen.
         */

    }

    public void start() {
        /**
         * Spielstart.
         * TODO Es soll überprüft werden, ob die Multicolors option gesetzt wurde und danach
         * eine MasterLine mit dem Argument multiColors erstellt werden.
         */
        init();
        gameIsRunning = true;

    }

    public void checkLine() {
        /**
         * Methode zum vergleichen der derzeitigen Zeile mit der MasterLine.
         * Bei gleichheit wird die Methode gameWon aufgerufen.
         */
        if (gameIsRunning) {

            //blah blah
            round++;
        }

    }

    public void gameWon() {
        /**
         * Wenn das Spiel gewonnen ist, werden "Highscore" berechnet und das Spiel auf nicht laufend gesetzt.
         */

        gameIsRunning = false;
    }
}
