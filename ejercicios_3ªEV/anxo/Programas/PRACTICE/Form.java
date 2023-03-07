import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Form extends JFrame implements ActionListener {

    JTextField txtNum1, txtNum2, txtNum3;
    int num1, num2, num3;
    JButton play;
    JLabel result;

    public Form() {

        super("tragaperras");
        setLayout(null);

        txtNum1 = new JTextField(num1);
        txtNum1.setEditable(false);
        txtNum1.setSize(30, 30);
        txtNum1.setLocation(20, 20);
        add(txtNum1);

        txtNum2 = new JTextField(num2);
        txtNum2.setEditable(false);
        txtNum2.setSize(30, 30);
        txtNum2.setLocation(60, 20);
        add(txtNum2);

        txtNum3 = new JTextField(num3);
        txtNum3.setEditable(false);
        txtNum3.setSize(30, 30);
        txtNum3.setLocation(100, 20);
        add(txtNum3);

        play = new JButton("Jugar");
        play.setSize(100, 30);
        play.setLocation(20, 60);
        play.addActionListener(this);
        add(play);

        result = new JLabel("BUENA SUERTE");
        result.setSize(100, 30);
        result.setLocation(20, 100);
        add(result);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play) {
            num1 = (int) (Math.random() * 6 + 1);
            num2 = (int) (Math.random() * 6 + 1);
            num3 = (int) (Math.random() * 6 + 1);
            txtNum1.setText("" + num1);
            txtNum2.setText("" + num2);
            txtNum3.setText("" + num3);

            System.out.println(num1);
            System.out.println(num2);
            System.out.println(num3);

            if(num1 == num2 && num2 ==num3){
                result.setForeground(Color.green);
                result.setText("PREMIO!");
            } else{
                result.setForeground(Color.red);
                result.setText("Mala suerte!");
            }
        }
        
    }

}
