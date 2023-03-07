import java.util.Scanner;

public class boletin10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        int num1;
        int num2;
        int num3 = 0;

        System.out.println("Dame dos numeros");

        num1 = sc.nextInt();
        num2 = sc.nextInt();

        num3 = num2;
        num2 = num1;
        num1 = num3;

        System.out.println(num1);
        System.out.println(num2);
    }
}