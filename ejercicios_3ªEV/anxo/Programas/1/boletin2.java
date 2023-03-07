import java.util.Scanner;

public class boletin2 {
	public static void main(String[] args) {
 
        int num1;
        int num2;
        Scanner sc = new Scanner (System.in);
 
        System.out.println("Dame 2 numeros");
        num1 = sc.nextInt () ;
        num2 = sc.nextInt () ;

         if (num1==num2){
             System.out.println("Los numeros son iguales");
         } else {
                if (num1>num2){
                    System.out.println("El numero mayor es " + num1 );
                } else {
                    System.out.println("El numero mayor es " + num2);
                } 
        }

        

        if (num1%num2 == 0){
            System.out.println ("Los numeros son multiples");
            } else {   
                if (num2%num1 == 0){
                    System.out.println ("Los numeros son multiples");
                } else {
                System.out.println ("Los numeros no son multiples");
            } 
            }
    }
}