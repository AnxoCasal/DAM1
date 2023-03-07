import java.util.Scanner;

public class boletin9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int i;
        int num1;
        int num2 = 0;
        int cont = 0;

        System.out.println("Cuantos numeros quieres");
        i = sc.nextInt();

        num2 = sc.nextInt();

        
 
     

        cont++;

        

        do{

            cont++;

            num1 = sc.nextInt();

            if(num1>num2){
                num2=num1;
            }
        }while(cont!=i);
        System.out.println("El numero mas grande es el " + num2);
    }
}
