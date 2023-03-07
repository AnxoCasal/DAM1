import java.util.Scanner;

public class boletin4 {
	public static void main(String[] args) {

        int num1;
        double num2;
        Scanner sc = new Scanner (System.in);

        System.out.println("Dame un numero entero");
        num1 = sc.nextInt ();
        System.out.println("Dame un numero real");
        num2 = sc.nextDouble ();
        System.out.printf ("%d\n",num1);
        System.out.printf ("%05o\n",num1);
        System.out.printf ("%X\n", num1);
        System.out.printf ("%7.3f\n", num2);
    }
}