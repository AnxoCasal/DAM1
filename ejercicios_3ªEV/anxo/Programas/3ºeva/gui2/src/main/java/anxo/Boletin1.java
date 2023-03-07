package anxo;

import javax.swing.JFrame;

public class Boletin1 extends JFrame {
    public static void main(String[] args) {
        
        FormBoletin1 app = new FormBoletin1();
        app.setSize(650, 400);
        app.setLocationRelativeTo(null);
        app.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        app.setVisible(true);

    }
}
