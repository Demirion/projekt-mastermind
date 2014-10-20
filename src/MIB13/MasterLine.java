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

    private void createMultiLine() {
        /**
         * Es sollen 4 zufällige Zahlen durch RNG berechnet werden.
         *
         * Wiederholungen sind ERLAUBT und gewünscht.
         *
         * Jede Zahl steht für eine Farbe.
         * Für jede Farbe soll eine neue Kugel erzeugt
         * und dem Balls Vektor hinzugefügt werden.
         */

        for (int i = 0; i < GameHelper.LINESIZE; i++) {
            addBall(new Ball(random.nextInt(Ball.COLORCOUNT)));
        }
    }

    private void createSimpleLine() {
        /**
         * Es sollen 4 zufällige Zahlen durch RNG berechnet werden.
         *
         * Wiederholungen sind NICHT erlaubt.
         *
         * Jede Zahl steht für eine Farbe.
         * Für jede Farbe soll eine neue Kugel erzeugt
         * und dem Balls Vektor hinzugefügt werden.
         */

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
