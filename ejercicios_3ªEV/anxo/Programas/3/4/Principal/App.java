package Principal;
import Interfaz.Interfaz;
import Interfaz.Libreria;

public class App {
    public static void main(String[] args) {
        int num1 = Interfaz.pedirEntero();
        System.out.println(num1);
        double num2 = Interfaz.pedirReal();
        System.out.println(num2);
    }
}
