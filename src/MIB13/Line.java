package MIB13;

import java.util.Vector;

/**
 * Created by niiru on 17.10.14.
 * <p/>
 * Die Zeile, in der jeweils 4 Kugeln gespeichert werden.
 * Eine Line wird zum Spielstart initialisiert, die restlichen vom Benutzer gefüllt.
 */
public class Line {
    private static int lineID = 0;
    protected int lineNumber; //Unwichtig??
    //private Ball balls[] = new Ball[4];
    private Vector<Ball> balls = new Vector<Ball>(4);

    public Line() {
        lineNumber = lineID++;
    }

    ; //Standard Constructor

    public Line(Ball a, Ball b, Ball c, Ball d) {
        addBall(a);
        addBall(b);
        addBall(c);
        addBall(d);
        lineNumber = lineID++;
    }

    /**
     * @param b A Ball to be added to the Vector.
     */
    public void addBall(Ball b) {
        if (balls.size() < 4) {
            balls.add(b);
        } else {
            System.out.println("Vektor voll.");
        }
    }

    /**
     * Removes the Ball in the last slot of the Vector.
     */
    public void removeLastBall() {
        if (balls.size() > 0)
            balls.remove(balls.size() - 1);
        else System.out.println("Vektor bereits leer.");
    }

    public Vector<Ball> getBalls() {
        return balls;
    } //Gibt das Array zurück. Unnötig?

    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * @param i The position of the Ball  in the Vector.
     * @return Returns the Ball at position i in the Vector.
     */
    public Ball getBall(int i) {
        return balls.elementAt(i);
    }


}
