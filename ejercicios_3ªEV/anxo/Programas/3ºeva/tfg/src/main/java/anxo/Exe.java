package anxo;

import javax.swing.JFrame;

public class Exe extends JFrame {
  public static void main(String[] args) {
    
    Alpha2 app = new Alpha2();
    app.setSize(1700, 1000);
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setLocationRelativeTo(null);
    app.setVisible(true);

  }
}