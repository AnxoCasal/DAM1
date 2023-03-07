package anxo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FormBoletin4 extends JFrame implements ActionListener, ItemListener {

    JComboBox cbA, cbB;
    JButton btnAñadir, btnQuitar, btnTraspasar1, btnTraspasar2;
    JTextField text1, text2;
    JLabel lblCantcbA, lblIndicecbA;
    String[] elementosA = {};
    String[] elementosB = {};

    public FormBoletin4() {

        super("Listas");
        setLayout(null);

        cbA = new JComboBox<String>(elementosA);
        cbA.setSize(100, 20);
        cbA.setLocation(130, 50);
        cbA.addItemListener(this);
        add(cbA);

        cbB = new JComboBox<String>(elementosB);
        cbB.setSize(100, 20);
        cbB.setLocation(270, 50);
        cbB.addItemListener(this);
        add(cbB);

        btnAñadir = new JButton("Añadir");
        btnAñadir.setSize(100, 20);
        btnAñadir.setLocation(130, 150);
        btnAñadir.addActionListener(this);
        add(btnAñadir);

        btnQuitar = new JButton("Quitar");
        btnQuitar.setSize(100, 20);
        btnQuitar.setLocation(270, 150);
        btnQuitar.addActionListener(this);
        add(btnQuitar);

        btnTraspasar1 = new JButton("Traspasar A=>B");
        btnTraspasar1.setSize(130, 20);
        btnTraspasar1.setLocation(100, 200);
        btnTraspasar1.addActionListener(this);
        add(btnTraspasar1);

        btnTraspasar2 = new JButton("Traspasar B=>A");
        btnTraspasar2.setSize(130, 20);
        btnTraspasar2.setLocation(270, 200);
        btnTraspasar2.addActionListener(this);
        add(btnTraspasar2);

        text1 = new JTextField();
        text1.setSize(200, 30);
        text1.setLocation(150, 250);
        text1.addActionListener(this);
        add(text1);

        text2 = new JTextField();
        text2.setSize(200, 30);
        text2.setLocation(150, 300);
        text2.addActionListener(this);
        add(text2);

        lblCantcbA = new JLabel("Hay " + cbA.getItemCount() + " elementos");
        lblCantcbA.setSize(200, 30);
        lblCantcbA.setLocation(150, 350);
        add(lblCantcbA);

        lblIndicecbA = new JLabel("Indice: " + cbA.getSelectedIndex());
        lblIndicecbA.setSize(200, 30);
        lblIndicecbA.setLocation(150, 400);
        add(lblIndicecbA);

        addWindowListener(new windowHandler());
        btnQuitar.addMouseListener(new mouseHandler());

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        lblIndicecbA.setText("Indice: " + cbA.getSelectedIndex());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnQuitar && cbA.getItemAt(cbA.getSelectedIndex()) != null) {
            cbA.removeItemAt(cbA.getSelectedIndex());
            lblCantcbA.setText("Hay " + cbA.getItemCount() + " elementos");

        } else if (e.getSource() == btnTraspasar1 && cbA.getItemAt(cbA.getSelectedIndex()) != null) {
            cbB.addItem(cbA.getSelectedItem());
            cbA.removeItemAt(cbA.getSelectedIndex());
            lblCantcbA.setText("Hay " + cbA.getItemCount() + " elementos");

        } else if (e.getSource() == btnTraspasar2 && cbB.getItemAt(cbB.getSelectedIndex()) != null) {
            cbA.addItem(cbB.getSelectedItem());
            cbB.removeItemAt(cbB.getSelectedIndex());
            lblCantcbA.setText("Hay " + cbA.getItemCount() + " elementos");

        } else if (e.getSource() == text2 && cbA.getItemAt(cbA.getSelectedIndex()) != null) {

            for (int i = 0; i < cbA.getItemCount(); i++) {
                if (cbA.getItemAt(i).toString().startsWith(text2.getText())) {
                    cbA.removeItemAt(i);
                }
            }
            lblCantcbA.setText("Hay " + cbA.getItemCount() + " elementos");

        } else if (e.getSource() == btnAñadir || e.getSource() == text1) {

            String[] nuevos = text1.getText().split(";");

            for (String uno : nuevos) {
                if (uno.length() == 0) {
                } else if (uno.startsWith(" ")) {
                    for (int i = 0; i < uno.length() - 1; i++) {
                        if (uno.charAt(i) != uno.charAt(i + 1)) {
                            cbA.addItem(uno);
                            i = uno.length();
                        }
                    }
                } else {
                    cbA.addItem(uno);
                }
            }
            lblCantcbA.setText("Hay " + cbA.getItemCount() + " elementos");

        }
    }

    private class mouseHandler extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            btnQuitar.setForeground(Color.red);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            btnQuitar.setForeground(null);
        }

    }

    private class windowHandler extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            int opt = JOptionPane.showConfirmDialog(null, "¿Quieres salir de la aplicacion?", "Salir",
                    JOptionPane.YES_OPTION, 1);

            if (opt == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

    }

}
