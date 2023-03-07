package anxo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FormBoletin2 extends JFrame implements ActionListener {
    JButton btn;
    JButton introbtn;
    JTextField intro;
    JLabel resultado;
    JLabel limite;
    JLabel dado;
    int num;
    int max;

    public FormBoletin2() {

        super("Dado virtual");
        this.setLayout(null);
        num = 0;
        max = 6;

        btn = new JButton("¡¡Lanzar dado!!");
        btn.setSize(150, 50);
        btn.setLocation(20, 25);
        btn.addActionListener(this);
        this.add(btn);

        resultado = new JLabel("El resultado es:  " + num);
        resultado.setSize(150, 50);
        resultado.setLocation(250, 25);
        this.add(resultado);

        limite = new JLabel("Introduce el máximo de tu nuevo dado");
        limite.setSize(250, 50);
        limite.setLocation(75, 75);
        this.add(limite);

        intro = new JTextField("");
        intro.setSize(30, 30);
        intro.setLocation(50, 135);
        this.add(intro);

        introbtn = new JButton("Enviar");
        introbtn.setSize(100, 50);
        introbtn.setLocation(110, 125);
        introbtn.addActionListener(this);
        this.add(introbtn);

        dado = new JLabel("Dado actual = " + max);
        dado.setSize(150, 50);
        dado.setLocation(230, 125);
        this.add(dado);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == btn) {
            num = (int) (Math.random() * max + 1);
            resultado.setText(String.format("El resultado es: %2d", num));
        }

        try {
            if (evento.getSource() == introbtn) {
                max = Integer.parseInt(intro.getText());
                if (max<1){
                    throw new SoloPositivos();
                }
                dado.setText(String.format("Dado actual = %2d", max));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Caracter no valido");
        } catch (SoloPositivos e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
