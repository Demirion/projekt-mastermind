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

        //MasterLine masterLine = new MasterLine(false);

        for (int i = 0; i < 4; i++) {
            System.out.println(lineA.getBall(i).getId());
        }

        //Checkline Test
        GameHelper helper = new GameHelper();
        int sticks[];
        Ball mA = new Ball(Ball.RED);
        Ball mB = new Ball(Ball.CYAN);
        Ball mC = new Ball(Ball.BLACK);
        Ball mD = new Ball(Ball.BLUE);
        MasterLine winLine = new MasterLine(false);
        winLine.addBall(mA);
        winLine.addBall(mB);
        winLine.addBall(mC);
        winLine.addBall(mD);

        System.out.println("lineA: "+lineA.getBall(0).getColor()+lineA.getBall(1).getColor()+lineA.getBall(2).getColor()+lineA.getBall(3).getColor());
        System.out.println("winLine: "+winLine.getBall(0).getColor()+winLine.getBall(1).getColor()+winLine.getBall(2).getColor()+winLine.getBall(3).getColor());

        helper.init();
        sticks = helper.checkLine(winLine, lineA);
        System.out.println("white black "+ sticks[0]+ " "+sticks[1]); //debug

    }
}
