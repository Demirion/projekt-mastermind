package MIB13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import static javax.swing.BoxLayout.*;

public class MasterGUI extends gameGUISKIZZE {
    GameHelper gameHelper;
    Line lineArray[] = new Line[10];
    int derzeitigeRunde = 0, anzahlFarbWahlen = 0;
    JButton newGameButton, ballButton[], readTippButton;
    JPanel  lineA = new JPanel();

    JPanel [] panelResultDisplay = new JPanel [10];
    JLabel [][] labelResultDisplay = new JLabel [10][4];
    JLabel  numberLabel, timeLabel;
    JLabel [][]ballLabel = new JLabel[10][4];
    ImageIcon icon = new ImageIcon("/Users/erikrohkohl/IdeaProjects/projekt-mastermind/src/MIB13/pics/greyBall.png");
    ImageIcon pin = new ImageIcon("/Users/erikrohkohl/IdeaProjects/projekt-mastermind/src/MIB13/pics/pin.png");
    ImageIcon icontest = new ImageIcon("/Users/erikrohkohl/IdeaProjects/projekt-mastermind/src/MIB13/pics/magenta.png");
    ImageIcon pinWhite = new ImageIcon("/Users/erikrohkohl/IdeaProjects/projekt-mastermind/src/MIB13/pics/pinWhite.png");
    ImageIcon pinBlack = new ImageIcon("/Users/erikrohkohl/IdeaProjects/projekt-mastermind/src/MIB13/pics/pinBlack.png");

    public Ball ballRed = new Ball(0);
    public Ball ballGreen = new Ball(1);
    public Ball ballMagenta = new Ball(2);
    public Ball ballYellow = new Ball(3);
    public Ball ballCyan = new Ball(4);
    public Ball ballBlue = new Ball(5);
    public Ball ballWhite = new Ball(6);
    public Ball ballBlack = new Ball(7);

    public Ball [] ballArray = new Ball [4];


    ImageIcon iconRed = new ImageIcon(ballRed.getImg());
    /*
    ImageIcon iconGreen = new ImageIcon(ballGreen.getImg());
    ImageIcon iconMagenta = new ImageIcon(ballMagenta.getImg());
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
        JPanel controlPanel = new JPanel();
        JPanel panelFrameControl = new JPanel(new BorderLayout());
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
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        //Label erstellen
        for (int j = 0; j < grid.length ;j++) {
            numberLabel = new JLabel();
            numberLabel.setSize(40,40);
            numberLabel.setText(String.valueOf(j + 1));
            panelResultDisplay[j] = new JPanel(new GridLayout(2,2,2,2));

            grid[j].add(numberLabel);
            for (int i = 0; i < 4; i++) {
                ballLabel[j][i] = new JLabel(icon);
                ballLabel[j][i].setSize(40, 40);
                labelResultDisplay[j][i] = new JLabel(pin);
                //labelResultDisplay[i].setText("o");
                labelResultDisplay[j][i].setSize(5, 5);
                grid[j].add(ballLabel[j][i]);
                panelResultDisplay[j].add(labelResultDisplay[j][i]);

            }
            grid[j].add(panelResultDisplay[j]);
            backGround.add(grid[j]);
        }

        //Neues Game Button
        newGameButton = new JButton("Neues Spiel");
        newGameButton.setSize(300,50);
        //newGameButton.setLocation(300,10);
        controlPanel.add(newGameButton);

        //Label für Zeit
        timeLabel = new JLabel("Zeit");
        timeLabel.setSize(100,100);
        controlPanel.add(timeLabel);

        //Button für Ball erzeugen
        ballButton = new JButton[8];
        for (int i = 0; i < ballButton.length; i++){
            ballButton[i] = new JButton(icon);
            ballButton[i].setSize(50,50);
            ballButton[i].setBackground(null);
            //ballButton[i].setBorder(null);
            ballButton[i].setBorderPainted(false);
            ballButton[i].setLocation(325,60 + i * 50);
            controlPanel.add(ballButton[i]);
        }
        //ballButton[0].setIcon(ballMagenta.getImg());
        ballButton[0].setIcon(icontest);

        //Button um Tipp abzugeben
        readTippButton = new JButton("Tipp abgeben");
        readTippButton.setSize(100,50);
        controlPanel.add(readTippButton);

        panelFrameControl.add(backGround, BorderLayout.WEST);
        panelFrameControl.add(controlPanel, BorderLayout.EAST);
        frame.add(panelFrameControl);
        frame.setVisible(true);

        //TODO ballbutton bilder zuweisen

        //TODO label für die Anzeige der Richtigen hinzufügen

        //TODO reihenfolge zahlen umkehren
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

        readTippButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lineArray[derzeitigeRunde] = new Line(ballArray[0], ballArray[1], ballArray[2], ballArray[3]);
                anzahlFarbWahlen = 0;
                derzeitigeRunde++;
                int [] anzSticks = new int[2];
                anzSticks = gameHelper.checkLine(gameHelper.getMasterLine(), lineArray[derzeitigeRunde]);
                anzSticks[0] = 2;
                anzSticks[1] = 2;
                int k = 0;
                for (int i = anzSticks[0]; i > 0; i--) {
                     labelResultDisplay[10 - derzeitigeRunde][k].setIcon(pinBlack);
                      k++;
                }
                for (int i = anzSticks[1]; i > 0; i--) {
                    labelResultDisplay[10 - derzeitigeRunde][k].setIcon(pinWhite);
                    k++;
                }
            }

        });

        ballButton[0].addActionListener(new ActionListener() {
                @Override
             public void actionPerformed(ActionEvent e) {
                 if (anzahlFarbWahlen < 4) {
                    //ballLabel[9 - derzeitigeRunde][anzahlFarbWahlen].setIcon(iconRed);
                    ballLabel[9 - derzeitigeRunde][anzahlFarbWahlen].setIcon(icontest);
                    ballArray[anzahlFarbWahlen] = new Ball(0);
                    anzahlFarbWahlen++;
                 }else{
                    JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben","Warnung", JOptionPane.PLAIN_MESSAGE);
                  }
             }
        });



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
