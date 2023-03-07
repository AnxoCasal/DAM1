package anxo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class formBoletin3 extends JFrame implements ActionListener {

    JButton BTNañadir;
    JLabel LBLruta, LBLimg, LBLpath, LBLnombre, LBLpeso, LBLpermisos;
    JTextArea texto, datos, directorios;
    String path;
    String extension;
    String lista;

    public formBoletin3() {

        super("Archivos");
        this.setLayout(null);

        BTNañadir = new JButton("Añadir");
        BTNañadir.setSize(200, 50);
        BTNañadir.setLocation(150, 20);
        BTNañadir.addActionListener(this);
        add(BTNañadir);

        LBLruta = new JLabel("Seleccione un archivo");
        LBLruta.setSize(500, 50);
        LBLruta.setLocation(10, 425);
        add(LBLruta);

        LBLimg = new JLabel();
        LBLimg.setSize(300, 300);
        LBLimg.setLocation(100, 100);
        add(LBLimg);

        texto = new JTextArea();
        texto.setSize(300, 300);
        texto.setLocation(100, 100);
        texto.setVisible(false);
        texto.setFocusable(false);
        add(texto);

        datos = new JTextArea();
        datos.setSize(300, 300);
        datos.setLocation(100, 100);
        datos.setVisible(false);
        datos.setFocusable(false);
        add(datos);

        directorios = new JTextArea();
        directorios.setSize(300, 300);
        directorios.setLocation(100, 100);
        directorios.setVisible(false);
        directorios.setFocusable(false);
        add(directorios);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == BTNañadir) {

                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                FileNameExtensionFilter filtroIMG = new FileNameExtensionFilter("Images", "jpg", "jpeg", "gif", "png");
                FileNameExtensionFilter filtroArchivo = new FileNameExtensionFilter("Texto", "txt");
                fc.addChoosableFileFilter(filtroIMG);
                fc.addChoosableFileFilter(filtroArchivo);
                int respuesta = fc.showOpenDialog(this);
                path = fc.getSelectedFile().getPath();
                File file = new File(path);
                if (file.isDirectory()) {

                    LBLimg.setVisible(false);
                    texto.setVisible(false);
                    datos.setVisible(false);
                    directorios.setVisible(true);
                    File[] files = file.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        if (files[i].isFile()) {
                            lista = lista + files[i].getName() + "\n";
                        } else if (files[i].isDirectory()){
                            lista = lista + files[i].getName() + "\t\tD\n";
                        }
                        directorios.setText(lista);
                    }
                } else {

                    String fileName = file.toString();
                    int index = fileName.lastIndexOf('.');
                    if (index > 0) {
                        extension = fileName.substring(index + 1);
                    }
                    if (respuesta == JFileChooser.APPROVE_OPTION) {
                        if ((extension.equals("jpg")) || (extension.equals("jpeg")) || (extension.equals("gif"))
                                || (extension.equals("PNG"))) {

                            texto.setVisible(false);
                            datos.setVisible(false);
                            LBLruta.setText("La ruta es: " + path);
                            LBLimg.setIcon(new ImageIcon(path));
                            LBLimg.setVisible(true);

                        } else if (extension.equals("txt")) {

                            String contenido = "";

                            LBLimg.setVisible(false);
                            datos.setVisible(false);
                            LBLruta.setText("La ruta es: " + path);
                            try (Scanner f = new Scanner(new File(path))) {
                                while (f.hasNext()) {
                                    contenido = contenido + f.nextLine() + "\n";
                                }
                            } catch (Exception e2) {
                                System.err.println("Error de acceso al archivo: " + e2.getMessage());
                            }
                            texto.setText(contenido);
                            texto.setVisible(true);
                            contenido = "";

                        } else {

                            LBLimg.setVisible(false);
                            texto.setVisible(false);
                            datos.setVisible(true);
                            datos.setText(String.format("La ruta es: " + fc.getSelectedFile().getParent() +
                                    "\nEl nombre del archivo es: " + fc.getSelectedFile().getName() +
                                    "\nEl archivo pesa: " + fc.getSelectedFile().getTotalSpace() + "KB" +
                                    "\n%s tiene permisos de lectura \n%s tiene permisos de escritura \n%s tiene permisos de ejecucion",
                                    fc.getSelectedFile().canRead() ? "Si " : "No ",
                                    fc.getSelectedFile().canWrite() ? "Si" : "no",
                                    fc.getSelectedFile().canExecute() ? "Si" : "no"));

                        }
                    }
                }

            }

        } catch (Exception e2Exception) {
        }
    }

}
