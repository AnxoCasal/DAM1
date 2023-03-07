package anxo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class FormBoletin6 extends JFrame implements ActionListener {

    JLabel lblResult;
    JTextArea num1;
    JTextArea num2;
    JButton suma;
    JButton division;
    JButton raiz;
    Double resultado = 0.0;

    public FormBoletin6() {

        super("Calculadora");
        this.setLayout(null);

        suma = new JButton("Suma");
        suma.setSize(80, 50);
        suma.setLocation(20, 20);
        suma.addActionListener(this);
        this.add(suma);

        division = new JButton("Division");
        division.setSize(80, 50);
        division.setLocation(120, 20);
        division.addActionListener(this);
        this.add(division);

        raiz = new JButton("Raiz");
        raiz.setSize(80, 50);
        raiz.setLocation(220, 20);
        raiz.addActionListener(this);
        this.add(raiz);

        num1 = new JTextArea();
        num1.setSize(50, 20);
        num1.setLocation(20, 125);
        num1.setBackground(Color.yellow);
        this.add(num1);

        num2 = new JTextArea();
        num2.setSize(50, 20);
        num2.setLocation(90, 125);
        num2.setBackground(Color.yellow);
        this.add(num2);

        lblResult = new JLabel("El resultado es = " + resultado);
        lblResult.setSize(200, 50);
        lblResult.setLocation(160, 110);
        this.add(lblResult);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            
            lblResult.setForeground(Color.black);

            if (e.getSource() == suma) {
                double suma1 = Double.parseDouble(num1.getText());
                Double suma2 = Double.parseDouble(num2.getText());
                lblResult.setText(String.format("El resultado es = %.3f",suma1+suma2));
            }

            if (e.getSource() == division) {
                Double suma1 = Double.parseDouble(num1.getText());
                Double suma2 = Double.parseDouble(num2.getText());
                if(suma2 == 0){
                    throw new SoloPositivos();
                }
                lblResult.setText(String.format("El resultado es = %.3f",suma1/suma2));
            }

            if (e.getSource() == raiz) {
                Double suma1 = Double.parseDouble(num1.getText());
                if(suma1 < 0){
                    throw new SoloPositivos();
                }
                suma1=Math.sqrt(suma1);
                lblResult.setText(String.format("El resultado es = %.3f",suma1));
            }

        } catch (NumberFormatException exception) {
            
            lblResult.setForeground(Color.red);
            lblResult.setText("ERROR 404");

        } catch (SoloPositivos exception){
            
            lblResult.setForeground(Color.red);
            lblResult.setText("ERROR 404");

        }

    }
}
