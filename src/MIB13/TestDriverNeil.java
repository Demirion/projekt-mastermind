package MIB13;

/**
 * Created by niiru on 16.10.14.
 */
public class TestDriverNeil {

    public static void main(String[] args) {
        Ball ballA = new Ball(Ball.RED);
        System.out.println("Farbnummer: " + ballA.getColor());
        System.out.println("Farbe: " + ballA.getColorString());
        Ball ballB = new Ball(Ball.GREEN);
        Ball ballC = new Ball(Ball.BLACK);
        Ball ballD = new Ball(Ball.CYAN);

        Line lineA = new Line(ballA, ballB, ballC, ballD);

        lineA.getLineNumber();
        System.out.println("Die 3. Kugel hat die Farbe " + lineA.getBall(2).getColorString());

        MasterLine masterLine = new MasterLine(false);

        for (int i = 0; i < 4; i++) {
            System.out.println(lineA.getBall(i).getId());
        }
    }
}
