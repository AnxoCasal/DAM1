public class Geometria{

    public boolean figura;
    private int altura;
    private int base;

    public void setAltura(int altura){
        if(altura>=0){
            this.altura = altura;
        } else {
            this.altura = 1;
        }
    }

    public void setBase(int base){
        if(base>=0){
            this.base = base;
        } else {
            this.base = 1;
        }
    }

    public int getAltura(){
        return altura;
    }

    public int getBase(){
        return base;
    }

    public Geometria(){
        figura = false;
        altura = 2;
        base = 2;
    }    

    public Geometria(int altura, int base){
        figura = false;
        this.altura = altura;
        this.base = base;
    }

    public Geometria(boolean figura, int altura, int base){
        this.figura = figura;
        this.altura = altura;
        this.base = base;
    }

    public double area(){
        double resultado;
        if(figura){
            resultado = base * altura;
            return resultado; 
        } else {
            resultado = (base*altura)/2;
            return resultado; 
        }
    }

    public double perimetro(){
        double resultado;
        if(figura){
            resultado = (base + altura)*2;
            return resultado; 
        } else {
            resultado = base+altura+diagonal();
            return resultado; 
        }
    }

    public double diagonal(){
        double diagonal = Math.sqrt((base*base)+(altura*altura)) ;
        return  diagonal;
    }

    public String tipo(){
        String figura;
        if(this.figura){
            figura = "Rectangulo";
            return figura;
        } else {
            figura = "Triangulo";
            return figura;
        }
    }
}