package anxo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class enemie implements ActionListener {

    int cont = 0;
    int hp;
    int speed;
    boolean shoot;
    boolean swing;
    Icon skin;
    int x;
    int y;
    int sizeX;
    int sizeY;
    int type;
    boolean desaparecer = false;
    boolean estado = false;
    Timer death = new Timer(50, this);

    public enemie(int type) {
        if (type == 1) {

            hp = 1;
            speed = 4;
            shoot = false;
            swing = true;
            skin = new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//enemie.V2.png");
            x = 1710;
            y = (int) (Math.random() * 410 + 270);
            sizeX = 65;
            sizeY = 75;
            this.type = type;

        } else if (type == 2) {

            hp = 1;
            speed = 7;
            shoot = false;
            swing = false;
            skin = new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//enemie.V3.png");
            x = 1710;
            y = (int) (Math.random() * 410 + 270);
            sizeX = 65;
            sizeY = 75;
            this.type = type;

        } else if (type == 3) {

            hp = 1;
            speed = 4;
            shoot = false;
            swing = false;
            skin = new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//enemie.V4.png");
            x = 1710;
            y = (int) (Math.random() * 410 + 270);
            sizeX = 65;
            sizeY = 75;
            this.type = type;

        }
    }

    public int getHP() {
        return this.hp;
    }

    public void setHP(int newHP) {
        this.hp = newHP;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }

    public Icon getIcon() {
        return this.skin;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getsizeX() {
        return this.sizeX;
    }

    public int getsizeY() {
        return this.sizeY;
    }

    public int getType() {
        return this.type;
    }

    public boolean getSwing() {
        return this.swing;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public boolean getDesaparecer() {
        return this.desaparecer;
    }

    public void matar() {
        death.start();
        estado = true;
        skin = new ImageIcon(
                "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//explosion//explosion1.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == death) {
            skin = new ImageIcon(
                    "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//explosion//explosion2.png");
            if (cont == 1) {
                skin = new ImageIcon(
                        "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//explosion//explosion3.png");
            } else if (cont == 2) {
                skin = new ImageIcon(
                        "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//explosion//explosion4.png");
            } else if (cont == 3) {
                skin = new ImageIcon(
                        "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//explosion//explosion5.png");
            } else if (cont == 4) {
                skin = new ImageIcon(
                        "C://Users//Anxo//Documents//Programas//3ºeva//tfg//src//main//java//anxo//Images//explosion//explosion6.png");
            } else if (cont == 6) {
                desaparecer = true;
            }
            cont++;
        }
    }

}
