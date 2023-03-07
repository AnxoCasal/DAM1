import java.util.Scanner;

public class boletin11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        int num3 = 0;
        int num4 = 0;

        do{
            num4++;
            num3=num3+num4; 
        } while (num3<10000);
        System.out.println(num4);
    }
}