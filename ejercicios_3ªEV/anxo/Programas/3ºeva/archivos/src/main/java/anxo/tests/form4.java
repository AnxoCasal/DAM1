package anxo.tests;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class form4 extends JFrame {

    private String[] numeros = new String[101];

    public form4() {

        super();
        setLayout(null);

        int x = 10;
        int y = 10;

        for (int i = 1; i < numeros.length; i++) {
            numeros[i] = "" + i;

            JButton etiqueta = new JButton(numeros[i]);
            etiqueta.setSize(55, 30);
            etiqueta.setLocation(x, y);
            etiqueta.addMouseListener(new MouseHandler());
            etiqueta.setFont(new Font("sheriff", 1, 16));

            add(etiqueta);

            if ((i) % 20 == 0) {
                x = 10;
                y += 40;
            } else {
                x += 75;
            }

            System.out.println(y);
        }
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {

            ((Component) e.getSource()).setBackground(Color.red);

        }

        @Override
        public void mouseExited(MouseEvent e) {

            ((Component) e.getSource()).setBackground(null);

        }

    }

}
