import java.util.Scanner;

public class boletin5 {
	public static void main(String[] args) {

        int opcion;
        double celsius;
        
        Scanner sc = new Scanner (System.in);


        do{
            System.out.println("Que temperatura hace?");
            celsius = sc.nextDouble ();
            double k = (celsius+273);
            double f = ((1.8*celsius)+32);

            System.out.println("Que quieres hacer? \n ----------------- \n"
                +" 1- Convertir a Farenheit \n 2- Convertir a Kelvin \n 3- Exit");
        
            opcion = sc.nextInt ();
            
            switch (opcion) {
                case 1: 
                      System.out.printf ("%.2f F\n", f);
                break;

                case 2: 
                        System.out.printf ("%.2f K\n", k);
                break;  
            } 

            System.out.println("\n");

        } while (opcion != 3);

    }
}