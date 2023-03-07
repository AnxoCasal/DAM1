package Interfaz;

import java.util.Scanner;

public class Libreria implements Interfaz {

    public int pedirEntero() {
        Scanner sc = new Scanner(System.in);
        boolean Error = true;
        int aux = 0;
        do {
            try {
                Error = false;
                System.err.println("Introduzca un numero entero");
                aux = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                sc.nextLine();
                Error = true;
                System.out.println("Valor invalido\n");
            }
        } while (Error);
        return aux;
    }

    public double pedirReal() {
        Scanner sc = new Scanner(System.in);
        boolean Error = true;
        do{
            try {
                System.err.println("Introduzca un numero real");
                double num = sc.nextDouble();
                return num;
            } catch (java.util.InputMismatchException e) {
                sc.nextLine();
                Error = true;
                System.out.println("Valor invalido\n");
            }
        } while (Error);
        return 0;
    }
}
