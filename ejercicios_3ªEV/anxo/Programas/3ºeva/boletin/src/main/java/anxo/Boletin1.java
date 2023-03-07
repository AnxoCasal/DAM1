package anxo;

import javax.swing.JOptionPane;

public class Boletin1 extends JOptionPane {
    public static void main(String[] args) {
        int respuesta;
        do {
            try {
                JOptionPane.showMessageDialog(null, "Vamos a sumar dos numeros");
                int num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el primer numero"));
                int num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el segundo numero"));
                JOptionPane.showMessageDialog(null, num1 + num2);
            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Porfavor introduce solo numeros enteros");
            }
              respuesta = JOptionPane.showConfirmDialog(null, "Realizar otra suma",
                    "Eliminar", JOptionPane.YES_NO_OPTION);
        } while (respuesta==JOptionPane.YES_OPTION);

    }
}
