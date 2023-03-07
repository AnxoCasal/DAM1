package anxo.tests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class form1 extends JFrame implements ActionListener {

    JButton boton;
    int x, y;

    public form1() {

        super("Escapa raton");
        this.setLayout(null);

        boton = new JButton("¡¡CLICKAME!!");
        boton.setSize(150, 50);
        boton.setLocation(200, 200);
        boton.addActionListener(this);
        boton.addMouseListener(new MouseHandler());
        add(boton);
    }

    private class MouseHandler implements MouseListener {

        @Override
        public void mouseEntered(MouseEvent e) {
            x = (int) (Math.random() * 350 + 0);
            y = (int) (Math.random() * 450 + 0);
            boton.setLocation(x, y);

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        JOptionPane.showMessageDialog(null, "ME PILLASTE!");

    }

}
