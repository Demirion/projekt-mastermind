package MIB13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

import static javax.swing.BoxLayout.*;

public class MasterGUI extends gameGUISKIZZE {
    GameHelper gameHelper;
    Line lineArray[] = new Line[10];
    int derzeitigeRunde = 3;
    JButton newGameButton, ballButton[];
    JPanel  lineA = new JPanel();
    JLabel ballLabel, numberLabel;
    ImageIcon icon = new ImageIcon("/Users/erikrohkohl/IdeaProjects/projekt-mastermind/src/MIB13/pics/greyBall.png");

    public Ball ballRed = new Ball(0);
    public Ball ballGreen = new Ball(1);
    public Ball ballMangenta = new Ball(2);
    public Ball ballYellow = new Ball(3);
    public Ball ballCyan = new Ball(4);
    public Ball ballBlue = new Ball(5);
    public Ball ballWhite = new Ball(6);
    public Ball ballBlack = new Ball(7);

    /*
    ImageIcon iconRed = new ImageIcon(ballRed.getImg());
    ImageIcon iconGreen = new ImageIcon(ballGreen.getImg());
    ImageIcon iconMangenta = new ImageIcon(ballMangenta.getImg());
    ImageIcon iconYellow = new ImageIcon(ballYellow.getImg());
    ImageIcon iconCyan = new ImageIcon(ballCyan.getImg());
    ImageIcon iconBlue = new ImageIcon(ballBlue.getImg());
    ImageIcon iconWhite = new ImageIcon(ballWhite.getImg());
    ImageIcon iconBlack = new ImageIcon(ballBlack.getImg());
    */

    public MasterGUI(){
        Init();
    }

    void Init() {
        //Am besten wäre es wohl ein Gitter zu erstellen, welches wie Folgt aufgebaut ist:
        JFrame frame = new JFrame();
        JPanel backGround = new JPanel();
        JPanel grid[] = new JPanel[10];
        for (int i = 0; i < 10; i++) {
            grid[i] = new JPanel();
        }

        //Frame aufbauen
        frame.setLocation(100, 100);
        frame.setSize(350, 500);
        frame.setMinimumSize(new Dimension(400, 650));
        frame.setTitle("Master Main");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //LayoutManager
        lineA.setLayout(new FlowLayout());
        backGround.setLayout(new GridLayout(10, 1));

        //Label erstellen
        for (int j = 0; j < grid.length ;j++) {
            numberLabel = new JLabel();
            numberLabel.setSize(40,40);
            numberLabel.setText(String.valueOf(j+1));
            grid[j].add(numberLabel);
            for (int i = 0; i < 4; i++) {
                ballLabel = new JLabel(icon);
                ballLabel.setSize(40, 40);
                //lineA.add(ballLabel);
                grid[j].add(ballLabel);
            }
            backGround.add(grid[j]);
        }

        //Neues Game Button
        newGameButton = new JButton("Neues Spiel");
        newGameButton.setSize(100,50);
        newGameButton.setLocation(300,10);
        frame.add(newGameButton);

        //Button für Ball erzeugen
        ballButton = new JButton[8];
        for (int i = 0; i < ballButton.length; i++){
            ballButton[i] = new JButton(icon);
            ballButton[i].setSize(50,50);
            ballButton[i].setLocation(325,60 + i * 50);
            frame.add(ballButton[i]);
        }

        //TODO ballbutton bilder zuweisen

        //TODO label für die Anzeige der Richtigen hinzufügen
        //===================================

        gameHelper = new GameHelper();
        //==================================

        //ActionListener
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

        frame.add(backGround);
        frame.setVisible(true);
        //======================================
        //Beispiel für das Auswählen einer Kugel

        //Jede RUNDE wird eine neue Line erstellt. In diese werden dann, je nach User auswahl, die Kugeln gelegt.
        /*Line line = new Line(); //Neue Runde
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
        */

    }

}
