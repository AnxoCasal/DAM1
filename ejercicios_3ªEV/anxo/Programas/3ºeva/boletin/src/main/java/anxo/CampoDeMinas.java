package anxo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CampoDeMinas extends JFrame implements ActionListener {

    JButton BTNInicio;
    JLabel LBLFondo;
    JLabel LBLcerca;
    JLabel LBLbomba;
    JLabel LBLplayer;
    JLabel[] Minas = new JLabel[9];
    JButton UpArrow;
    JButton DownArrow;
    JButton LeftArrow;
    JButton RightArrow;
    int bombas = 0;

    public CampoDeMinas() {

        super("Campo de minas");
        this.setLayout(null);
        getContentPane().setBackground(Color.white);

        LBLplayer = new JLabel();
        LBLplayer.setSize(150, 150);
        LBLplayer.setLocation(0, 0);
        LBLplayer.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//shyguy.png"));
        this.add(LBLplayer);

        LBLFondo = new JLabel();
        LBLFondo.setSize(900, 900);
        LBLFondo.setLocation(0, 0);
        LBLFondo.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//cuadricula.png"));
        this.add(LBLFondo);

        LBLcerca = new JLabel("Bombas cerca = " + bombas);
        LBLcerca.setSize(300, 70);
        LBLcerca.setLocation(1050, 100);
        LBLcerca.setFont(new Font("Serif", 1, 32));
        this.add(LBLcerca);

        LBLbomba = new JLabel("");
        LBLbomba.setSize(64, 64);
        LBLbomba.setLocation(950, 100);
        LBLbomba.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//imgbomb2.png"));
        this.add(LBLbomba);

        BTNInicio = new JButton();
        BTNInicio.setSize(434, 90);
        BTNInicio.setLocation(930, 220);
        BTNInicio.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//newgame.png"));
        BTNInicio.addActionListener(this);
        this.add(BTNInicio);

        UpArrow = new JButton();
        UpArrow.setSize(128, 128);
        UpArrow.setLocation(1100, 400);
        UpArrow.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//uparrow.png"));
        this.add(UpArrow);

        LeftArrow = new JButton();
        LeftArrow.setSize(128, 128);
        LeftArrow.setLocation(950, 550);
        LeftArrow.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//leftarrow.png"));
        this.add(LeftArrow);

        RightArrow = new JButton();
        RightArrow.setSize(128, 128);
        RightArrow.setLocation(1240, 550);
        RightArrow.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//rightarrow.png"));
        this.add(RightArrow);

        DownArrow = new JButton();
        DownArrow.setSize(128, 128);
        DownArrow.setLocation(1100, 700);
        DownArrow.setIcon(new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//downarrow.png"));
        this.add(DownArrow);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == BTNInicio) {
            UpArrow.addActionListener(this);
            LeftArrow.addActionListener(this);
            RightArrow.addActionListener(this);
            DownArrow.addActionListener(this);
            BTNInicio.setVisible(false);
            BTNInicio.removeActionListener(this);

            for (int i = 0; i < Minas.length; i++) {
                int columna = ((int) (Math.random() * 6 + 0) * 150);
                int fila = ((int) (Math.random() * 6 + 1)) * 150;
                for (int cont = 0; cont < i; cont++) {
                    if (columna == Minas[cont].getX() && fila == Minas[cont].getY() || columna == 750 && fila == 750) {
                        do {
                            columna = ((int) (Math.random() * 6 + 0) * 150);
                            fila = ((int) (Math.random() * 6 + 1)) * 150;
                        } while (columna == Minas[cont].getX() && fila == Minas[cont].getY());
                    }
                }
                Minas[i] = new JLabel();
                Minas[i].setSize(150, 150);
                Minas[i].setLocation(columna, fila);
                this.add(Minas[i]);

                System.err.println(columna / 150 + "   " + fila / 150);
            }

        }

        if (e.getSource() == UpArrow && LBLplayer.getY() != 0) {
            LBLplayer.setLocation(LBLplayer.getX(), LBLplayer.getY() - 150);
        }

        if (e.getSource() == LeftArrow && LBLplayer.getX() != 0) {
            LBLplayer.setLocation(LBLplayer.getX() - 150, LBLplayer.getY());
        }

        if (e.getSource() == RightArrow && LBLplayer.getX() != 750) {
            LBLplayer.setLocation(LBLplayer.getX() + 150, LBLplayer.getY());
        }

        if (e.getSource() == DownArrow && LBLplayer.getY() != 750) {
            LBLplayer.setLocation(LBLplayer.getX(), LBLplayer.getY() + 150);
        }

        bombas = 0;
        LBLcerca.setText("Bombas cerca = " + bombas);

        for (int cont = 0; cont < Minas.length; cont++) {

            if (LBLplayer.getX() == Minas[cont].getX() && LBLplayer.getY() == Minas[cont].getY()) {
                LBLplayer.setIcon(new ImageIcon(
                        "C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//explosion.jpg"));
                UpArrow.removeActionListener(this);
                LeftArrow.removeActionListener(this);
                RightArrow.removeActionListener(this);
                DownArrow.removeActionListener(this);
                LBLFondo.setVisible(false);
                for (int i = 0; i < Minas.length; i++) {
                    Minas[i].setIcon(new ImageIcon(
                            "C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//mina.png"));
                }
            }

            if (LBLplayer.getX() == Minas[cont].getX() && LBLplayer.getY() == Minas[cont].getY() + 150 ||
                    LBLplayer.getX() == Minas[cont].getX() && LBLplayer.getY() == Minas[cont].getY() - 150 ||
                    LBLplayer.getX() == Minas[cont].getX() + 150 && LBLplayer.getY() == Minas[cont].getY() ||
                    LBLplayer.getX() == Minas[cont].getX() - 150 && LBLplayer.getY() == Minas[cont].getY()) {
                bombas++;
                LBLcerca.setText("Bombas cerca = " + bombas);
            }
        }

        if (LBLplayer.getX() == 750 && LBLplayer.getY() == 750) {

            LBLFondo.setVisible(false);
            for (int i = 0; i < Minas.length; i++) {
                Minas[i].setIcon(new ImageIcon(
                        "C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//mina.png"));
            }
            JOptionPane.showMessageDialog(null, "U WIN!");
            int opt;
            opt = JOptionPane.showConfirmDialog(null,
                    "¿Play AGAIN?", "Elija",
                    JOptionPane.YES_NO_OPTION);
            if (opt == JOptionPane.YES_OPTION) {
                LBLplayer.setIcon(new ImageIcon(
                        "C://Users//Anxo//Documents//Programas//3ºeva//boletin//src//main//java//anxo//img//shyguy.png"));
                LBLFondo.setVisible(true);
                LBLplayer.setLocation(0, 0);
                UpArrow.removeActionListener(this);
                LeftArrow.removeActionListener(this);
                RightArrow.removeActionListener(this);
                DownArrow.removeActionListener(this);
                BTNInicio.setVisible(true);
                BTNInicio.addActionListener(this);
                for (int i = 0; i < Minas.length; i++) {
                    this.remove(Minas[i]);
                }
            } else {
                System.exit(0);
            }
        }
    }

}