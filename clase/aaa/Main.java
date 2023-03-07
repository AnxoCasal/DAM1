public class Main {
    public static void main(String[] args) {
        Mosca mosca = new Mosca();
        Perro perro = new Perro(12,"labrador","anxo");
        
        mosca.setEdad(45);
        System.out.println(mosca.getEdad());

        perro.ladrar();


    }
}
