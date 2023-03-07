package anxo;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FormBoletin1 extends JFrame {

    JLabel teclas;
    JButton btn1, btn2, modulo;
    boolean secundario = true;
    JFrame jFrame;
    String titulo = "EVENTOS DE RATON AQUI";
    Color color = Color.red;
    

    public FormBoletin1() {
        super("EVENTOS DE RATON AQUI");
        setLayout(null);

        btn1 = new JButton("IZQUIERDO");
        btn1.setSize(200, 50);
        btn1.setLocation(50, 150);
        add(btn1);

        teclas = new JLabel("Teclas");
        teclas.setSize(200, 50);
        teclas.setLocation(300, 150);
        add(teclas);

        btn2 = new JButton("DERECHO");
        btn2.setSize(200, 50);
        btn2.setLocation(400, 150);
        add(btn2);

        jFrame = this;
        getContentPane().setFocusable(true);    
        btn1.addMouseMotionListener(new MouseHandler());
        btn2.addMouseMotionListener(new MouseHandler());
        btn1.addKeyListener(new KeyHandler());
        btn2.addKeyListener(new KeyHandler());
        getContentPane().addMouseListener(new MouseHandler());
        getContentPane().addMouseMotionListener(new MouseHandler());
        getContentPane().addKeyListener(new KeyHandler());
        addWindowListener(new windowHandler());

    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseMoved(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if (e.getSource() == getContentPane()) {
                jFrame.setTitle("Coordenadas del raton: X-" + x + "   Y-" + y);
            } else {
                jFrame.setTitle("Coordenadas del raton: X-" + (x + ((JButton) e.getSource()).getX()) + "   Y-" + (y + ((JButton) e.getSource()).getY()));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            jFrame.setTitle(titulo);
        }

        @Override
        public void mousePressed(MouseEvent e) {

            if (e.getButton() == MouseEvent.BUTTON1) {
                btn1.setBackground(color);
            }

            if (e.getButton() == MouseEvent.BUTTON3) {
                btn2.setBackground(color);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                btn1.setBackground(null);
            }

            if (e.getButton() == MouseEvent.BUTTON3) {
                btn2.setBackground(null);
            }
        }

    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            teclas.setText(e.getKeyCode() + "  =  " + e.getKeyChar());

            if (e.isControlDown() && e.getKeyCode() == 67 && secundario) {
                Form2Boletin1 f = new Form2Boletin1(FormBoletin1.this);
                f.setSize(300, 300);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationRelativeTo(null);
                f.setVisible(true);

                secundario = !secundario;
            }
        }
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
