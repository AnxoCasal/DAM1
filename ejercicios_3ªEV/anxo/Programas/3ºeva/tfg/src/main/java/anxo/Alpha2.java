package anxo;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Alpha2 extends JFrame implements ActionListener {

    JLabel lblDisparo, lblAlien, LBLscore, LBLscoreNUM, LBLplayerName, LBLname, LBLtitle;
    static JLabel player, lblHeart0, lblheart1, lblheart2, lblGAMEOVER;
    JTextArea txtScoreBoard;
    TextField txtEnterName;
    JButton btnStart, btnExit, btnScoreBoard;
    boolean up, left, down, right;
    ArrayList<JLabel> shoot = new ArrayList<JLabel>();
    ArrayList<enemie> objListMobs = new ArrayList<enemie>();
    ArrayList<JLabel> lblListMobs = new ArrayList<JLabel>();
    String[] NombresJugadores = new String[6];
    int[] ScoresJugadores = new int[6];
    static Timer crono, arma, spawn;
    int sec = 0;
    int dps = 450;
    int move = 5;
    int score = 0;
    int arriba = 0;
    int medio = 51;
    int medio2 = 51;
    int abajo = 101;
    int dmg = 1;
    static int hp = 6;
    boolean fin = true;
    boolean scoreMenu = false;
    static Boolean over = false;
    String homepath = System.getProperty("user.home");
    String StringScores = "";
    File file = new File(homepath + "//Documents//SpaceOdysseyScores.txt");

    public Alpha2() {

        super("Alpha Ver");
        this.setLayout(null);
        this.setFocusable(true);

        btnExit = new JButton();
        btnExit.setSize(420, 90);
        btnExit.setLocation(615, 600);
        btnExit.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//exit.png"));
        btnExit.addActionListener(this);
        btnExit.setVisible(false);
        add(btnExit);

        btnStart = new JButton();
        btnStart.setSize(420, 90);
        btnStart.setLocation(615, 465);
        btnStart.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//btnStart.png"));
        btnStart.addActionListener(this);
        add(btnStart);

        btnScoreBoard = new JButton();
        btnScoreBoard.setSize(420, 90);
        btnScoreBoard.setLocation(615, 600);
        btnScoreBoard.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//scores.png"));
        btnScoreBoard.addActionListener(this);
        add(btnScoreBoard);

        txtScoreBoard = new JTextArea();
        txtScoreBoard.setSize(420, 200);
        txtScoreBoard.setLocation(625, 320);
        txtScoreBoard.setForeground(Color.red);
        txtScoreBoard.setEditable(false);
        txtScoreBoard.setBackground(null);
        txtScoreBoard.setFont(new Font(Font.DIALOG, 1, 24));
        txtScoreBoard.setVisible(false);
        add(txtScoreBoard);

        LBLtitle = new JLabel();
        LBLtitle.setSize(716, 65);
        LBLtitle.setLocation(492, 200);
        LBLtitle.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//title.png"));
        add(LBLtitle);

        LBLname = new JLabel();
        LBLname.setSize(285, 45);
        LBLname.setLocation(535, 350);
        LBLname.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//playername.png"));
        add(LBLname);

        txtEnterName = new TextField();
        txtEnterName.setSize(210, 45);
        txtEnterName.setLocation(880, 350);
        txtEnterName.setFont(new Font(Font.DIALOG, 1, 32));
        add(txtEnterName);

        lblGAMEOVER = new JLabel();
        lblGAMEOVER.setSize(300, 140);
        lblGAMEOVER.setLocation(700, 250);
        lblGAMEOVER.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//gameover.png"));
        lblGAMEOVER.setVisible(false);
        this.add(lblGAMEOVER);

        player = new JLabel();
        player.setSize(70, 60);
        player.setLocation(200, 330);
        player.setVisible(false);
        player.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//ship.png"));
        this.add(player);

        lblHeart0 = new JLabel();
        lblHeart0.setSize(60, 60);
        lblHeart0.setLocation(100, 45);
        lblHeart0.setVisible(false);
        lblHeart0.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//cora.PNG"));
        this.add(lblHeart0);

        lblheart1 = new JLabel();
        lblheart1.setSize(60, 60);
        lblheart1.setLocation(175, 45);
        lblheart1.setVisible(false);
        lblheart1.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//cora.PNG"));
        this.add(lblheart1);

        lblheart2 = new JLabel();
        lblheart2.setSize(60, 60);
        lblheart2.setLocation(250, 45);
        lblheart2.setVisible(false);
        lblheart2.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//cora.PNG"));
        this.add(lblheart2);

        LBLscore = new JLabel();
        LBLscore.setSize(280, 80);
        LBLscore.setLocation(550, 35);
        LBLscore.setVisible(false);
        LBLscore.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//score.PNG"));
        this.add(LBLscore);

        LBLscoreNUM = new JLabel("" + score);
        LBLscoreNUM.setSize(280, 80);
        LBLscoreNUM.setLocation(850, 35);
        LBLscoreNUM.setVisible(false);
        LBLscoreNUM.setFont(new Font(Font.DIALOG, 1, 64));
        this.add(LBLscoreNUM);

        LBLplayerName = new JLabel("PLAYER");
        LBLplayerName.setSize(400, 80);
        LBLplayerName.setLocation(1180, 35);
        LBLplayerName.setVisible(false);
        LBLplayerName.setFont(new Font(Font.DIALOG, 1, 64));
        this.add(LBLplayerName);

        crono = new Timer(10, this);

        arma = new Timer(dps, this);

        spawn = new Timer(1000, this);

        getContentPane().setBackground(Color.black);
        this.addKeyListener(new KeyboardHandler());
        this.addWindowListener(new WindowHandler());

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                System.out.println("ERROR");
            }
        }

        if (file.exists()) {
            try (Scanner f = new Scanner(file)) {
                int i = 0;
                while (f.hasNext()) {
                    NombresJugadores[i] = (f.next());
                    ScoresJugadores[i] = (Integer.parseInt(f.next()));
                    i++;
                }
            } catch (Exception e) {
                System.out.println("ERROR");
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crono) {

            // MOVIMIENTO LASER

            for (int i = 0; i < shoot.size(); i++) {
                shoot.get(i).setLocation(shoot.get(i).getX() + 15, shoot.get(i).getY());
                if (shoot.get(i) != null && shoot.get(i).getX() == 1700) {
                    this.remove(shoot.get(i));
                    shoot.remove(i);
                }
            }

            // MOVIMIENTO ENEMIGOS

            for (int i = 0; i < lblListMobs.size(); i++) {
                if (objListMobs.get(i).getEstado() == false) {
                    lblListMobs.get(i).setLocation(lblListMobs.get(i).getX() - objListMobs.get(i).getSpeed(),
                            lblListMobs.get(i).getY());

                    // Balanceo
                    if (objListMobs.get(i).getSwing()) {
                        if (arriba < 100) {
                            lblListMobs.get(i).setLocation(lblListMobs.get(i).getX(), lblListMobs.get(i).getY() + 2);
                            arriba++;
                            if (arriba == 100) {
                                medio = 0;
                            }
                        } else if (medio < 50) {
                            medio++;
                            if (medio == 50) {
                                abajo = 0;
                            }
                        } else if (abajo < 100) {
                            lblListMobs.get(i).setLocation(lblListMobs.get(i).getX(), lblListMobs.get(i).getY() - 2);
                            abajo++;
                            if (abajo == 100) {
                                medio2 = 0;
                            }
                        } else if (medio2 < 50) {
                            medio2++;
                            if (medio2 == 50) {
                                arriba = 0;
                            }
                        }
                    }

                    // Daño

                    if (lblListMobs.get(i).getX() <= +0
                            || lblListMobs.get(i).getBounds().intersects(player.getBounds())) {

                        if (lblListMobs.get(i).getX() <= +0) {
                            this.daño(1);
                        } else if (lblListMobs.get(i).getBounds().intersects(player.getBounds())) {
                            this.daño(2);
                        }

                        objListMobs.get(i).setHP(0);

                    }

                    // Kills

                    for (int j = 0; j < shoot.size(); j++) {
                        if (shoot.get(j).getBounds().intersects(lblListMobs.get(i).getBounds())) {
                            objListMobs.get(i).setHP(objListMobs.get(i).getHP() - dmg);
                            this.remove(shoot.get(j));
                            shoot.remove(j);
                            score++;
                            LBLscore.setText("" + score);
                        }
                    }
                }

                if (objListMobs.get(i).getHP() < 1) {
                    if (!objListMobs.get(i).getEstado()) {
                        objListMobs.get(i).matar();
                    }
                    if (objListMobs.get(i).getDesaparecer()) {
                        this.remove(lblListMobs.get(i));
                        lblListMobs.remove(i);
                        objListMobs.remove(i);
                    }
                    try {
                        lblListMobs.get(i).setIcon(objListMobs.get(i).getIcon());
                    } catch (java.lang.IndexOutOfBoundsException Exception) {
                    }
                }
            }

            // MOVIMIENTO DEL JUGADOR

            if (up == true && player.getY() > 170) {
                player.setLocation(player.getX(), player.getY() - move);
            }
            if (left == true && player.getX() > 100) {
                player.setLocation(player.getX() - move, player.getY());
            }
            if (down == true && player.getY() < 780) {
                player.setLocation(player.getX(), player.getY() + move);
            }
            if (right == true && player.getX() < 400) {
                player.setLocation(player.getX() + move, player.getY());
            }

            // GAME OVER

            if (over) {

                player.setIcon(new ImageIcon(
                        "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//explosion.png"));

                crono.stop();
                arma.stop();
                spawn.stop();
                up = false;
                down = false;
                left = false;
                right = false;

                btnStart.setIcon(new ImageIcon(
                        "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//again.png"));
                btnStart.setVisible(true);
                btnExit.setVisible(true);
                lblGAMEOVER.setVisible(true);

                int newscore = score;
                String newname = LBLplayerName.getText();

                for (int i = 0; i < ScoresJugadores.length; i++) {
                    if (newscore > ScoresJugadores[i]) {
                        for (int j = ScoresJugadores.length - 1; i < j; j--) {
                            ScoresJugadores[j] = ScoresJugadores[j - 1];
                            NombresJugadores[j] = NombresJugadores[j - 1];
                        }
                        ScoresJugadores[i] = newscore;
                        NombresJugadores[i] = newname;
                        i = i + ScoresJugadores.length;
                    }
                }

                over = !over;

            }
        }

        // SPAWN DISPAROS

        if (e.getSource() == arma)

        {
            lblDisparo = new JLabel();
            lblDisparo.setSize(40, 10);
            lblDisparo.setLocation(player.getX() + 80, player.getY() + 25);
            lblDisparo.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//shoot.png"));
            add(lblDisparo);

            shoot.add(lblDisparo);
        }

        // SPAWN ENEMIGOS

        if (e.getSource() == spawn) {
            sec = sec + 1;
            score = score + 1;
            LBLscoreNUM.setText("" + score);

            if (sec % 2 == 0) {

                enemie marciano = new enemie(1);
                lblAlien = new JLabel();
                lblAlien.setIcon(marciano.getIcon());
                lblAlien.setLocation(marciano.getX(), marciano.getY());
                lblAlien.setSize(marciano.getsizeX(), marciano.getsizeY());

                add(lblAlien);
                objListMobs.add(marciano);
                lblListMobs.add(lblAlien);

            }

            if (sec % 6 == 0) {

                int incremento = 0;
                int y = (int) (Math.random() * 410 + 270);

                for (int i = 0; i < 3; i++) {

                    enemie marciano = new enemie(2);

                    incremento += 80;

                    lblAlien = new JLabel();
                    lblAlien.setIcon(marciano.getIcon());
                    lblAlien.setLocation(marciano.getX() + incremento, y);
                    lblAlien.setSize(marciano.getsizeX(), marciano.getsizeY());

                    add(lblAlien);
                    objListMobs.add(marciano);
                    lblListMobs.add(lblAlien);
                }

            }

            if (sec % 9 == 0) {

                int incremento = 0;
                int y = 300;

                for (int i = 0; i < 3; i++) {

                    for (int j = 0; j < 2; j++) {

                        enemie marciano = new enemie(3);

                        incremento += 70;

                        lblAlien = new JLabel();
                        lblAlien.setIcon(marciano.getIcon());
                        lblAlien.setLocation(marciano.getX() + incremento, y);
                        lblAlien.setSize(marciano.getsizeX(), marciano.getsizeY());

                        add(lblAlien);
                        objListMobs.add(marciano);
                        lblListMobs.add(lblAlien);
                    }
                    y += 150;

                }

            }

        }

        // SCORE BOARD

        if (e.getSource() == btnScoreBoard) {

            if (!scoreMenu) {
                btnStart.setVisible(false);
                LBLname.setVisible(false);
                txtEnterName.setVisible(false);
                scoreMenu = !scoreMenu;
                btnScoreBoard.setIcon(new ImageIcon(
                        "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//exit.png"));
                txtScoreBoard.setText(String.format(
                        NombresJugadores[0] + "\t\t" + ScoresJugadores[0] + "\n" +
                                NombresJugadores[1] + "\t\t" + ScoresJugadores[1] + "\n" +
                                NombresJugadores[2] + "\t\t" + ScoresJugadores[2] + "\n" +
                                NombresJugadores[3] + "\t\t" + ScoresJugadores[3] + "\n" +
                                NombresJugadores[4] + "\t\t" + ScoresJugadores[4] + "\n" +
                                NombresJugadores[5] + "\t\t" + ScoresJugadores[5] + "\n"));
                txtScoreBoard.setVisible(true);
            } else {
                btnStart.setVisible(true);
                LBLname.setVisible(true);
                txtEnterName.setVisible(true);
                txtScoreBoard.setVisible(false);
                scoreMenu = !scoreMenu;
                btnScoreBoard.setIcon(new ImageIcon(
                        "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//scores.png"));
            }
        }

        // EXIT

        if (e.getSource() == btnExit) {

            try {
                for (int i = lblListMobs.size() - 1; i != -1; i--) {

                    this.remove(lblListMobs.get(i));
                    lblListMobs.remove(i);
                    objListMobs.remove(i);
                }
            } catch (IndexOutOfBoundsException exception) {
            }

            try {
                for (int i = shoot.size() - 1; i != -1; i--) {

                    this.remove(shoot.get(i));
                    shoot.remove(i);
                }
            } catch (IndexOutOfBoundsException exception) {
            }

            getContentPane().setBackground(Color.black);
            lblHeart0.setVisible(false);
            lblheart1.setVisible(false);
            lblheart2.setVisible(false);
            lblGAMEOVER.setVisible(false);
            btnExit.setVisible(false);
            player.setVisible(false);
            LBLplayerName.setVisible(false);
            LBLscore.setVisible(false);
            LBLscoreNUM.setVisible(false);
            LBLtitle.setVisible(true);
            btnScoreBoard.setVisible(true);
            txtEnterName.setVisible(true);
            LBLname.setVisible(true);
            btnStart.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//btnStart.png"));

        }

        // NEW GAME

        if (e.getSource() == btnStart) {

            try {
                for (int i = lblListMobs.size() - 1; i != -1; i--) {

                    this.remove(lblListMobs.get(i));
                    lblListMobs.remove(i);
                    objListMobs.remove(i);
                }
            } catch (IndexOutOfBoundsException exception) {
            }

            try {
                for (int i = shoot.size() - 1; i != -1; i--) {

                    this.remove(shoot.get(i));
                    shoot.remove(i);
                }
            } catch (IndexOutOfBoundsException exception) {
            }

            score = 0;
            sec = 0;

            LBLscore.setText("" + score);

            hp = 6;
            daño(0);

           // getContentPane().setBackground(null);
            lblHeart0.setVisible(true);
            lblheart1.setVisible(true);
            lblheart2.setVisible(true);
            player.setVisible(true);
            LBLplayerName.setVisible(true);
            LBLscore.setVisible(true);
            LBLscoreNUM.setVisible(true);
            crono.start();
            arma.start();
            spawn.start();
            this.setFocusable(true);

            player.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//ship.png"));

            LBLtitle.setVisible(false);
            btnExit.setVisible(false);
            btnStart.setVisible(false);
            btnScoreBoard.setVisible(false);
            LBLname.setVisible(false);
            txtEnterName.setVisible(false);
            lblGAMEOVER.setVisible(false);
            txtScoreBoard.setVisible(false);

            String LBLname = txtEnterName.getText();
            if (LBLname.length() == 0 || LBLname.length() > 10) {
                LBLname = "Player1";
            }
            LBLplayerName.setText(LBLname);

        }
    }

    private static void daño(int cant) {
        hp = hp - cant;
        if (hp == 6) {
            lblHeart0.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//cora.png"));
            lblheart1.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//cora.png"));
            lblheart2.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//cora.png"));
        }
        if (hp == 5) {
            lblheart2.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//medioCora.png"));
        }
        if (hp == 4) {
            lblheart2.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//coravacio.png"));
        }
        if (hp == 3) {
            lblheart1.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//medioCora.png"));
            lblheart2.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//coravacio.png"));
        }
        if (hp == 2) {
            lblheart1.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//coravacio.png"));
        }
        if (hp == 1) {
            lblheart1.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//coravacio.png"));
            lblHeart0.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//medioCora.png"));
        }
        if (hp < 1) {
            lblHeart0.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//coravacio.png"));
            lblheart1.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//coravacio.png"));
            over = true;
        }
    }

    private class KeyboardHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                up = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                down = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_A) {
                left = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                right = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                up = !up;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                down = !down;
            }
            if (e.getKeyCode() == KeyEvent.VK_A) {
                left = !left;
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                right = !right;
            }
        }

    }

    private class WindowHandler extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {

            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e1) {
                    System.out.println("ERROR");
                }
            }

            if (file.exists()) {
                try (PrintWriter f = new PrintWriter(new FileWriter(file))) {
                    for (int i = 0; i < NombresJugadores.length; i++) {
                        f.println(NombresJugadores[i]);
                        f.println(ScoresJugadores[i]);
                    }
                } catch (Exception Exception) {
                    System.out.println("ERROR");
                }
            }

        }
    }
}
