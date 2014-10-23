package MIB13;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import static javax.swing.BoxLayout.*;

public class MasterGUI {
    GameHelper gameHelper;
    Line lineArray[] = new Line[10];
    int derzeitigeRunde = 0, anzahlFarbWahlen = 0;
    JButton newGameButton, ballButton[], readTippButton;
    JPanel  lineA = new JPanel();

    JPanel [] panelResultDisplay = new JPanel [10];
    JLabel [][] labelResultDisplay = new JLabel [10][4];
    JLabel  numberLabel, timeLabel;
    JLabel [][]ballLabel = new JLabel[10][4];
    ImageIcon icon = new ImageIcon("./res/img/Farblos.png");
    ImageIcon pin = new ImageIcon("./res/img/pin.png");
    ImageIcon pinWhite = new ImageIcon("./res/img/pinWhite.png");
    ImageIcon pinBlack = new ImageIcon("./res/img/pinBlack.png");

    public Ball ballRed = new Ball(0);
    public Ball ballMagenta = new Ball(1);
    public Ball ballYellow = new Ball(2);
    public Ball ballGreen = new Ball(3);
    public Ball ballBlue = new Ball(4);
    public Ball ballCyan = new Ball(5);
    public Ball ballWhite = new Ball(6);
    public Ball ballBlack = new Ball(7);
    public Ball [] ballArray = new Ball [4];

    ImageIcon iconRed = new ImageIcon(ballRed.getImg());
    ImageIcon iconGreen = new ImageIcon(ballGreen.getImg());
    ImageIcon iconMagenta = new ImageIcon(ballMagenta.getImg());
    ImageIcon iconYellow = new ImageIcon(ballYellow.getImg());
    ImageIcon iconCyan = new ImageIcon(ballCyan.getImg());
    ImageIcon iconBlue = new ImageIcon(ballBlue.getImg());
    ImageIcon iconWhite = new ImageIcon(ballWhite.getImg());
    ImageIcon iconBlack = new ImageIcon(ballBlack.getImg());

    private BufferedImage backgroundImage;


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

        try {
            backgroundImage = ImageIO.read(new File("./res/img/backgroundtest.png"));
        } catch (IOException e) {
            e.printStackTrace();
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
                labelResultDisplay[j][i].setSize(5, 5);
                grid[j].add(ballLabel[j][i]);
                panelResultDisplay[j].add(labelResultDisplay[j][i]);

            }
            grid[j].add(panelResultDisplay[j]);
            backGround.add(grid[j]);
        }

        //Neues Game Button
        newGameButton = new JButton();
        newGameButton.setSize(300,50);
        newGameButton.setIcon(new ImageIcon("./res/img/newgame.png"));
        newGameButton.setBackground(null);
        newGameButton.setBorderPainted(false);
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
        ballButton[0].setIcon(iconRed);
        ballButton[1].setIcon(iconMagenta);
        ballButton[2].setIcon(iconYellow);
        ballButton[3].setIcon(iconGreen);
        ballButton[4].setIcon(iconBlue);
        ballButton[5].setIcon(iconCyan);
        ballButton[6].setIcon(iconWhite);
        ballButton[7].setIcon(iconBlack);

        //Button um Tipp abzugeben
        readTippButton = new JButton();
        readTippButton.setSize(100,50);
        readTippButton.setIcon(new ImageIcon("./res/img/tip.png"));
        readTippButton.setBackground(null);
        readTippButton.setBorderPainted(false);
        controlPanel.add(readTippButton);

        panelFrameControl.add(backGround, BorderLayout.WEST);
        panelFrameControl.add(controlPanel, BorderLayout.EAST);
        frame.add(panelFrameControl);
        frame.setVisible(true);


        //TODO menubar
        //TODO messagedialog für neues spiel wenn noch eins läuft
        //TODO hintergrundbild
        //===================================

        gameHelper = new GameHelper();
        gameHelper.start();
        gameHelper.setMultiColors(false);
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
                if (anzahlFarbWahlen > 3) {
                    lineArray[derzeitigeRunde] = new Line(ballArray[0], ballArray[1], ballArray[2], ballArray[3]);
                    anzahlFarbWahlen = 0;

                    int[] anzSticks = new int[2];
                    anzSticks = gameHelper.checkLine(gameHelper.getMasterLine(), lineArray[derzeitigeRunde]);
                    System.out.println(anzSticks[0] + " " + anzSticks[1]);
                    int k = 0;
                    for (int i = anzSticks[0]; i > 0; i--) {
                        labelResultDisplay[9 - derzeitigeRunde][k].setIcon(pinBlack);
                        k++;
                    }
                    for (int i = anzSticks[1]; i > 0; i--) {
                        labelResultDisplay[9 - derzeitigeRunde][k].setIcon(pinWhite);
                        k++;
                    }
                    derzeitigeRunde++;
                }else {
                    JOptionPane.showMessageDialog(null,"Bitte erst vier Kugeln auswählen.","Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            }

        });

        ballButton[0].addActionListener(new ActionListener() {
                @Override
             public void actionPerformed(ActionEvent e) {
                 if (anzahlFarbWahlen < 4) {
                    ballLabel[9 - derzeitigeRunde][anzahlFarbWahlen].setIcon(iconRed);
                    ballArray[anzahlFarbWahlen] = new Ball(0);
                    anzahlFarbWahlen++;
                 }else{
                    JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben.","Warnung", JOptionPane.PLAIN_MESSAGE);
                  }
             }
        });
        ballButton[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (anzahlFarbWahlen < 4) {
                    ballLabel[9 - derzeitigeRunde][anzahlFarbWahlen].setIcon(iconMagenta);
                    ballArray[anzahlFarbWahlen] = new Ball(1);
                    anzahlFarbWahlen++;
                }else{
                    JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben","Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        ballButton[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (anzahlFarbWahlen < 4) {
                    ballLabel[9 - derzeitigeRunde][anzahlFarbWahlen].setIcon(iconYellow);
                    ballArray[anzahlFarbWahlen] = new Ball(2);
                    anzahlFarbWahlen++;
                }else{
                    JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben","Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        ballButton[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (anzahlFarbWahlen < 4) {
                    ballLabel[9 - derzeitigeRunde][anzahlFarbWahlen].setIcon(iconGreen);
                    ballArray[anzahlFarbWahlen] = new Ball(3);
                    anzahlFarbWahlen++;
                }else{
                    JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben","Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        ballButton[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (anzahlFarbWahlen < 4) {
                    ballLabel[9 - derzeitigeRunde][anzahlFarbWahlen].setIcon(iconBlue);
                    ballArray[anzahlFarbWahlen] = new Ball(4);
                    anzahlFarbWahlen++;
                }else{
                    JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben","Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        ballButton[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (anzahlFarbWahlen < 4) {
                    ballLabel[9 - derzeitigeRunde][anzahlFarbWahlen].setIcon(iconCyan);
                    ballArray[anzahlFarbWahlen] = new Ball(5);
                    anzahlFarbWahlen++;
                }else{
                    JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben","Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        ballButton[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (anzahlFarbWahlen < 4) {
                    ballLabel[9 - derzeitigeRunde][anzahlFarbWahlen].setIcon(iconWhite);
                    ballArray[anzahlFarbWahlen] = new Ball(6);
                    anzahlFarbWahlen++;
                }else{
                    JOptionPane.showMessageDialog(null,"Bitte erst Tipp abgeben","Warnung", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        ballButton[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (anzahlFarbWahlen < 4) {
                    ballLabel[9 - derzeitigeRunde][anzahlFarbWahlen].setIcon(iconBlack);
                    ballArray[anzahlFarbWahlen] = new Ball(7);
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
