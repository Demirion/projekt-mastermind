package MIB13;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;

public class MasterGUI {
    public static Ball[] ballArray = new Ball[4];
    public static GameHelper gameHelper;
    public static Line lineArray[] = new Line[10];
    public static int derzeitigeRunde = 0, anzahlFarbWahlen = 0;
    public static JButton newGameButton, ballButton[], readTippButton, musicButton, screenButton;
    public static JPanel lineA = new JPanel(); //Nicht genutzt?
    public static JPanel[] panelResultDisplay = new JPanel[10];
    public static JLabel[][] labelResultDisplay = new JLabel[10][4];
    public static JLabel numberLabel, timeLabel;
    public static JLabel[][] ballLabel = new JLabel[10][4];
    public static ImageIcon icon = new ImageIcon("./res/img/Farblos.png");
    public static ImageIcon pin = new ImageIcon("./res/img/pingrey.png");
    public static ImageIcon pinWhite = new ImageIcon("./res/img/pinWhite.png");
    public static ImageIcon pinBlack = new ImageIcon("./res/img/pinBlack.png");
    public static ImageIcon backGroundImage = new ImageIcon("./res/img/background0.png");
    public static ImageIcon iconRed = new ImageIcon(("./res/img/Rot.png"));
    public static ImageIcon iconGreen = new ImageIcon(("./res/img/Grün.png"));
    public static ImageIcon iconMagenta = new ImageIcon("./res/img/Magenta.png");
    public static ImageIcon iconYellow = new ImageIcon("./res/img/Gelb.png");
    public static ImageIcon iconCyan = new ImageIcon(("./res/img/Cyan.png"));
    public static ImageIcon iconBlue = new ImageIcon(("./res/img/Blau.png"));
    public static ImageIcon iconWhite = new ImageIcon(("./res/img/Weiß.png"));
    public static ImageIcon iconBlack = new ImageIcon(("./res/img/Schwarz.png"));
    public static JMenuItem menuItemTutorial;
    public static JMenuItem menuItemTipp;
    public static JMenuItem menuItemAbout;
    public static JMenuItem menuItemOpen;
    public static JMenuItem menuItemClose;
    public static JMenuItem menuItemNewGame;
    public static JMenu menuItemGameModi;
    public static JMenuItem menuItemMultiColorOn;
    public static JMenuItem menuItemMultiColorOff;
    public static JMenuBar menuBar;
    public static JMenu menuHelp;
    public static JMenu menuDatei;
    public static JMenu menuOption;
    public static boolean musicplaying = false;
    public static int activeBG = 0;
    public static File audioFile = new File("./res/snd/music.wav");
    public static AudioClip player = null;
    public Ball ballRed = new Ball(0);
    public Ball ballMagenta = new Ball(1);
    public Ball ballYellow = new Ball(2);
    public Ball ballGreen = new Ball(3);
    public Ball ballBlue = new Ball(4);
    public Ball ballCyan = new Ball(5);
    public Ball ballWhite = new Ball(6);
    public Ball ballBlack = new Ball(7);
    ButtonActionListener listener = new ButtonActionListener();
    MenuActionListener menuListener = new MenuActionListener();

    public MasterGUI() {
        Init();
    }

    public static void repaint() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                ballLabel[i][j].setIcon(icon);
                labelResultDisplay[i][j].setIcon(pin);
            }
        }
    }

    void Init() {
        //Am besten wäre es wohl ein Gitter zu erstellen, welches wie Folgt aufgebaut ist:
        JFrame frame = new JFrame("MasterMind");
        JLabel backGroundLabel = new JLabel(backGroundImage);
        JPanel backGround = new JPanel();
        JPanel controlPanel = new JPanel();
        JPanel mediaPanel = new JPanel();
        JPanel panelFrameControl = new JPanel(new BorderLayout());
        JPanel grid[] = new JPanel[10];
        for (int i = 0; i < 10; i++) {
            grid[i] = new JPanel();
            grid[i].setOpaque(false);
        }

        //Frame aufbauen
        frame.setLocation(100, 100);
        frame.setSize(430, 670);
        frame.setMinimumSize(new Dimension(430, 670));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //LayoutManager
        lineA.setLayout(new FlowLayout()); //Nicht genutzt??
        backGround.setLayout(new GridLayout(10, 1));
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        //mediaPanel.setLayout(new BoxLayout(mediaPanel, BoxLayout.X_AXIS));
        mediaPanel.setMinimumSize(new Dimension(5,5));
        mediaPanel.setSize(new Dimension(5,5));
        mediaPanel.setPreferredSize(new Dimension(5,5));
        mediaPanel.setOpaque(false);
        

        //Label erstellen
        for (int j = 0; j < grid.length; j++) {
            numberLabel = new JLabel();
            numberLabel.setOpaque(false);
            numberLabel.setSize(36, 50);
            numberLabel.setMinimumSize(new Dimension(36, 50));
            numberLabel.setIcon(new ImageIcon("./res/img/number" + Math.abs(j - 10) + ".png"));
            //numberLabel.setText(String.valueOf(j + 1));
            panelResultDisplay[j] = new JPanel(new GridLayout(2, 2, 2, 2));
            panelResultDisplay[j].setOpaque(false);

            grid[j].add(numberLabel);
            for (int i = 0; i < 4; i++) {
                ballLabel[j][i] = new JLabel(icon);
                ballLabel[j][i].setSize(50, 50);
                ballLabel[j][i].setOpaque(false);
                labelResultDisplay[j][i] = new JLabel(pin);
                labelResultDisplay[j][i].setSize(5, 5);
                labelResultDisplay[j][i].setOpaque(false);
                grid[j].add(ballLabel[j][i]);
                panelResultDisplay[j].add(labelResultDisplay[j][i]);

            }
            grid[j].add(panelResultDisplay[j]);
            backGround.add(grid[j]);
        }

        //Label für Zeit
        timeLabel = new JLabel("Zeit: ");
        timeLabel.setSize(100, 20);
        timeLabel.setForeground(Color.white);
        controlPanel.add(timeLabel);

        //Neues Game Button
        newGameButton = new JButton();
        newGameButton.setSize(100, 30);
        newGameButton.setMinimumSize(new Dimension(100, 30));
        newGameButton.setPreferredSize(new Dimension(100, 30));
        newGameButton.setIcon(new ImageIcon("./res/img/newgame.png"));
        newGameButton.setOpaque(false);
        newGameButton.setBackground(null);
        newGameButton.setBorderPainted(false);
        newGameButton.setContentAreaFilled(false);
        newGameButton.setFocusPainted(false);
        newGameButton.addActionListener(listener);
        controlPanel.add(newGameButton);

        //Button für Ball erzeugen
        ballButton = new JButton[8];
        for (int i = 0; i < ballButton.length; i++) {
            ballButton[i] = new JButton(icon);
            ballButton[i].setSize(50, 50);
            ballButton[i].setBackground(null);
            ballButton[i].setOpaque(false);
            ballButton[i].setContentAreaFilled(false);
            ballButton[i].setFocusPainted(false);
            ballButton[i].getSize();
            //ballButton[i].setBorder(null);
            ballButton[i].setBorderPainted(false);
            ballButton[i].setLocation(325, 60 + i * 50);
            ballButton[i].addActionListener(listener);
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
        readTippButton.setSize(100, 50);
        readTippButton.setIcon(new ImageIcon("./res/img/tip.png"));
        readTippButton.setBackground(null);
        readTippButton.setOpaque(false);
        readTippButton.setContentAreaFilled(false);
        readTippButton.setFocusPainted(false);
        readTippButton.setBorderPainted(false);
        readTippButton.addActionListener(listener);
        controlPanel.add(readTippButton);

        controlPanel.add(mediaPanel);
        
        //music button
        musicButton = new JButton();
        musicButton.setSize(30, 30);
        musicButton.setPreferredSize(new Dimension(30, 30));
        musicButton.setMinimumSize(new Dimension(30,30));
        musicButton.setIcon(new ImageIcon("./res/img/audio_off.png"));
        musicButton.setBackground(null);
        musicButton.setOpaque(false);
        musicButton.setContentAreaFilled(false);
        musicButton.setFocusPainted(false);
        musicButton.setBorderPainted(false);
        musicButton.addActionListener(listener);
        mediaPanel.add(musicButton);

        //Music Player
        try {
            player = Applet.newAudioClip(audioFile.toURL());
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
            System.out.println("Audiodatei nicht gefunden.");
        }
        
        //screenButton
        screenButton = new JButton();
        screenButton.setSize(30,30);
        screenButton.setPreferredSize(new Dimension(30,30));
        screenButton.setMinimumSize(new Dimension(30,30));
        screenButton.setIcon(new ImageIcon("./res/img/screen_button.png"));
        screenButton.setBackground(null);
        screenButton.setOpaque(false);
        screenButton.setContentAreaFilled(false);
        screenButton.setFocusPainted(false);
        screenButton.setBorderPainted(false);
        screenButton.addActionListener(listener);
        mediaPanel.add(screenButton);

        //MenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuDatei = new JMenu("Datei");
        JMenu menuHelp = new JMenu("Hilfe");
        JMenu menuOption = new JMenu("Optionen");

        //Datei
        menuItemOpen = new JMenuItem("Öffnen");
        menuItemOpen.addActionListener(menuListener);
        menuItemClose = new JMenuItem("Beenden");
        menuItemClose.addActionListener(menuListener);

        //Hilfe
        menuItemTutorial = new JMenuItem("Anleitung");
        menuItemTutorial.addActionListener(menuListener);
        menuItemTipp = new JMenuItem("Tipp");
        menuItemTipp.addActionListener(menuListener);
        menuItemAbout = new JMenuItem("Über");
        menuItemAbout.addActionListener(menuListener);

        //Optionen
        menuItemNewGame = new JMenuItem("Neues Spiel");
        menuItemGameModi = new JMenu("Spielmodus");
        menuItemMultiColorOff = new JMenuItem("Multicolor OFF");
        menuItemMultiColorOn = new JMenuItem("Multicolor ON");
        menuItemGameModi.addActionListener(menuListener);
        menuItemNewGame.addActionListener(menuListener);
        menuItemMultiColorOff.addActionListener(menuListener);
        menuItemMultiColorOn.addActionListener(menuListener);

        //Menüelemente zusammenfügen
        menuItemGameModi.add(menuItemMultiColorOff);
        menuItemGameModi.add(menuItemMultiColorOn);
        menuBar.add(menuDatei);
        menuBar.add(menuOption);
        menuBar.add(Box.createGlue());
        menuBar.add(menuHelp);

        menuDatei.add(menuItemOpen);
        menuDatei.add(new JSeparator());
        menuDatei.add(menuItemClose);
        menuHelp.add(menuItemTutorial);
        menuHelp.add(menuItemTipp);
        menuHelp.add(menuItemAbout);
        menuOption.add(menuItemNewGame);
        menuOption.add(menuItemGameModi);

        backGroundLabel.add(menuBar);
        frame.setJMenuBar(menuBar);

        //Alles zusammenfügen
        panelFrameControl.add(backGround, BorderLayout.WEST);
        panelFrameControl.add(controlPanel, BorderLayout.EAST);
        panelFrameControl.setOpaque(false);
        controlPanel.setOpaque(false);
        backGround.setOpaque(false);
        backGroundLabel.setLayout(new FlowLayout());
        backGroundLabel.add(panelFrameControl);
        frame.setContentPane(backGroundLabel);
        frame.setVisible(true);

        gameHelper = new GameHelper();

    }
}
