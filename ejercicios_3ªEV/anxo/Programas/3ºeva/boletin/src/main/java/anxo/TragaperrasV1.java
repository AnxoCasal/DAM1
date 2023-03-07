package anxo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class TragaperrasV1 extends JFrame implements ActionListener {

    JTextField marca1;
    JTextField marca2;
    JTextField marca3;
    JLabel result;
    JLabel reloj;
    JButton aleatorio;
    Timer crono;
    int cont = 55;
    int min = 0;

    public TragaperrasV1() {

        super();
        this.setLayout(null);

        marca1 = new JTextField();
        marca1.setEditable(false);
        marca1.setSize(20, 20);
        marca1.setLocation(40, 20);
        this.add(marca1);

        marca2 = new JTextField();
        marca2.setEditable(false);
        marca2.setSize(20, 20);
        marca2.setLocation(80, 20);
        this.add(marca2);

        marca3 = new JTextField();
        marca3.setEditable(false);
        marca3.setSize(20, 20);
        marca3.setLocation(120, 20);
        this.add(marca3);

        aleatorio = new JButton("Jugar");
        aleatorio.setSize(80, 20);
        aleatorio.setLocation(50, 60);
        aleatorio.addActionListener(this);
        this.add(aleatorio);

        result = new JLabel("TRY YOUR LUCK!");
        result.setSize(100, 20);
        result.setLocation(40, 100);
        this.add(result);

        reloj = new JLabel("00 : 00");
        reloj.setSize(80, 20);
        reloj.setLocation(70, 130);
        this.add(reloj);

        crono = new Timer(1000, this);
        crono.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == aleatorio) {

            int num1 = (int) (Math.random() * 3 + 1);
            int num2 = (int) (Math.random() * 3 + 1);
            int num3 = (int) (Math.random() * 3 + 1);

            marca1.setText(String.format("%d", num1));
            marca2.setText(String.format("%d", num2));
            marca3.setText(String.format("%d", num3));

            if (num1 == num2 && num2 == num3) {
                result.setText("YOU WIN!! :D");
                result.setForeground(Color.green);
            } else {
                result.setText("YOU LOSE ;(");
                result.setForeground(Color.red);
            }
        }

        if (e.getSource() == crono) {
            cont++;
            reloj.setText(String.format("%02d : %02d",min,cont));
            if(cont==59){
                cont=-1;
                min++;
            }
        }

    }

}
