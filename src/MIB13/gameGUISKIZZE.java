package MIB13;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by niiru on 17.10.14.
 * <p/>
 * Ich werde hier nur die benötigten funktionen SKIZZIERT und bezüglich
 * Schnittstellen-Kompatiblität beschrieben.
 * <p/>
 * BITTE NICHT DIESE KLASSE VERWENDEN!
 * Die Implementierung nimmt der GUI-Programmierer für sich selbst vor.
 */
public abstract class gameGUISKIZZE {

    GameHelper gameHelper;
    Line lineArray[] = new Line[10];
    int derzeitigeRunde = 3;
    JButton newGameButton;
    JPanel lineA = new JPanel();
    ImageIcon icon;
    JLabel ballLabel;

    void mainMethodeOderSo() {

        //Am besten wäre es wohl ein Gitter zu erstellen, welches wie Folgt aufgebaut ist:
        JFrame frame = new JFrame();
        JPanel backGround = new JPanel();
        JPanel grid[] = new JPanel[10];
        for (int i = 0; i < 10; i++) {
            grid[i] = new JPanel();
        }


        gameHelper = new GameHelper();
        lineA.add(ballLabel);

        //==================================
        //Beispiel für den Neues Game Button
        newGameButton = new JButton("Neues Spiel");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (gameHelper.gameIsRunning()) {
                    //Am besten ein Pop-Up Fenster
                    System.out.println("Wirklich neustarten??");

                    //Wenn JA
                    gameHelper.start();
                } else {
                    //Wenn KEIN Spiel läuft, einfach starten
                    gameHelper.start();
                }
                //ggf. andere Methoden zum zurücksetzen der Bilder etc.
            }
        });

        //======================================
        //Beispiel für das Auswählen einer Kugel

        //Jede RUNDE wird eine neue Line erstellt. In diese werden dann, je nach User auswahl, die Kugeln gelegt.
        Line line = new Line(); //Neue Runde
        lineArray[derzeitigeRunde] = line; //Neue Runde

        Ball ballA = new Ball(Ball.BLACK); //Klick auf eine neue Kugel
        lineArray[derzeitigeRunde].addBall(ballA);
        icon = new ImageIcon(ballA.getImg());
        ballLabel = new JLabel(icon);
        grid[derzeitigeRunde].add(ballLabel);
        //Und das halt für alle ActionListener für die jeweiligen Farben

        //===============================================================
        //Beispiel für das entfernen einer Kugel von der derzeitigen Line

        //Wird auch über den ActionListener getriggert.
        lineArray[derzeitigeRunde].removeLastBall();
        grid[derzeitigeRunde].remove(grid[derzeitigeRunde].getComponentCount());


    }
}
