package MIB13;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;

public class MasterGUI {
    public static Ball[] ballArray = new Ball[4];
    public static GameHelper gameHelper;
    public static Line lineArray[] = new Line[10];
    public static int derzeitigeRunde = 0, anzahlFarbWahlen = 0;
    public static JButton newGameButton, ballButton[], readTippButton, musicButton, screenButton, ballDeleteButton,del[];
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
    public static JMenuItem menuItemTipp;
    public static JMenuItem menuItemAbout;
    public static JMenuItem menuItemClose;
    public static JMenuItem menuItemNewGame;
    public static ButtonGroup buttonGroup;
    public static JMenu menuItemGameModi;
    public static JRadioButtonMenuItem menuItemMultiColorOn;
    public static JRadioButtonMenuItem menuItemMultiColorOff;
    public static JCheckBoxMenuItem menuItemNyanMode;
    public static JMenuBar menuBar;
    public static JMenu menuHelp;
    public static JMenu menuDatei;
    public static JMenu menuOption;
    public static boolean musicplaying = false;
    public static int activeBG = 0;
    public static File bmgAudioFile = new File("./res/snd/bgm.wav");
    public static File nyanAudioFile = new File("./res/snd/bgmnyan.wav");
    public static AudioClip player = null;
    public static JLabel backGroundLabel;
    public static boolean nyanMode = false;
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
    Counter counter = new Counter();

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
        backGroundLabel = new JLabel(backGroundImage);
        JPanel backGround = new JPanel();
        final JPanel controlPanel = new JPanel();
        JPanel mediaPanel = new JPanel();
        JPanel backPanel = new JPanel();
        JPanel panelFrameControl = new JPanel(new BorderLayout());
        JPanel grid[] = new JPanel[10];
        for (int i = 0; i < 10; i++) {
            grid[i] = new JPanel();
            grid[i].setOpaque(false);
        }

        //Frame aufbauen
        frame.setLocation(100, 100);
        frame.setSize(500, 670);
        //frame.setSize(480, 670);
        frame.setMinimumSize(new Dimension(430, 670));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //LayoutManager
        lineA.setLayout(new FlowLayout()); //Nicht genutzt??
        backGround.setLayout(new GridLayout(10, 1));
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        backPanel.setLayout(new FlowLayout(FlowLayout.LEFT,2,0));
        //mediaPanel.setLayout(new BoxLayout(mediaPanel, BoxLayout.X_AXIS));
        mediaPanel.setMinimumSize(new Dimension(5, 12));
        mediaPanel.setSize(new Dimension(5, 12));
        mediaPanel.setPreferredSize(new Dimension(5, 12));
        mediaPanel.setOpaque(false);
        backPanel.setMinimumSize(new Dimension(5, 40));
        backPanel.setSize(new Dimension(5, 40));
        backPanel.setPreferredSize(new Dimension(5, 40));
        backPanel.setOpaque(false);

        del = new JButton[10];
        //Label erstellen
        for (int j = 0; j < grid.length; j++) {
            numberLabel = new JLabel();
            numberLabel.setOpaque(false);
            numberLabel.setSize(36, 50);
            numberLabel.setMinimumSize(new Dimension(36, 50));
            numberLabel.setIcon(new ImageIcon("./res/img/number" + Math.abs(j - 10) + ".png"));
            panelResultDisplay[j] = new JPanel(new GridLayout(2, 2, 2, 2));
            panelResultDisplay[j].setOpaque(false);
            del[j] = new JButton();
            del[j].setIcon(new ImageIcon("./res/img/backButtontrans.png"));
            del[j].setOpaque(false);
            del[j].setBackground(null);
            del[j].setBorderPainted(false);
            del[j].setContentAreaFilled(false);
            del[j].setFocusPainted(false);
            del[j].addActionListener(listener);

            grid[j].add(numberLabel);
            for (int i = 0; i < 4; i++) {
                ballLabel[j][i] = new JLabel(icon,JLabel.CENTER);
                ballLabel[j][i].setSize(50, 50);
                ballLabel[j][i].setHorizontalAlignment(SwingConstants.CENTER);
                ballLabel[j][i].setOpaque(false);
                labelResultDisplay[j][i] = new JLabel(pin);
                labelResultDisplay[j][i].setSize(5, 5);
                labelResultDisplay[j][i].setOpaque(false);
                grid[j].add(ballLabel[j][i]);
                panelResultDisplay[j].add(labelResultDisplay[j][i]);

            }

            grid[j].add(panelResultDisplay[j]);
            grid[j].add(del[j]);
            backGround.add(grid[j]);
        }

        del[9].setIcon(new ImageIcon("./res/img/backButton.png"));

        //Label für Zeit
        timeLabel = new JLabel("     Zeit: 00:00");
        timeLabel.setSize(100, 20);
        timeLabel.setForeground(Color.white);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
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
        for (int i = 0; i < ballButton.length-1; i++) {
            ballButton[i] = new JButton(icon);
            ballButton[i].setSize(50, 50);
            ballButton[i].setBackground(null);
            ballButton[i].setOpaque(false);
            ballButton[i].setContentAreaFilled(false);
            ballButton[i].setFocusPainted(false);
            ballButton[i].getSize();
            ballButton[i].setBorderPainted(false);
            //ballButton[i].setLocation(325, 60 + i * 50);
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

        controlPanel.add(backPanel);
        ballButton[7] = new JButton(icon);
        ballButton[7].setSize(50, 50);
        ballButton[7].setBackground(null);
        ballButton[7].setOpaque(false);
        ballButton[7].setContentAreaFilled(false);
        ballButton[7].setFocusPainted(false);
        ballButton[7].getSize();
        ballButton[7].setBorderPainted(false);
        ballButton[7].addActionListener(listener);
        backPanel.add(ballButton[7]);

        ballButton[7].setIcon(iconBlack);


        //Ball entfernen
        ballDeleteButton = new JButton();
        ballDeleteButton.setSize(35, 35);
        ballDeleteButton.setPreferredSize(new Dimension(35, 35));
        ballDeleteButton.setMinimumSize(new Dimension(35, 35));
        ballDeleteButton.setBorder(null);
        ballDeleteButton.setIcon(new ImageIcon("./res/img/backButton.png"));
        ballDeleteButton.setBackground(null);
        ballDeleteButton.setOpaque(false);
        ballDeleteButton.setContentAreaFilled(false);
        ballDeleteButton.setFocusPainted(false);
        ballDeleteButton.setBorderPainted(false);
        //backPanel.add(ballDeleteButton);
        ballDeleteButton.addActionListener(listener);

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
        musicButton.setMinimumSize(new Dimension(30, 30));
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
            player = Applet.newAudioClip(bmgAudioFile.toURL());
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
            System.out.println("Audiodatei nicht gefunden.");
        }

        //screenButton
        screenButton = new JButton();
        screenButton.setSize(30, 30);
        screenButton.setPreferredSize(new Dimension(30, 30));
        screenButton.setMinimumSize(new Dimension(30, 30));
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
        menuItemClose = new JMenuItem("Beenden");
        menuItemClose.addActionListener(menuListener);

        //Hilfe
        menuItemTipp = new JMenuItem("Tipp");
        menuItemTipp.addActionListener(menuListener);
        menuItemAbout = new JMenuItem("Über");
        menuItemAbout.addActionListener(menuListener);

        //Optionen
        menuItemNewGame = new JMenuItem("Neues Spiel");
        menuItemGameModi = new JMenu("Spielmodus");
        menuItemMultiColorOff = new JRadioButtonMenuItem("Multicolor OFF", true);
        menuItemMultiColorOn = new JRadioButtonMenuItem("Multicolor ON");
        buttonGroup = new ButtonGroup();
        menuItemMultiColorOn.setEnabled(false);
        menuItemMultiColorOff.setEnabled(false);
        buttonGroup.add(menuItemMultiColorOff);
        buttonGroup.add(menuItemMultiColorOn);
        menuItemNyanMode = new JCheckBoxMenuItem("NYAN Mode");
        menuItemGameModi.addActionListener(menuListener);
        menuItemNewGame.addActionListener(menuListener);
        menuItemMultiColorOff.addActionListener(menuListener);
        menuItemMultiColorOn.addActionListener(menuListener);
        menuItemNyanMode.addActionListener(menuListener);

        //Menüelemente zusammenfügen
        menuItemGameModi.add(menuItemMultiColorOff);
        menuItemGameModi.add(menuItemMultiColorOn);
        menuItemGameModi.add(menuItemNyanMode);
        menuBar.add(menuDatei);
        menuBar.add(menuOption);
        menuBar.add(Box.createGlue());
        menuBar.add(menuHelp);

        menuDatei.add(menuItemNewGame);
        menuDatei.add(new JSeparator());
        menuDatei.add(menuItemClose);
        menuHelp.add(menuItemTipp);
        menuHelp.add(menuItemAbout);
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

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                gameHelper.gameSave();
            }

        });
    }

    public void loadFromTxt() throws Exception {
        int[] intArray = new int[4];
        String buffer;
        BufferedReader reader = new BufferedReader(new FileReader("gamesave"));
        intArray[0] = Integer.valueOf(reader.readLine());
        System.out.println("intArray " + intArray[0]);
        derzeitigeRunde = intArray[0];
        gameHelper.setGameIsRunning(true);

        intArray[0] = Integer.valueOf(reader.readLine());
        System.out.println("Zeit " + intArray[0]);
        Counter.count = intArray[0];
        Counter.time = Counter.count % 60;
        Counter.min = Counter.count / 60;

        buffer = reader.readLine();
        System.out.println("Multicolor " + buffer);
        gameHelper.setMultiColors(Boolean.parseBoolean(buffer));

        buffer = reader.readLine();
        intArray[0] = buffer.charAt(0) - 48;
        intArray[1] = buffer.charAt(1) - 48;
        intArray[2] = buffer.charAt(2) - 48;
        intArray[3] = buffer.charAt(3) - 48;
        System.out.println("master " + intArray[0] + " " + intArray[1] + " " + intArray[2] + " " + intArray[3]);

        Ball a = new Ball(intArray[0]);
        Ball b = new Ball(intArray[1]);
        Ball c = new Ball(intArray[2]);
        Ball d = new Ball(intArray[3]);
        gameHelper.setMasterLine(new MasterLine(a, b, c, d));
        System.out.println("Masterline: " + " " + gameHelper.getMasterLine().getBall(0).getColor() + " " + gameHelper.getMasterLine().getBall(1).getColor() + " " + gameHelper.getMasterLine().getBall(2).getColor() + " " + gameHelper.getMasterLine().getBall(3).getColor());

        for (int i = 0; i < derzeitigeRunde; i++) {
            buffer = reader.readLine();
            intArray[0] = buffer.charAt(0) - 48;
            intArray[1] = buffer.charAt(1) - 48;
            intArray[2] = buffer.charAt(2) - 48;
            intArray[3] = buffer.charAt(3) - 48;
            System.out.println("Line: " + intArray[0] + " " + intArray[1] + " " + intArray[2] + " " + intArray[3]);

            a = new Ball(intArray[0]);
            b = new Ball(intArray[1]);
            c = new Ball(intArray[2]);
            d = new Ball(intArray[3]);
            MasterGUI.ballLabel[9 - i][0].setIcon(new ImageIcon(a.getImg()));
            MasterGUI.ballLabel[9 - i][1].setIcon(new ImageIcon(b.getImg()));
            MasterGUI.ballLabel[9 - i][2].setIcon(new ImageIcon(c.getImg()));
            MasterGUI.ballLabel[9 - i][3].setIcon(new ImageIcon(d.getImg()));
            ButtonActionListener.gameField[i][0] = intArray[0];
            ButtonActionListener.gameField[i][1] = intArray[1];
            ButtonActionListener.gameField[i][2] = intArray[2];
            ButtonActionListener.gameField[i][3] = intArray[3];
            Line line = new Line(a, b, c, d);

            int[] anzSticks;
            anzSticks = gameHelper.checkLine(gameHelper.getMasterLine(), line);
            System.out.println("anzSticks[0] = " + anzSticks[0] + " anzSticks[1] = " + anzSticks[1]);
            int k = 0;
            for (int j = anzSticks[1]; j > 0; j--) {
                System.out.println("Weiß");
                MasterGUI.labelResultDisplay[9 - i][k].setIcon(MasterGUI.pinWhite);
                k++;
            }
            k = 0;
            for (int j = anzSticks[0]; j > 0; j--) {
                MasterGUI.labelResultDisplay[9 - i][k].setIcon(MasterGUI.pinBlack);
                k++;
            }

        }
        del[9].setIcon(new ImageIcon("./res/img/backButtontrans.png"));
        del[9-derzeitigeRunde].setIcon(new ImageIcon("./res/img/backButton.png"));
        Counter.timer.start();

    }
}
