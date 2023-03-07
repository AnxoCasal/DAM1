import java.util.Scanner;

public class boletin2 {

/** Introduccion de numero y comrpobación de si es positivo

 * @return EL mismo número sin modificar
 */
    static double pedirDato (){

        Scanner sc = new Scanner (System.in);
        double n1;

            do{
                
                System.out.println("Dame un numero");
                n1 = sc.nextDouble();

                if (n1<0){
                    System.out.println("No es un numero positivo");
                }
                    
            } while (n1 <= 0);
            return n1;
    }

/**
 * Operacion para calcular el area del circulo
 * @param r radio del circulo
 * @param alt altura del circulo
 * @return Resultado de la operacion, "Superficie"
 */
    static double superficieCilindro (double r, double alt){
        double area = 2*Math.PI*r*alt;
        return area;
    }

/**
 * Muestra el resultado con 3 decimales
 * @param area Valor de la superficie
 */
    static void mostrarDato (double area){
        System.out.printf("%.3f\n",area);
    }

    public static void main(String[] args){

        double r=pedirDato();
        System.out.println(r);

        double alt=pedirDato();
        System.out.println(alt);

        double area = superficieCilindro(r,alt);

        mostrarDato(area);
    }
}