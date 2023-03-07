package anxo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FormBoletin3 extends JFrame implements ActionListener, ItemListener {

    JTextField txtNum1, txtNum2;
    JButton btnOperar;
    JRadioButton rdbSumar, rdbRestar, rdbMultiplicar, rdbDividir;
    JLabel lblSimbolo, lblResultado, lblDecimales, lblError;
    ButtonGroup grupoSimbolo;
    JComboBox boxDecimales;
    int opt = 0, cantDecimales;
    double result;
    boolean salir;
    float num1, num2;
    String[] simbolos = { "+", "-", "*", "/" };
    String[] decimales = { "0", "1", "2", "3", "4", "5" };

    public FormBoletin3() {

        super("Calculadora");
        setLayout(null);

        txtNum1 = new JTextField("" + num1);
        txtNum1.setSize(50, 20);
        txtNum1.setLocation(80, 50);
        add(txtNum1);

        txtNum2 = new JTextField("" + num2);
        txtNum2.setSize(50, 20);
        txtNum2.setLocation(180, 50);
        add(txtNum2);

        btnOperar = new JButton("Ejecutar");
        btnOperar.setSize(100, 50);
        btnOperar.setLocation(190, 200);
        btnOperar.addActionListener(this);
        add(btnOperar);

        lblError = new JLabel("");
        lblError.setSize(80, 20);
        lblError.setLocation(300, 210);
        lblError.setForeground(Color.red);
        add(lblError);

        rdbSumar = new JRadioButton("Sumar");
        rdbSumar.setSize(80, 20);
        rdbSumar.setLocation(20, 120);
        rdbSumar.setSelected(true);
        rdbSumar.addItemListener(this);
        add(rdbSumar);

        rdbRestar = new JRadioButton("Restar");
        rdbRestar.setSize(80, 20);
        rdbRestar.setLocation(110, 120);
        rdbRestar.addItemListener(this);
        add(rdbRestar);

        rdbMultiplicar = new JRadioButton("Multiplicar");
        rdbMultiplicar.setSize(90, 20);
        rdbMultiplicar.setLocation(200, 120);
        rdbMultiplicar.addItemListener(this);
        add(rdbMultiplicar);

        rdbDividir = new JRadioButton("Dividir");
        rdbDividir.setSize(80, 20);
        rdbDividir.setLocation(290, 120);
        rdbDividir.addItemListener(this);
        add(rdbDividir);

        lblSimbolo = new JLabel("+");
        lblSimbolo.setSize(20, 20);
        lblSimbolo.setLocation(150, 50);
        add(lblSimbolo);

        lblResultado = new JLabel("= ");
        lblResultado.setSize(80, 20);
        lblResultado.setLocation(240, 50);
        add(lblResultado);

        grupoSimbolo = new ButtonGroup();
        grupoSimbolo.add(rdbSumar);
        grupoSimbolo.add(rdbRestar);
        grupoSimbolo.add(rdbMultiplicar);
        grupoSimbolo.add(rdbDividir);

        lblDecimales = new JLabel("Nº decimales");
        lblDecimales.setSize(80, 20);
        lblDecimales.setLocation(100, 200);
        add(lblDecimales);

        boxDecimales = new JComboBox<String>(decimales);
        boxDecimales.setSize(50, 20);
        boxDecimales.setLocation(110, 225);
        boxDecimales.addItemListener(this);
        add(boxDecimales);

        this.addWindowListener(new windowHandler());

        String home = System.getProperty("user.home");

        try (Scanner f = new Scanner(new File(home + "//Documents//numeros.txt"))) {
            num1 = Float.parseFloat(f.nextLine());
            num2 = Float.parseFloat(f.nextLine());
            opt = Integer.parseInt(f.nextLine());
            txtNum1.setText("" + num1);
            txtNum2.setText("" + num2);
            if (opt == 0) {
                rdbSumar.setSelected(true);
            } else if (opt == 1) {
                rdbRestar.setSelected(true);
            } else if (opt == 2) {
                rdbMultiplicar.setSelected(true);
            } else if (opt == 3) {
                rdbDividir.setSelected(true);
            }

        } catch (Exception e) {
            System.out.println("ERROR DE ACCESO DE ARCHIVO");
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getSource() == rdbSumar) {
            opt = 0;
        } else if (e.getSource() == rdbRestar) {
            opt = 1;
        } else if (e.getSource() == rdbMultiplicar) {
            opt = 2;
        } else if (e.getSource() == rdbDividir) {
            opt = 3;
        } else if (e.getSource() == boxDecimales) {
            cantDecimales = boxDecimales.getSelectedIndex();
            lblResultado.setText(String.format("=\t %." + cantDecimales + "f", result));
        }
        lblSimbolo.setText(simbolos[opt]);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            lblError.setText("");
            num1 = Float.parseFloat(txtNum1.getText());
            num2 = Float.parseFloat(txtNum2.getText());
            if (opt == 0) {
                result = num1 + num2;
            } else if (opt == 1) {
                result = num1 - num2;
            } else if (opt == 2) {
                result = num1 * num2;
            } else if (opt == 3) {
                if (num2 == 0) {
                    lblError.setText("Math Error");
                    salir = false;
                } else {
                    result = num1 / num2;
                }
            }

            if (!salir) {
                lblResultado.setText(String.format("=\t %." + cantDecimales + "f", result));
            }

        } catch (java.lang.NumberFormatException exception) {
            lblError.setText("Syntax Error");
        }
    }

    private class windowHandler extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            String home = System.getProperty("user.home");
            try (PrintWriter f2 = new PrintWriter(
                    new FileWriter(home + "//Documents//numeros.txt", false))) {
                f2.println(num1);
                f2.println(num2);
                f2.println(opt);
            } catch (IOException exception) {
                System.out.println("ERROR DE ACCESO AL ARCHIVO");
            }
        }

    }
}
