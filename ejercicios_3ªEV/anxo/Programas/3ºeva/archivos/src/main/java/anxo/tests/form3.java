package anxo.tests;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class form3 extends JFrame implements ActionListener {

    JButton boton;
    int x, y, r, g, b;

    public form3() {

        super("Escapa raton");
        this.setLayout(null);
        this.setFocusable(true);

        boton = new JButton("¡¡CLICKAME!!");
        boton.setSize(150, 50);
        boton.setLocation(200, 200);
        boton.addActionListener(this);
        boton.addMouseListener(new MouseHandler());
        add(boton);

        addKeyListener(new KeyboardHandler());
        addWindowListener(new windowHandler());
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            x = (int) (Math.random() * 350 + 0);
            y = (int) (Math.random() * 450 + 0);
            boton.setLocation(x, y);
            r = (int) (Math.random() * 255 + 0);
            g = (int) (Math.random() * 255 + 0);
            b = (int) (Math.random() * 255 + 0);
            boton.setBackground(new Color(r, g, b));

        }

    }

    private class KeyboardHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                x = (int) (Math.random() * 350 + 0);
                y = (int) (Math.random() * 450 + 0);
                boton.setLocation(x, y);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(null, "ME PILLASTE!");

    }

    private class windowHandler extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {

            int close = JOptionPane.showConfirmDialog(null, "¿Desea cerrar la aplicacion?", null,
                    JOptionPane.YES_OPTION);

            if (close == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

    }
}