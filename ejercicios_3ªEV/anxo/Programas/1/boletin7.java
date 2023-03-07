import java.util.Scanner;

public class boletin7 {
	public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        
        int opcion;

        do{
            
           
                System.out.println("Dame numeros para calcular su media");

                double num1;
                double i=-1;
                double media = 0;

                do {
                    i=i+1;
                    num1 = sc.nextDouble();
                    media = media + num1;
                }while (num1!=0);
                
                media = media/i;
                
                System.out.printf("La media es %.2f\n",media);
            
            System.out.println("Otra vez-1 \nSalir-0");    
            opcion = sc.nextInt();

        }while (opcion==1);
    }
}