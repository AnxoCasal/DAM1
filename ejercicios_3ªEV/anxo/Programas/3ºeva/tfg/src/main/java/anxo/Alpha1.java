package anxo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Alpha1 extends JFrame implements ActionListener {

    JLabel player, bg, disparo, alien, alienLine, hud, LBLscore, LBLscoreNUM;
    static JLabel heart0;
    static JLabel heart1;
    static JLabel heart2;
    boolean up, left, down, right;
    ArrayList<JLabel> shoot = new ArrayList<JLabel>();
    ArrayList<JLabel> enemies = new ArrayList<JLabel>();
    ArrayList<JLabel> enemiesLine = new ArrayList<JLabel>();
    Timer crono;
    Timer arma;
    Timer jazz;
    int sec = 0;
    int move = 4;
    int score = 0;
    int arriba = 0;
    int abajo = 100;
    boolean fin = true;
    static int hp = 6;

    public Alpha1() {

        super("Alpha Ver");
        this.setLayout(null);
        this.setFocusable(true);

        player = new JLabel();
        player.setSize(70, 60);
        player.setLocation(200, 330);
        player.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//ship.png"));
        this.add(player);

        // hud = new JLabel();
        // hud.setSize(1500, 150);
        // hud.setLocation(0, 0);
        // hud.setIcon(new ImageIcon(
        // "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//hud.png"));
        // this.add(hud);

        heart0 = new JLabel();
        heart0.setSize(60, 60);
        heart0.setLocation(100, 45);
        heart0.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//cora.PNG"));
        this.add(heart0);

        heart1 = new JLabel();
        heart1.setSize(60, 60);
        heart1.setLocation(175, 45);
        heart1.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//cora.PNG"));
        this.add(heart1);

        heart2 = new JLabel();
        heart2.setSize(60, 60);
        heart2.setLocation(250, 45);
        heart2.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//cora.PNG"));
        this.add(heart2);

        LBLscore = new JLabel();
        LBLscore.setSize(280, 80);
        LBLscore.setLocation(550, 35);
        LBLscore.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//score.PNG"));
        this.add(LBLscore);

        LBLscoreNUM = new JLabel("" + score);
        LBLscoreNUM.setSize(280, 80);
        LBLscoreNUM.setLocation(850, 35);
        LBLscoreNUM.setFont(new Font(Font.MONOSPACED, 1, 64));
        this.add(LBLscoreNUM);

        // bg = new JLabel();
        // bg.setSize(1500, 900);
        // bg.setLocation(0, 0);
        // bg.setIcon(new ImageIcon(
        // "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//gameover.jpg"));
        // bg.setVisible(false);
        // this.add(bg);

        crono = new Timer(10, this);
        crono.start();

        arma = new Timer(750, this);
        arma.start();

        jazz = new Timer(1000, this);
        jazz.start();

        this.addKeyListener(new KeyboardHandler());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crono) {

            // MOVIMIENTO Y FINAL DE LASER

            for (int i = 0; i < shoot.size(); i++) {
                shoot.get(i).setLocation(shoot.get(i).getX() + 8, shoot.get(i).getY());
                if (shoot.get(i) != null && shoot.get(i).getX() == 1500) {
                    this.remove(shoot.get(i));
                    shoot.remove(i);
                }
            }

            // MOVIMIENTO Y COLISION DE ENEMIGOS
            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).setLocation(enemies.get(i).getX() - 5, enemies.get(i).getY());
                if (arriba < 100) {
                    enemies.get(i).setLocation(enemies.get(i).getX(), enemies.get(i).getY() + 2);
                    arriba++;
                    if (arriba == 100) {
                        abajo = 0;
                    }
                } else if (abajo < 100) {
                    enemies.get(i).setLocation(enemies.get(i).getX(), enemies.get(i).getY() - 2);
                    abajo++;
                    if (abajo == 100) {
                        arriba = 0;
                    }
                }
                if ((enemies.get(i) != null && enemies.get(i).getX() == -70)) {
                    this.remove(enemies.get(i));
                    enemies.remove(i);
                    Alpha1.daño(1);
                } else if (enemies.get(i).getBounds().intersects(player.getBounds())) {
                    this.remove(enemies.get(i));
                    enemies.remove(i);
                    Alpha1.daño(2);
                }
                if (hp == 0) {
                    System.out.println("U LOSE");
                    crono.stop();
                    arma.stop();
                    jazz.stop();
                }
                try {
                    for (int j = 0; j < shoot.size(); j++) {
                        if (enemies.get(i).getBounds().intersects(shoot.get(j).getBounds())) {
                            this.remove(enemies.get(i));
                            enemies.remove(i);
                            this.remove(shoot.get(j));
                            shoot.remove(j);
                            score = score + 1;
                            LBLscoreNUM.setText("" + score);
                        }
                    }
                } catch (java.lang.IndexOutOfBoundsException exception) {
                    System.out.println("ah vuelto a pasar");
                }
            }

            ////////////////////////////////////////

            for (int i = 0; i < enemiesLine.size(); i++) {
                enemiesLine.get(i).setLocation(enemiesLine.get(i).getX() - 7, enemiesLine.get(i).getY());
                if ((enemiesLine.get(i) != null && enemiesLine.get(i).getX() == -70)) {
                    this.remove(enemiesLine.get(i));
                    enemiesLine.remove(i);
                    Alpha1.daño(1);
                } else if (enemiesLine.get(i).getBounds().intersects(player.getBounds())) {
                    this.remove(enemiesLine.get(i));
                    enemiesLine.remove(i);
                    Alpha1.daño(2);
                }
                if (hp == 0) {
                    System.out.println("U LOSE");
                    crono.stop();
                    arma.stop();
                    jazz.stop();
                }
                try {
                    for (int j = 0; j < shoot.size(); j++) {
                        if (enemiesLine.get(i).getBounds().intersects(shoot.get(j).getBounds())) {
                            this.remove(enemiesLine.get(i));
                            enemiesLine.remove(i);
                            this.remove(shoot.get(j));
                            shoot.remove(j);
                            score = score + 1;
                            LBLscoreNUM.setText("" + score);
                        }
                    }
                } catch (java.lang.IndexOutOfBoundsException exception) {
                    System.out.println("ah vuelto a pasar");
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
            if (right == true && player.getX() < 285) {
                player.setLocation(player.getX() + move, player.getY());
            }
        }

        // SPAWN DISPAROS

        if (e.getSource() == arma) {
            disparo = new JLabel();
            disparo.setSize(40, 20);
            disparo.setLocation(player.getX() + 80, player.getY() + 25);
            disparo.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//shoot.png"));
            add(disparo);

            shoot.add(disparo);
        }

        // SPAWN ENEMIGOS

        if (e.getSource() == jazz) {
            sec = sec + 1;
            score = score + 1;
            LBLscoreNUM.setText("" + score);

            if (sec % 2 == 0) {
                int rnd = (int) (Math.random() * 410 + 270);

                alien = new JLabel();
                alien.setSize(65, 75);
                alien.setLocation(1710, rnd);
                alien.setIcon(new ImageIcon(
                        "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//enemie.V2.png"));
                add(alien);

                enemies.add(alien);
            }

            if (sec % 9 == 0) {

                int rnd = (int) (Math.random() * 410 + 270);
                int altura = 1710;

                for (int i = 0; i < 3; i++) {

                    altura = altura + 70;

                    alienLine = new JLabel();
                    alienLine.setSize(65, 75);
                    alienLine.setLocation(altura, rnd);
                    alienLine.setIcon(new ImageIcon(
                            "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//enemie.V3.png"));
                    add(alienLine);

                    enemiesLine.add(alienLine);
                }
            }

        }
    }

    private static void daño(int cant) {
        hp = hp - cant;
        if (hp == 5) {
            heart2.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//medioCora.png"));
        }
        if (hp == 4) {
            heart2.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//coravacio.png"));
        }
        if (hp == 3) {
            heart1.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//medioCora.png"));
            heart2.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//coravacio.png"));
        }
        if (hp == 2) {
            heart1.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//coravacio.png"));
        }
        if (hp == 1) {
            heart1.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//coravacio.png"));
            heart0.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//medioCora.png"));
        }
        if (hp == 0) {
            heart0.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//coravacio.png"));
            heart1.setIcon(new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//coravacio.png"));
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
}
