import java.util.Scanner;

public class boletin14 {
    
    public static void main(String[]args){

        Scanner sc = new Scanner (System.in);

        int num;
        int cont = 0;
        int cont2 = -1;

        do{
            System.out.println("Introduce numeros");
            num = sc.nextInt();
            if(num<0){
                cont++;
            }
            cont2++;
        } while(num!=0);
        System.out.println("Se introdujeron "+cont+" numeros negativos de un total de "+cont2);



    }
}