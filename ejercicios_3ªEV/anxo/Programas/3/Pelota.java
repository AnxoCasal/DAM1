import java.util.Scanner;

public class Pelota {

    public String tipo;
    private double radio;
    
    public Pelota(){
        this.tipo="Playa";
        this.radio=40.0;
    }

    public Pelota(String tipo, double radio){
        this.tipo = tipo;
        this.radio = radio;
    }
    
    public void setRadio(double radio){
        this.radio = radio;
    }

    public double getRadio(){
        return this.radio;
    }

    public void inflar(){
        this.radio++;
    }

    public void inflar(int incremento){
        this.radio += incremento;
    }

    

}