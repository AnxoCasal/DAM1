import java.util.Scanner;

public class Hola2 {
	public static void main (String args[]) {
		// Declaración de variables
		String nombre;
		Scanner sc= new Scanner(System.in);

		// Código
		System.out.print("Dime tu nombre: ");
		nombre=sc.nextLine();
		System.out.println(nombre+", Welcome to the Java World");
		System.out.println("Nos vemos");
	}
}