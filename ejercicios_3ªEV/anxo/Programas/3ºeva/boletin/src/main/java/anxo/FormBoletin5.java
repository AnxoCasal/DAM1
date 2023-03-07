package anxo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FormBoletin5 extends JFrame implements ActionListener {

    JLabel lblIndicacion;
    JLabel lblReves;
    JLabel lblDeshabilitar;
    JCheckBox checkDeshabilitar;
    JTextField txtMsg;
    JButton btnEnviar;
    JCheckBox checkReves;

    public FormBoletin5() {

        super("Super titulo");
        this.setLayout(null);

        lblIndicacion = new JLabel("Introduzca el texto");
        lblIndicacion.setLocation(190, 120);
        lblIndicacion.setSize(200, 30);
        this.add(lblIndicacion);

        txtMsg = new JTextField();
        txtMsg.setLocation(150, 180);
        txtMsg.setSize(200, 30);
        txtMsg.addActionListener(this);
        this.add(txtMsg);

        checkReves = new JCheckBox();
        checkReves.setLocation(140, 250);
        checkReves.setSize(20, 20);
        this.add(checkReves);

        lblReves = new JLabel("¿Desea introducir el texto al reves?");
        lblReves.setLocation(160, 245);
        lblReves.setSize(250, 30);
        this.add(lblReves);

        checkDeshabilitar = new JCheckBox();
        checkDeshabilitar.setLocation(140, 300);
        checkDeshabilitar.setSize(20, 20);
        checkDeshabilitar.addActionListener(this);  //itemlistener
        this.add(checkDeshabilitar);

        lblDeshabilitar = new JLabel("¿Desea deshabilitar la función?");
        lblDeshabilitar.setLocation(160, 295);
        lblDeshabilitar.setSize(250, 30);
        this.add(lblDeshabilitar);

        btnEnviar = new JButton("Enviar");
        btnEnviar.setLocation(150, 370);
        btnEnviar.setSize(200, 30);
        btnEnviar.addActionListener(this);
        this.add(btnEnviar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String msg = txtMsg.getText();

        if(e.getSource() == checkDeshabilitar){
            // if(checkDeshabilitar.isSelected()){
            //     txtMsg.setEnabled(false);
            // } else {
            //     txtMsg.setEnabled(true);
            // }

            txtMsg.setEnabled(!checkDeshabilitar.isSelected());
        }

        if (e.getSource() == txtMsg || e.getSource() == btnEnviar) {

            if (checkReves.isSelected()) {

                String reves = "";

                for (int i = msg.length() - 1; i >= 0; i--) {
                    reves = reves + msg.charAt(i);
                }

                int opt;
                opt = JOptionPane.showConfirmDialog(null,
                        "¿Deseas poner este texto como titulo del programa? " + '"' + reves + '"', "Elija",
                        JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.YES_OPTION) {
                    this.setTitle(reves);
                }
            } else {

                int opt;
                opt = JOptionPane.showConfirmDialog(null,
                        "¿Deseas poner este texto como titulo del programa? " + '"' + msg + '"', "Elija",
                        JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.YES_OPTION) {
                    this.setTitle(msg);
                }

            }

        }

    }
}
