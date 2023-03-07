package anxo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FormColores extends JFrame implements ActionListener {

    JButton amarillo;
    JButton azul;
    JButton aleatorio;

    public FormColores() {

        super("Colores!!");
        this.setLayout(null);

        azul = new JButton("Azul");
        azul.setSize(150, 50);
        azul.setLocation(175, 190);
        azul.addActionListener(this);
        azul.setBackground(Color.GRAY);
        azul.setForeground(Color.blue);
        this.add(azul);

        amarillo = new JButton("Amarillo");
        amarillo.setSize(150, 50);
        amarillo.setLocation(175, 260);
        amarillo.addActionListener(this);
        amarillo.setBackground(Color.gray);
        amarillo.setForeground(Color.yellow);
        this.add(amarillo);

        aleatorio = new JButton("Aleatorio");
        aleatorio.setSize(150, 50);
        aleatorio.setLocation(175, 120);
        aleatorio.addActionListener(this);
        this.add(aleatorio);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == azul) {
            getContentPane().setBackground(Color.blue);
        }

        if (evento.getSource() == amarillo) {
            getContentPane().setBackground(Color.yellow);
        }

        if (evento.getSource() == aleatorio) {
            int rnd = (int) (Math.random() * 600 + 1);
            int rnd2 = (int) (Math.random() * 400 + 1);
            if ((evento.getModifiers() & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK) {
                aleatorio.setLocation(rnd - 100, rnd2 + 100);
                if (rnd - 100 >= 450 || rnd2 + 100 >= 450) {
                    JOptionPane.showMessageDialog(null, "Has perdido el boton");
                }
            } else {
                this.setLocation(rnd, rnd2);
            }
        }

    }
}