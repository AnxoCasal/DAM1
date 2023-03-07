import java.util.Scanner;

public class boletin3 {
	public static void main(String[] args) {

        int k=0;
        int num;
        Scanner sc = new Scanner (System.in);
       
        System.out.println("Dame 1 numero");
        num = sc.nextInt ();

        if (num>0){
            for (int cont=1; cont<num+1; cont++){
                k=k+cont;
                if (cont==num){
                    System.out.println(cont+"=");
                } else {
                    System.out.println(cont+"+");
                }
            } 
            System.out.println (k);
        } 
            
        
    }
}