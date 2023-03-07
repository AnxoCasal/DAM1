import java.util.Scanner;

public class boletin1 {

/**
 * Generador de "N" saltos de linea
 * @param n Nº de saltos
 */
    static void funcion1 (int n){
     
        int cont = 0;
        do{
            cont++;
            System.out.println("a");
        } while (cont<n);
    }

/**
 * Separador de pares o impares
 * @param n2 Numero a comprobar
 * @return Valor true o false segun el número sea o no par
 */
    static boolean funcion2 (int n2){
     //  System.out.println("A");
        if(n2%2==0){
            return true;
        } else {
           return false;
        }
    }

/**
 * Separador de positivos y negativos
 * @param n3 Numero a comp
 * @return "p" si es pos y "n" si neg o 0
 */
    static String funcion3 (int n3){
        if (n3 > 0){
            return "p";
        } else {
            return "N";
        }
    }


//PROGRAMA COMPLETO
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        int n;
        int n2;
        int n3;

        funcion1(5);
        System.out.println("Dame un numero");
        
        n = sc.nextInt();

        funcion1(n);

        System.out.println("Dame un numero");

        n2 = sc.nextInt();

        funcion2(n2);

        System.out.println(funcion2(n2));

        System.out.println("Dame un numero");

        n3 = sc.nextInt();

        funcion3(n3);

        System.out.println(funcion3(n3));
    }
}