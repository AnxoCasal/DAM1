import java.util.Scanner;

public class boletin8 {
    public static void main(String[] args) {

        int num1;
        int num2;
        int num3;

        Scanner sc = new Scanner (System.in);

        num1 = sc.nextInt();
        num2 = sc.nextInt();
        num3 = sc.nextInt();

        if (num1>num2) {
            num2=num1;
        }

        if (num2>num3) {
            System.out.println(num2);
        } else {
            System.out.println(num3);
        }

    }    
}
