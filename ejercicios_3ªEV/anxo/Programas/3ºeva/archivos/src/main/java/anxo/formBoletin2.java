package anxo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * boletin2
 */
public class formBoletin2 extends JFrame implements ActionListener {

    JLabel LBLtitulo;
    JLabel LBLarchivo;
    JButton BTNinsertar;
    JButton BTNcrear;
    JButton BTNmostrar;
    JButton BTNañadir;
    JButton BTNborrar;
    JButton BTNsalir;
    String path;
    File f;
    String newpath;
    File newf;

    public formBoletin2() {

        this.setLayout(null);

        LBLtitulo = new JLabel("GESTION DE ARCHIVOS");
        LBLtitulo.setSize(400, 30);
        LBLtitulo.setFont(new Font("Serif", 1, 32));
        LBLtitulo.setLocation(75, 30);
        this.add(LBLtitulo);

        LBLarchivo = new JLabel();
        LBLarchivo.setSize(400, 150);
        LBLarchivo.setFont(new Font("Serif", 1, 12));
        LBLarchivo.setLocation(200, 30);
        LBLarchivo.setVisible(false);
        this.add(LBLarchivo);

        BTNinsertar = new JButton("Cambiar archivo");
        BTNinsertar.setSize(150, 30);
        BTNinsertar.setLocation(20, 200);
        BTNinsertar.addActionListener(this);
        this.add(BTNinsertar);

        BTNcrear = new JButton("Crear archivo");
        BTNcrear.setSize(150, 30);
        BTNcrear.setLocation(190, 200);
        BTNcrear.addActionListener(this);
        this.add(BTNcrear);

        BTNmostrar = new JButton("Mostrar contenido");
        BTNmostrar.setSize(150, 30);
        BTNmostrar.setLocation(360, 200);
        this.add(BTNmostrar);

        BTNañadir = new JButton("Modificar contenido");
        BTNañadir.setSize(150, 30);
        BTNañadir.setLocation(20, 300);
        this.add(BTNañadir);

        BTNborrar = new JButton("Borrar archivo");
        BTNborrar.setSize(150, 30);
        BTNborrar.setLocation(190, 300);
        this.add(BTNborrar);

        BTNsalir = new JButton("Salir");
        BTNsalir.setSize(150, 30);
        BTNsalir.setLocation(360, 300);
        BTNsalir.addActionListener(this);
        this.add(BTNsalir);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == BTNinsertar) {

                path = JOptionPane.showInputDialog("Inserte el path del archivo");
                f = new File(path);
                if (f.exists()) {
                    JOptionPane.showMessageDialog(this, "Archivo seleccionado exitosamente");
                    BTNañadir.addActionListener(this);
                    BTNmostrar.addActionListener(this);
                    BTNborrar.addActionListener(this);
                    LBLarchivo.setText("Archivo seleccionado: " + f.getName());
                    LBLarchivo.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Este archivo no existe");
                    BTNañadir.removeActionListener(this);
                    BTNmostrar.removeActionListener(this);
                    BTNborrar.removeActionListener(this);
                }

            }

            if (e.getSource() == BTNcrear) {

                newpath = JOptionPane.showInputDialog("Inserte el nuevo archivo");
                newf = new File(newpath);

                if (newf.exists()) {
                    int confirm = JOptionPane.showConfirmDialog(null,
                            "El archivo seleccionado ya existe\n¿Quieres sobreescribirlo?", "Confirmation",
                            JOptionPane.YES_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        try {
                            newf.createNewFile();
                            if (newf.exists()) {
                                path = newpath;
                                f = new File(path);
                                System.out.println(path);
                                System.out.println(f.getName());
                                JOptionPane.showMessageDialog(this, "Archivo creado exitosamente");
                                BTNañadir.addActionListener(this);
                                BTNmostrar.addActionListener(this);
                                BTNborrar.addActionListener(this);
                                LBLarchivo.setText("Archivo seleccionado: " + f.getName());
                                LBLarchivo.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al crear el archivo");
                            }

                        } catch (IOException e1) {
                            System.out.println("No se a podido crear el archivo");
                        }
                    }
                } else {
                    try {
                        newf.createNewFile();
                        path = newpath;
                        f = new File(path);
                        LBLarchivo.setText("Archivo seleccionado: " + f.getName());
                    } catch (IOException e1) {
                        System.out.println("No se a podido crear el archivo");
                    }

                }
            }

            if (e.getSource() == BTNmostrar) {

                String texto = "";

                try (Scanner f = new Scanner(new File(path))) {
                    while (f.hasNext()) {
                        texto = texto + f.nextLine() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, "" + texto);
                } catch (Exception e2) {
                    System.err.println("Error de acceso al archivo: " + e2.getMessage());
                }

            }

            if (e.getSource() == BTNañadir) {

                String nuevo = JOptionPane.showInputDialog(null, "Añade texto");
               

                try(PrintWriter pw = new PrintWriter(new FileWriter(f, true))) {
                    pw.append("\n" + nuevo);
                
                } catch (Exception ee) {
                    System.err.println("Error");
                }
            }

            if (e.getSource() == BTNborrar) {

                int confirm = JOptionPane.showConfirmDialog(null, "Seguro que quiere eliminar el archivo?", null,
                        JOptionPane.YES_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    f.delete();
                    if (f.exists()) {
                        JOptionPane.showMessageDialog(null, "Error al borrar el archivo");
                    } else {
                        JOptionPane.showMessageDialog(null, "Archivo eliminado correctamente");
                        LBLarchivo.setText("");
                    }
                }
            }

            if (e.getSource() == BTNsalir) {
                System.exit(0);
            }

        } catch (NullPointerException error) {
            System.err.println("error");
        }
    }

}