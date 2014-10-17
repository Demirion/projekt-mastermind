package MIB13;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by niiru on 16.10.14.
 * <p/>
 * Dies sind die Kugeln, die man zum Raten nutzt.
 * Die Farben werden über Nummern verteilt.
 * Damit lässt sich leicher Arbeiten als mit Strings.
 * <p/>
 * Das Laden der Bilder passiert über den colorString mit der Dateiendung gif(später jpg??)
 */
public class Ball {
    //public enum colorEnum {red, green, yellow, blue, orange, cyan};
    // Farben werden noch abgesprochen
    public final static int RED = 0, MAGENTA = 1, YELLOW = 2, GREEN = 3, BLUE = 4, CYAN = 5, WHITE = 6, BLACK = 7;
    private BufferedImage img;
    private int color;
    private String colorString;

    public String getColorString() {
        return colorString;
    }

    public int getId() {
        return id;
    }

    public static int idCounter = 0;
    int id;

    public BufferedImage getImg() {
        return img;
    }

    public int getColor() {
        return color;
    }

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

            default: //Darf eigentlich nicht passieren!
                this.colorString = "Farblos";
                this.color = -1;
                break;
        }
        try {
            //TODO Dateiendung ggf. Ändern.
            img = ImageIO.read(new File("./res/img/" + this.colorString + ".gif")); //gif in jpg ändern?
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not load Image.");
        }
    }
}
