import java.util.Scanner;

public class boletin13 {
    
    public static void main(String[]args){

        int num;
        int suma = 0;
        int suma2 = 0;
        Scanner sc = new Scanner (System.in);

        num = sc.nextInt();
       
        for(int cont=0; cont<num; cont++){
            if(cont%2==0){
                suma=suma+cont;
            }
        }
        System.out.println(suma);

        suma=0;

        for(int cont=0; cont<num; cont++){
            if(cont%2!=0){
                suma2=suma2+cont;
            }
        }
        System.out.println(suma2);
        
        suma2=0;
    
        for(int cont=0; cont<num; cont++){
            if(cont%2==0){
                suma=suma+cont;
            } else {
                suma2=suma2+cont;
            }
        }
        System.out.println(suma);
        System.out.println(suma2);


    }
}