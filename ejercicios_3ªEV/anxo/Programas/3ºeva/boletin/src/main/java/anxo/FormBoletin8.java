package anxo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FormBoletin8 extends JFrame implements ActionListener {

    JTextField color1;
    JTextField color2;
    JTextField color3;
    JTextField url;
    JButton mezclar;
    JLabel mostrarimagen;

    public FormBoletin8() {

        super("Coloritos");
        this.setLayout(new FlowLayout());

        color1 = new JTextField();
        color1.setPreferredSize(new Dimension(40, 20));
        color1.setBackground(Color.red);
        color1.setToolTipText("Introduce un valor de rojo (0-255)");
        this.add(color1);

        color2 = new JTextField();
        color2.setPreferredSize(new Dimension(40, 20));
        color2.setBackground(Color.green);
        color2.setToolTipText("Introduce un valor de verde (0-255)");
        this.add(color2);

        color3 = new JTextField();
        color3.setPreferredSize(new Dimension(40, 20));
        color3.setBackground(Color.blue);
        color3.setForeground(Color.white);
        color3.addActionListener(this);
        color3.setToolTipText("Introduce un valor de azul (0-255)");
        this.add(color3);

        mezclar = new JButton("Mezclar");
        mezclar.setPreferredSize(new Dimension(180, 40));
        mezclar.addActionListener(this);
        mezclar.setToolTipText("Mezclar los valores introducidos");
        this.add(mezclar);

        url = new JTextField();
        url.setPreferredSize(new Dimension(460, 30));
        url.addActionListener(this);
        url.setToolTipText("PATH de la imagen");
        this.add(url);

        mostrarimagen = new JLabel();
        mostrarimagen.setPreferredSize(new Dimension(550, 400));
        this.add(mostrarimagen);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == url) {
                mostrarimagen.setIcon(new ImageIcon(url.getText()));
            }

            if (e.getSource() == mezclar) {

                int red = Integer.parseInt(color1.getText());
                int green = Integer.parseInt(color2.getText());
                int blue = Integer.parseInt(color3.getText());

                if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {

                    mezclar.setForeground(new Color(red, green, blue));

                } else {

                    mezclar.setBackground(new Color(red, green, blue));

                }
            }

            if (e.getSource() == color3) {

                int red = Integer.parseInt(color1.getText());
                int green = Integer.parseInt(color2.getText());
                int blue = Integer.parseInt(color3.getText());

                mezclar.setBackground(new Color(red, green, blue));

            }

        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(null, "Valores no validos");
        }

    }

}
