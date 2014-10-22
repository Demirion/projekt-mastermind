package MIB13;

import java.util.Random;
import java.util.Vector;

/**
 * Created by niiru on 17.10.14.
 * <p/>
 * Die Zeile, die der Spieler erraten soll.
 * Zum erzeugen MUSS ein Boolean übergeben werden, mit der Option, ob
 * Farben doppelt vorkommen dürfen.
 */
public class MasterLine extends Line {
    Random random = new Random();

    public MasterLine(boolean multiColors) {

        if (!multiColors) {
            createSimpleLine();
        } else {
            createMultiLine();
        }
        lineNumber = -1; //Unnötig? Identifizierend für die Masterline (negative Zahl)
    }

    /**
     * Es sollen 4 zufällige Zahlen durch RNG berechnet werden.
     * <p/>
     * Wiederholungen sind ERLAUBT und gewünscht.
     * <p/>
     * Jede Zahl steht für eine Farbe.
     * Für jede Farbe soll eine neue Kugel erzeugt
     * und dem Balls Vektor hinzugefügt werden.
     */
    private void createMultiLine() {

        for (int i = 0; i < GameHelper.LINESIZE; i++) {
            addBall(new Ball(random.nextInt(Ball.COLORCOUNT)));
        }
    }

    /**
     * Es sollen 4 zufällige Zahlen durch RNG berechnet werden.
     * <p/>
     * Wiederholungen sind NICHT erlaubt.
     * <p/>
     * Jede Zahl steht für eine Farbe.
     * Für jede Farbe soll eine neue Kugel erzeugt
     * und dem Balls Vektor hinzugefügt werden.
     */
    private void createSimpleLine() {

        int colorCount = Ball.COLORCOUNT, randInt;
        Vector<Ball> newBalls = new Vector<Ball>(Ball.COLORCOUNT);
        for (int i = 0; i < Ball.COLORCOUNT; i++) {
            newBalls.add(new Ball(i));
        }

        for (int i = 0; i < GameHelper.LINESIZE; i++) {
            getBalls().add(newBalls.get(randInt = random.nextInt(colorCount--)));
            newBalls.remove(randInt);
        }
    }


}
