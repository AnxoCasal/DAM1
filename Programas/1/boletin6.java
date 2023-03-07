import java.util.Scanner;

public class boletin6 {
	public static void main(String[] args) {

        int opcion;
        Scanner sc = new Scanner (System.in);


        do{
            System.out.println("Elija una opcion\n--------------\n"+
            "1- Numero elevado al cuadrado\n"+
            "2- Inverso de un numero\n"+
            "3- Raiz cuadrada de un número \n"+
            "4- Operacion AND a nivel de bit entre dos enteros\n"+
            "5- Operacion OR a nivel de bit entre dos enteros\n"+
            "6- Exit");
            opcion = sc.nextInt ();

            double num1;
            int num2;
            int num3;
          
            switch (opcion){
                case 1:
                    System.out.println("Elija numero");
                    num1 = sc.nextDouble ();
                    double cuadrado = num1*num1;
                    System.out.printf ("%.2f\n", cuadrado);
                break;

                case 2:
                    do{
                        System.out.println("Elija numero");
                        num1 = sc.nextDouble ();
                    } while (num1==0);

                    double inverso = 1/num1;
                    System.out.printf ("%.4f\n", inverso);
                break;
                
                case 3:
                    do{
                        System.out.println("Elija numero");
                        num1 = sc.nextDouble ();
                    } while (num1<0);
                    double raiz = Math.sqrt(num1);
                    System.out.printf ("%.3f\n", raiz);
                break;
                
                case 4:
                    System.out.println("Dame dos numeros");
                    num2 = sc.nextInt ();
                    num3 = sc.nextInt ();
                    int and = num2 & num3;
                    System.out.printf ("%X\n", and);
                break;
                
                case 5:
                    System.out.println("Dame dos numeros");
                    num2 = sc.nextInt ();
                    num3 = sc.nextInt ();
                    int or = num2 | num3;
                    System.out.printf ("%X\n", or);
                break;
                
            }

            System.out.println("\n");
        }while (opcion != 6);




    }
}