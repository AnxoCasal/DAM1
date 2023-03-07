import java.util.Scanner;

public class division {
	public static void main(String[] args) {

        int num1;
        int num2;
        Scanner sc = new Scanner (System.in);

        System.out.println ("Dame 2 numeros");
        num1 = sc.nextInt ();
        num2 = sc.nextInt ();

        if (num1==0){
        System.out.println ("numero invalido");
        }
        else{ 
            if(num2==0){
            System.out.println ("numero invalido");
            }
            else
            System.out.println ("Resultado division"+((double)num1/(double)num2));
        }
    }
}