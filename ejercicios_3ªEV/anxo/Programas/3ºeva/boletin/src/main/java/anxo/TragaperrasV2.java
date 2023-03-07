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

public class TragaperrasV2 extends JFrame implements ActionListener {

    JLabel credito;
    JLabel resultado;
    JLabel marca1;
    JLabel marca2;
    JLabel marca3;
    JButton jugar;
    Timer crono;
    Timer crono2;
    double coins = 3;
    String titulo = "Super_mini_tragaperras         ";
    int i = 0;
    Boolean color = true;
    String cadena = "";
    Boolean win = false;

    public TragaperrasV2() {

        this.setLayout(null);

        marca1 = new JLabel();
        marca1.setSize(256, 256);
        marca1.setLocation(140, 140);
        marca1.setIcon(new ImageIcon("C:/Users/Anxo/Documents/Programas/Mario/0.png"));
        this.add(marca1);

        marca2 = new JLabel();
        marca2.setSize(256, 256);
        marca2.setLocation(446, 140);
        marca2.setIcon(new ImageIcon("C:/Users/Anxo/Documents/Programas/Mario/0.png"));
        this.add(marca2);

        marca3 = new JLabel();
        marca3.setSize(256, 256);
        marca3.setLocation(742, 140);
        marca3.setIcon(new ImageIcon("C:/Users/Anxo/Documents/Programas/Mario/0.png"));
        this.add(marca3);

        jugar = new JButton();
        jugar.setSize(770, 160);
        jugar.setLocation(192, 440);
        jugar.setIcon(new ImageIcon("C:/Users/Anxo/Documents/Programas/Mario/boton.png"));
        jugar.addActionListener(this);
        this.add(jugar);

        resultado = new JLabel("LETS PLAY!!");
        resultado.setSize(400, 203);
        resultado.setLocation(150, 640);
        resultado.setFont(new Font("Serif", 1, 62));
        resultado.setForeground(Color.yellow);
        this.add(resultado);

        credito = new JLabel("     " + coins);
        credito.setSize(400, 203);
        credito.setLocation(670, 640);
        credito.setIcon(new ImageIcon("C:/Users/Anxo/Documents/Programas/Mario/coin.png"));
        credito.setFont(new Font("Serif", 1, 62));
        credito.setForeground(Color.yellow);
        this.add(credito);

        crono = new Timer(200, this);
        crono.start();

        crono2 = new Timer(400, this);
        crono2.start();

        getContentPane().setBackground(Color.PINK);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == jugar) {

                coins--;

                int opt1 = (int) (Math.random() * 6 + 1);
                int opt2 = (int) (Math.random() * 6 + 1);
                int opt3 = (int) (Math.random() * 6 + 1);

                marca1.setIcon(new ImageIcon("C:/Users/Anxo/Documents/Programas/Mario/" + opt1 + ".png"));

                marca2.setIcon(new ImageIcon("C:/Users/Anxo/Documents/Programas/Mario/" + opt2 + ".png"));

                marca3.setIcon(new ImageIcon("C:/Users/Anxo/Documents/Programas/Mario/" + opt3 + ".png"));

                if (opt1 == opt2 && opt2 == opt3) {

                    coins = coins + 5;
                    credito.setText("     " + coins);
                    resultado.setText("YOU WIN 5");
                    resultado.setForeground(Color.green);
                    win = true;

                } else if (opt1 == opt2 || opt2 == opt3 || opt1 == opt3) {

                    coins = coins + 1.5;
                    credito.setText("     " + coins);
                    resultado.setText("YOU WIN 1.5");
                    resultado.setForeground(Color.green);
                    win = true;

                } else {

                    resultado.setText("YOU LOSE ;(");
                    resultado.setForeground(Color.red);
                    win = false;

                }

                credito.setText("     " + coins);

            }

            if (e.getSource() == crono) {

                cadena = titulo.substring(0, i);
                this.setTitle(cadena);

                if (i == titulo.length()) {
                    this.setTitle("");
                    i = 0;
                }

                i++;

            }

            if (e.getSource() == crono2) {

                color = !color;

                if (win) {
                    if (color) {

                        resultado.setForeground(Color.yellow);

                    } else {

                        resultado.setForeground(Color.green);

                    }
                }

            }

            if (coins < 1) {
                jugar.removeActionListener(this);
                marca1.setIcon(new ImageIcon("C:/Users/Anxo/Documents/Programas/Mario/lose.png"));
                marca2.setIcon(new ImageIcon("C:/Users/Anxo/Documents/Programas/Mario/lose.png"));
                marca3.setIcon(new ImageIcon("C:/Users/Anxo/Documents/Programas/Mario/lose.png"));
                getContentPane().setBackground(Color.black);
                resultado.setText("GAME OVER");
            }

        } catch (StringIndexOutOfBoundsException exception) {
            crono.stop();
        }

    }

}
