package anxo.tests;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class form2 extends JFrame implements ActionListener {

    JButton boton;
    int x, y, r, g, b;

    public form2() {

        super("Escapa raton");
        this.setLayout(null);

        boton = new JButton("¡¡CLICKAME!!");
        boton.setSize(150, 50);
        boton.setLocation(200, 200);
        boton.addActionListener(this);
        boton.addMouseListener(new MouseHandler());
        add(boton);
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

    @Override
    public void actionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(null, "ME PILLASTE!");

    }

}
