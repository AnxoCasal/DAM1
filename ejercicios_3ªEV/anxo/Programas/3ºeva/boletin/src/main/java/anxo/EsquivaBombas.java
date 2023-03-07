package anxo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class EsquivaBombas extends JFrame implements ActionListener {

    JLabel LBLmuro;
    JButton BTNInicio;
    JLabel LBLpj;
    JLabel LBLbomb1;
    JLabel LBLbomb2;
    JLabel LBLbomb3;
    JLabel[] bombas = new JLabel[3];
    int hp = 3;
    JLabel LBLcorazon;
    JLabel HPleft;
    JButton BTNleft;
    JButton BTNright;
    Timer crono;
    int ds;
    int incremento = 10;
    boolean inicio[] = new boolean[3];
    int xRNG[] = new int[3];
    JLabel reloj;
    JLabel gameover;

    public EsquivaBombas() {

        super("BOMBERMAN");
        this.setLayout(null);
        getContentPane().setBackground(Color.white);

        bombas[0] = new JLabel();
        bombas[0].setSize(64, 64);
        bombas[0].setIcon(new ImageIcon("C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//Bomb.png"));
        bombas[0].setLocation(550, 0);
        this.add(bombas[0]);

        inicio[0] = true;

        BTNInicio = new JButton();
        BTNInicio.setSize(434, 90);
        BTNInicio.setLocation(30, 200);
        BTNInicio.setIcon(new ImageIcon("C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//newgame.PNG"));
        BTNInicio.addActionListener(this);
        this.add(BTNInicio);

        LBLpj = new JLabel();
        LBLpj.setSize(64, 64);
        LBLpj.setLocation(218, 450);
        LBLpj.setIcon(new ImageIcon("C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//Man.PNG"));
        this.add(LBLpj);

        LBLcorazon = new JLabel();
        LBLcorazon.setSize(64, 64);
        LBLcorazon.setLocation(215, 625);
        LBLcorazon.setIcon(new ImageIcon("C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//hp.PNG"));
        this.add(LBLcorazon);

        HPleft = new JLabel("" + hp);
        HPleft.setSize(32, 64);
        HPleft.setFont(new Font("Serif", 1, 31));
        HPleft.setLocation(240, 680);
        this.add(HPleft);

        reloj = new JLabel("Points " + ds);
        reloj.setSize(200, 50);
        reloj.setLocation(200, 0);
        reloj.setFont(new Font("Serif", 1, 31));
        this.add(reloj);

        gameover = new JLabel();
        gameover.setSize(500, 281);
        gameover.setIcon(new ImageIcon("C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//lose.jpg"));
        gameover.setLocation(0, 100);
        gameover.setVisible(false);
        this.add(gameover);

        LBLbomb1 = new JLabel();
        LBLbomb1.setSize(64, 64);
        LBLbomb1.setLocation(134, 50);
        LBLbomb1.setIcon(new ImageIcon("C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//Bomb.PNG"));
        this.add(LBLbomb1);

        LBLbomb2 = new JLabel();
        LBLbomb2.setSize(64, 64);
        LBLbomb2.setLocation(218, 50);
        LBLbomb2.setIcon(new ImageIcon("C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//Bomb.PNG"));
        this.add(LBLbomb2);

        LBLbomb3 = new JLabel();
        LBLbomb3.setSize(64, 64);
        LBLbomb3.setLocation(302, 50);
        LBLbomb3.setIcon(new ImageIcon("C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//Bomb.PNG"));
        this.add(LBLbomb3);

        BTNleft = new JButton();
        BTNleft.setSize(150, 96);
        BTNleft.setLocation(30, 630);
        BTNleft.setIcon(new ImageIcon("C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//manoizquierda.PNG"));
        BTNleft.addActionListener(this);
        this.add(BTNleft);

        BTNright = new JButton();
        BTNright.setSize(150, 96);
        BTNright.setLocation(310, 630);
        BTNright.setIcon(new ImageIcon("C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//manoderecha.png"));
        BTNright.addActionListener(this);
        this.add(BTNright);

        LBLmuro = new JLabel();
        LBLmuro.setSize(500, 800);
        LBLmuro.setLocation(0, 0);
        LBLmuro.setIcon(new
        ImageIcon("C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//wall.png"));
       // this.add(LBLmuro);

        crono = new Timer(100, this);
        doLayout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == BTNInicio) {

            BTNInicio.setVisible(false);
            crono.start();
            LBLbomb1.setLocation(550, 0);
            LBLbomb2.setLocation(550, 0);
            LBLbomb3.setLocation(550, 0);
            BTNInicio.removeActionListener(this);

        }

        if (e.getSource() == BTNright && LBLpj.getX() != 0) {

            LBLpj.setLocation(LBLpj.getX() + 10, 450);

        }

        if (e.getSource() == BTNleft && LBLpj.getX() != 436) {

            LBLpj.setLocation(LBLpj.getX() - 10, 450);

        }

        if (e.getSource() == crono) {

            for (int i = 0; i < bombas.length; i++) {

                if (bombas[i] != null) {

                    if (inicio[i] == true) {

                        xRNG[i] = (int) (Math.random() * 436 + 1);
                        bombas[i].setLocation(xRNG[i], 0);
                        inicio[i] = false;

                    }

                    bombas[i].setLocation(xRNG[i], bombas[i].getY() + incremento);

                    if (bombas[i].getY() >= 545) {
                        inicio[i] = true;
                    }

                    if ((bombas[i].getX() < LBLpj.getX() && bombas[i].getX() > LBLpj.getX() - 64
                            || bombas[i].getX() > LBLpj.getX() && bombas[i].getX() < LBLpj.getX() + 64)
                            && (bombas[i].getY() < LBLpj.getY() && bombas[i].getY() > LBLpj.getY() - 64
                                    || bombas[i].getY() > LBLpj.getY() && bombas[i].getY() < LBLpj.getY() + 64)) {

                        hp--;
                        HPleft.setText("" + hp);
                        inicio[i] = true;

                        if (hp == 0) {

                            crono.stop();
                            BTNleft.removeActionListener(this);
                            BTNright.removeActionListener(this);
                            LBLpj.setIcon(new ImageIcon("C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//anxo/img/explosion.PNG"));
                            bombas[i]
                                    .setIcon(new ImageIcon("C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//explosion.PNG"));
                            gameover.setVisible(true);

                        }
                    }

                }
            }

            ds++;

            if (ds == 30) {

                bombas[1] = new JLabel();
                bombas[1].setSize(64, 64);
                bombas[1].setIcon(new ImageIcon("C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//bomb.PNG"));
                bombas[1].setLocation(550, 0);
                this.add(bombas[1]);

                inicio[1] = true;

            }

            if (ds == 150) {

                bombas[2] = new JLabel();
                bombas[2].setSize(64, 64);
                bombas[2].setIcon(new ImageIcon("C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//bomb.PNG"));
                bombas[2].setLocation(550, 0);
                this.add(bombas[2]);

                inicio[2] = true;

            }

            if (ds == 100) {

                incremento = 15;

            }

            if (ds == 200) {

                incremento = 20;

            }

            if (ds == 300) {

                incremento = 25;

            }

            reloj.setText("Points " + ds / 10);

        }

    }

}
