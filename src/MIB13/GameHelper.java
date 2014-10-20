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
    private MasterLine masterLine;
    private int sticks[] = new int[2]; //[0] = black; [1] = white;

    public boolean gameIsRunning() {
        return gameIsRunning;
    }

    public boolean isMultiColors() {
        return multiColors;
    }

    public MasterLine getMasterLine() {return masterLine;}

    public int getRound() {
        return round;
    }

    public void setMultiColors(boolean multiColors) {
        /**
         * Diese wird von dem Actionlistener der ComboBox aufgerufen!!
         */
        this.multiColors = multiColors;
    }

    public void init() {
        /**
         * Initialisierung.
         * TODO Alle Werte auf 0 bzw false setzen.
         */
        round = 0;
        masterLine = null;

    }

    public void start() {
        /**
         * Spielstart.
         * TODO Es soll überprüft werden, ob die Multicolors option gesetzt wurde und danach
         * eine MasterLine mit dem Argument multiColors erstellt werden.
         */
        init();
        masterLine = new MasterLine(isMultiColors());
        gameIsRunning = true;

    }

    public int[] checkLine(MasterLine masterLine, Line line) { //Fertig(?)
        /**
         * Methode zum vergleichen der derzeitigen Zeile mit der MasterLine.
         * Bei gleichheit (blackSticks == 4) wird die Methode gameWon aufgerufen.
         *
         * Gibt int Array mit anzahl der Schwarzen und Weißen Sticks zurück.
         */
        if (gameIsRunning) {
            sticks[0] = sticks[1] = 0;

            for (int i = 0; i < masterLine.getBalls().size(); i++) {
                if (masterLine.getBall(i).getColor() == line.getBall(i).getColor()){
                    sticks[0]++;
                }   else {
                    for (int j = 0; j < masterLine.getBalls().size(); j++) {
                        if (masterLine.getBall(i).getColor() == line.getBall(j).getColor()){
                            sticks[1]++;
                        }
                    }
                }
            }
            if (sticks[0]==4) gameWon();
            round++;
        }
        return sticks;
    }

    public void gameWon() {
        /**
         * Wenn das Spiel gewonnen ist, werden "Highscore" berechnet und das Spiel auf nicht laufend gesetzt.
         */
        System.out.println("Gewonnen!"); //Debug

        gameIsRunning = false;
    }
}
