package anxo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CajasTexto extends JFrame implements ActionListener {
    JLabel lblDni;
    JLabel lblNombre;
    JLabel lblInicio;
    JLabel lblFinal;
    JTextField txtDni;
    JTextField txtNombre;
    JTextField txtInfo;
    JTextField txtInicio;
    JTextField txtFinal;

    public CajasTexto() {

        super("Cajas de edición de texto");
        this.setLayout(new FlowLayout());

        lblDni = new JLabel("Introduzca su DNI");
        add(lblDni);

        txtDni = new JTextField(9);
        txtDni.addActionListener(this);
        add(txtDni);

        txtNombre = new JTextField("Escriba aquí su nombre");
        txtNombre.addActionListener(this);
        add(txtNombre);

        txtInfo = new JTextField("Información no editable", 23);
        txtInfo.setEditable(false);
        txtInfo.addActionListener(this);
        add(txtInfo);

        lblInicio = new JLabel("Inicio de la cadena");
        add(lblInicio);

        txtInicio = new JTextField("", 2);
   
        add(txtInicio);

        lblFinal = new JLabel("Final de la cadena");
        add(lblFinal);

        txtFinal = new JTextField("", 2);
        txtFinal.addActionListener(this);
        add(txtFinal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == txtDni) {
            ((JTextField) e.getSource()).selectAll();
            JOptionPane.showMessageDialog(null, ((JTextField) e.getSource()).getSelectedText(), "Cajas de Texto",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (e.getSource() == txtNombre) {
            JOptionPane.showMessageDialog(null, ((JTextField) e.getSource()).getSelectedText(), "Cajas de Texto",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == txtFinal) {
            try {
                int Inicio = Integer.parseInt(txtInicio.getText());
                int Final = Integer.parseInt(txtFinal.getText());
                txtNombre.select(Inicio, Final);
                int max = txtNombre.getText().length();

                if(Inicio<0 || Final>max){
                    throw new SoloPositivos();
                }

                JOptionPane.showMessageDialog(null, txtNombre.getSelectedText());

            } catch (NumberFormatException exc) {
                JOptionPane.showMessageDialog(null, "Introduzca solo numeros");
            } catch (SoloPositivos exc) {
                JOptionPane.showMessageDialog(null, "Indices fuera de lugar");
            }
        }
    }
}
