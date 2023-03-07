package anxo;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Form2Boletin1 extends JDialog implements ActionListener, ItemListener {

    JLabel LBLtitulo, LBLcolores;
    TextField titulo;
    JComboBox colores;
    String[] coloresINFO = { "Rojo", "Azul", "Amarillo", "Verde" };
    Color[] posiblesColores = { Color.red, Color.blue, Color.YELLOW, Color.green };

    public Form2Boletin1(FormBoletin1 f) {

        super(f);
        setLayout(null);
        setTitle("Ajustes");

        LBLtitulo = new JLabel("TITULO");
        LBLtitulo.setSize(100, 20);
        LBLtitulo.setLocation(40, 80);
        add(LBLtitulo);

        LBLcolores = new JLabel("COLORES");
        LBLcolores.setSize(100, 20);
        LBLcolores.setLocation(170, 80);
        add(LBLcolores);

        titulo = new TextField();
        titulo.addActionListener(this);
        titulo.setSize(100, 20);
        titulo.setLocation(20, 120);
        add(titulo);

        colores = new JComboBox<String>(coloresINFO);
        colores.setMaximumRowCount(8);
        colores.addItemListener(this);
        colores.setSize(100, 20);
        colores.setLocation(150, 120);
        add(colores);

        f.color = Color.red;

        addWindowListener(new windowHandler());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        FormBoletin1 f = (FormBoletin1) this.getOwner();

        if (e.getSource() == titulo) {

            String newtitulo = titulo.getText();
            f.titulo = newtitulo;

            JOptionPane.showMessageDialog(null, "Titulo cambiado a " + newtitulo);

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        FormBoletin1 f = (FormBoletin1) this.getOwner();

        int opt = colores.getSelectedIndex();
        f.color = posiblesColores[opt];

    }

    private class windowHandler extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {

            FormBoletin1 f = (FormBoletin1) Form2Boletin1.this.getOwner();

            f.secundario = true;

        }

    }
}
