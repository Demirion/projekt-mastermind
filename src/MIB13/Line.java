package MIB13;

/**
 * Created by niiru on 17.10.14.
 * <p/>
 * Die Zeile, in der jeweils 4 Kugeln gespeichert werden.
 * Eine Line wird zum Spielstart initialisiert, die restlichen vom Benutzer gefüllt.
 */
public class Line {
    Ball balls[];
    int lineNumber; //Wichtig??
    static int lineID = 0;

    public Line() {
    }

    ; //Standard Constructor

    public Line(Ball a, Ball b, Ball c, Ball d) {
        balls[0] = a;
        balls[1] = b;
        balls[2] = c;
        balls[3] = d;
        lineNumber = lineID++;
    }

    public Ball[] getBalls() {
        return balls;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public Ball getBall(int i) {
        return balls[i];
    }


}
