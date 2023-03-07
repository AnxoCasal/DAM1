import java.util.Scanner;

public class boletin12 {
    public static void main(String[]args){

        Scanner sc = new Scanner (System.in);

        for(int cont=1; cont < 51; cont++){
            System.out.println(cont);
        }

        System.out.println("**************");

        for(int cont=50; cont != 0; cont--){
            System.out.println(cont);
        }

        System.out.println("**************");

        for(int cont=1; cont != 20; cont++){
            if(cont%2==0){
            System.out.println(cont);
            }
        }

        System.out.println("**************");

        for(int cont=90; cont != 131; cont++){
            if(cont%2!=0){
            System.out.println(cont);
            }
        }
        
        System.out.println("**************");

        for(int cont=70; cont != 24; cont--){
            if(cont%5==0){
            System.out.println(cont);
            }
        }


    }
}
