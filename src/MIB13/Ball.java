package MIB13;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by niiru on 16.10.14.
 *
 * Dies sind die Kugeln, die man zum Raten nutzt.
 * Die Farben werden über Nummern verteilt. (Siehe README oder unten)
 * Damit lässt sich leicher Arbeiten als mit Strings.
 *
 * Das Laden der Bilder passiert über den colorString mit der Dateiendung png.
 *
 */
public class Ball {

    public final static int RED = 0, MAGENTA = 1, YELLOW = 2, GREEN = 3, BLUE = 4, CYAN = 5, WHITE = 6, BLACK = 7;
    public final static int COLORCOUNT = 8;
    public static int idCounter = 0;
    int id;
    private BufferedImage img;
    private int color;
    private String colorString;

    public Ball(int i) {
        id = idCounter++;
        switch (i) {
            case RED:
                this.color = i;
                this.colorString = "Rot";
                break;
            case GREEN:
                this.color = i;
                this.colorString = "Grün";
                break;
            case MAGENTA:
                this.color = i;
                this.colorString = "Magenta";
                break;
            case YELLOW:
                this.color = i;
                this.colorString = "Gelb";
                break;
            case CYAN:
                this.color = i;
                this.colorString = "Cyan";
                break;
            case BLUE:
                this.color = i;
                this.colorString = "Blau";
                break;
            case WHITE:
                this.color = i;
                this.colorString = "Weiß";
                break;
            case BLACK:
                this.color = i;
                this.colorString = "Schwarz";
                break;

            default: //Darf eigentlich nicht passieren!
                this.colorString = "Farblos";
                this.color = -1;
                break;
        }
        try {
            img = ImageIO.read(new File("./res/img/" + this.colorString + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not load Image.");
        }
    }

    public String getColorString() {
        return colorString;
    }

    public int getId() {
        return id;
    }

    public BufferedImage getImg() {
        return img;
    }

    public int getColor() {
        return color;
    }
}
