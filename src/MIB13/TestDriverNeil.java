package MIB13;

/**
 * Created by niiru on 16.10.14.
 */
public class TestDriverNeil {

    public static void main(String[] args) {
        Ball ball = new Ball(Ball.RED);
        System.out.println("Farbnummer: " + ball.getColor());
        System.out.println("Farbe: " + ball.getColorString());
        System.out.println("Bild Höhe, Weite: " + ball.getImg().getHeight() + ", " + ball.getImg().getWidth());

    }
}
