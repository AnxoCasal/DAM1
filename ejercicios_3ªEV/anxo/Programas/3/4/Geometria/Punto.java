package Geometria;

public class Punto {
    int x;
    int y;

    public Punto(){
        this(0,0);
    }

    public Punto(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
