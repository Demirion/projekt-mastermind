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
        Ball mA = new Ball(Ball.WHITE);
        Ball mB = new Ball(Ball.WHITE);
        Ball mC = new Ball(Ball.BLACK);
        Ball mD = new Ball(Ball.WHITE);
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

        //Help Test
        Line lineArray[] = new Line[4];
        Ball black = new Ball(Ball.BLACK);
        Ball blue = new Ball(Ball.BLUE);
        Ball white = new Ball(Ball.WHITE);
        Ball cyan = new Ball(Ball.CYAN);
        Ball yellow = new Ball(Ball.YELLOW);
        Ball red = new Ball(Ball.RED);
        Ball magenta = new Ball(Ball.MAGENTA);
        Ball green = new Ball(Ball.GREEN);

        Line one = new Line(red, blue, white, cyan);
        Line two = new Line(red, green, cyan, magenta);
        Line three = new Line(white, red, yellow, blue);
        Line four = new Line(red, cyan, yellow, magenta);

        lineArray[0] = one;
        lineArray[1] = two;
        lineArray[2] = three;
        lineArray[3] = four;

        String help;
        //help = helper.getHelp(winLine, lineArray[0]); //Red, Cyan, Black, Blue
        for (int i = 0; i < lineArray.length; i++) {
            System.out.println("Blacks für die Line " + i + ": " + helper.checkLine(winLine, lineArray[i])[0]);
            System.out.println("Whites für die Line " + i + ": " + helper.checkLine(winLine, lineArray[i])[1]);
            System.out.println(helper.getHelp(winLine, lineArray[i]));
            System.out.println();
        }

        System.out.println("LineArray[0]");
        for (int i = 0; i < 4; i++) {
            System.out.println(lineArray[0].getBall(i).getColor());
        }
        System.out.println("WinLine");
        for (int i = 0; i < 4; i++) {
            System.out.println(winLine.getBall(i).getColor());
        }
        System.out.println();
        System.out.println(helper.getHelp(winLine, lineArray[0]));

        Line cheatLine = new Line(green, red, green, red);
        MasterLine cheatMasterLine = new MasterLine(true);
        cheatMasterLine.addBall(red);
        cheatMasterLine.addBall(red);
        cheatMasterLine.addBall(red);
        cheatMasterLine.addBall(green);
        System.out.println(helper.getHelp(cheatMasterLine, cheatLine));

        //MasterLine stuff

        System.out.println();
        System.out.println();
        MasterLine neueMasterLine = new MasterLine(false);

        //Checkline Multicolor test
        System.out.println("Multiline test\n");

        MasterLine multiMaster = new MasterLine(true);
        multiMaster.removeLastBall();
        multiMaster.removeLastBall();
        multiMaster.removeLastBall();
        multiMaster.removeLastBall();
        multiMaster.addBall(new Ball(Ball.WHITE));
        multiMaster.addBall(new Ball(Ball.WHITE));
        multiMaster.addBall(new Ball(Ball.BLACK));
        multiMaster.addBall(new Ball(Ball.WHITE));

        Line multiLine = new Line();
        multiLine.addBall(new Ball(Ball.WHITE));
        multiLine.addBall(new Ball(Ball.BLACK));
        multiLine.addBall(new Ball(Ball.WHITE));
        multiLine.addBall(new Ball(Ball.WHITE));

        int multicheck[] = helper.checkLine(multiMaster, multiLine);
        System.out.println("Multicheck: " + multicheck[0] + " | " + multicheck[1]);


        //Gui angucken :)
        MasterGUI gui = new MasterGUI();

        //MasterGUI.gameHelper.setMasterLine(multiMaster);


    }
}

/**
 * Was es zu sagen gibt:
 * Absolute Pfade gehen mal gar nicht!!
 * Wir brauchen ein Hintergrundbild != Grau
 * extends GameGUISKIZZE. Warum??
 * Nicht alle Dateien hochladen!! Nur source und resource files.
 * EriC braucht die Größenangaben / Relationen
 * Ansonsten, sehr hübsch!
 */