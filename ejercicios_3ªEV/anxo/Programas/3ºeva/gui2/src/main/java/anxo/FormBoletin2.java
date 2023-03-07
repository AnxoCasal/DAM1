package anxo;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FormBoletin2 extends JFrame implements ActionListener {

    JButton[] teclas = new JButton[12];
    String[] caracteres = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "#", "0", "*" };
    ArrayList<String> agenda = new ArrayList<String>();
    JButton newtecla, reset;
    JTextField Pantalla;
    JMenuBar mnuPrincipal;
    JMenu mnuArchivo, mnuMovil, mnuOtros;
    JMenuItem mnuGrabar, mnuLeer, mnuReset, mnuSeparador, mnuSalir, mnuInfo;
    int x = 20;
    int y = 200;

    public FormBoletin2() {

        super("BLACK BERRY");
        setLayout(null);

        Pantalla = new JTextField();
        Pantalla.setSize(260, 160);
        Pantalla.setLocation(15, 20);
        Pantalla.setEditable(false);
        add(Pantalla);

        reset = new JButton("Reset");
        reset.setSize(70, 20);
        reset.setLocation(110, 330);
        reset.addMouseListener(new MouseHandler());
        reset.addActionListener(this);
        add(reset);

        // menu OTROS

        mnuInfo = new JMenuItem("Acerca de...");
        mnuInfo.setMnemonic('A');
        mnuInfo.addActionListener(this);

        mnuOtros = new JMenu("Otros");
        mnuOtros.setMnemonic('A');
        mnuOtros.add(mnuInfo);

        // menu MOVIL

        mnuReset = new JMenuItem("Reset");
        mnuReset.setMnemonic('A');
        mnuReset.addActionListener(this);

        mnuSalir = new JMenuItem("Salir");
        mnuSalir.setMnemonic('G');
        mnuSalir.addActionListener(this);

        mnuMovil = new JMenu("Movil");
        mnuMovil.setMnemonic('A');
        mnuMovil.add(mnuReset);
        mnuMovil.addSeparator();
        mnuMovil.add(mnuSalir);

        // menu ARCHIVO

        mnuGrabar = new JMenuItem("Grabar");
        mnuGrabar.setMnemonic('A');
        mnuGrabar.addActionListener(this);

        mnuLeer = new JMenuItem("Leer");
        mnuLeer.setMnemonic('G');
        mnuLeer.addActionListener(this);

        mnuArchivo = new JMenu("Archivo");
        mnuArchivo.setMnemonic('A');
        mnuArchivo.add(mnuGrabar);
        mnuArchivo.addSeparator();
        mnuArchivo.add(mnuLeer);

        // menu PRINCIPAL

        mnuPrincipal = new JMenuBar();
        mnuPrincipal.add(mnuArchivo);
        mnuPrincipal.add(mnuMovil);
        mnuPrincipal.add(mnuOtros);
        this.setJMenuBar(mnuPrincipal);

        for (int i = 0; i < teclas.length; i++) {

            newtecla = new JButton(caracteres[i].toUpperCase());
            newtecla.setSize(70, 20);
            newtecla.setLocation(x, y);
            newtecla.addActionListener(this);
            newtecla.addKeyListener(new KeyHandler());
            newtecla.addMouseListener(new MouseHandler());
            teclas[i] = newtecla;
            add(newtecla);

            x += 90;

            if (x == 290) {
                x = 20;
                y += 30;
            }

        }

        Pantalla.addKeyListener(new KeyHandler());
        getContentPane().addKeyListener(new KeyHandler());
        reset.addKeyListener(new KeyHandler());

    }

    private class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) { // keychar
            if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == '*' || e.getKeyChar() == '#') {
                Pantalla.setText(Pantalla.getText() + e.getKeyChar());
            }
        }
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            if (((Component) e.getSource()).getBackground() == Color.RED) {

            } else {
                ((Component) e.getSource()).setBackground(Color.CYAN);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (((Component) e.getSource()).getBackground() == Color.RED) {

            } else {
                ((Component) e.getSource()).setBackground(null);
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == reset || e.getSource() == mnuReset) { 

            Pantalla.setText("");
            for (int i = 0; i < teclas.length; i++) {
                teclas[i].setBackground(null);
            }

        } else if (e.getSource().getClass() == JButton.class) {

            if (((Component) e.getSource()).getBackground() == Color.RED) {
                ((Component) e.getSource()).setBackground(null);
            } else {
                ((Component) e.getSource()).setBackground(Color.RED);
            }
            Pantalla.setText(Pantalla.getText() + ((JButton) e.getSource()).getText());
        }

        if (e.getSource() == mnuGrabar) {
            agenda.add(Pantalla.getText());
            JOptionPane.showMessageDialog(null, "Se ah añadido a la agenda");
            Pantalla.setText("");
        }

        if (e.getSource() == mnuLeer) {
            String fullAgenda = "";
            for (int i = 0; i < agenda.size(); i++) {
                fullAgenda = fullAgenda + i + "- " + agenda.get(i) + "\n";
            }
            JOptionPane.showMessageDialog(null, fullAgenda);
        }

        if (e.getSource() == mnuSalir) {

            System.exit(0);

        }

        if (e.getSource() == mnuInfo) {

            JOptionPane.showMessageDialog(null,
                    "PROGRAMA: 'BLackBerry'\n\nDerechos reservados: Anxo Casal Rodriguez\n\nUltima actualizacion 18/05/2022",
                    "INFORMACION", 1);

        }

    }

}
