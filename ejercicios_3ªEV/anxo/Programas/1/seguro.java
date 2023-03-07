import java.util.Scanner;

public class seguro {
	public static void main(String[] args) {

        int precio = 300;
        int edad;
        int anhoscarne;
        Scanner sc = new Scanner (System.in);

        System.out.println ("¿Edad del conductor?");
        edad = sc.nextInt ();

        System.out.println ("¿Anhos con carné?");
        anhoscarne = sc.nextInt ();

        if (edad<21){
            precio=precio+100;
        }
        if (anhoscarne>10){
            precio=precio-30;
        }
        System.out.println ("El precio de su seguro es de "+precio);
    }
}