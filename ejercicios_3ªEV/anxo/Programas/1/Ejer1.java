import java.util.Scanner;

public class Ejer1 {
	public static void main(String[] args) {

        int num1;
        int num2; 
        Scanner sc = new Scanner (System.in);
 
    
        System.out.println ("Dime tu edad") ;
        num1 = sc.nextInt () ;
    
        System.out.println ("Dime con cuantos años empezaste");
        num2 = sc.nextInt () ;

        System.out.println ("Llevas "+(num1-num2)+" años estudiando");
    
    
    }
}