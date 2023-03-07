import java.util.Scanner;

import javax.print.attribute.standard.Media;

public class arrays {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);

        int[] numeros;

        numeros = new int[10];

        for(int i = 0; i < numeros.length; i++){
            numeros[i] = sc.nextInt();
        }

        int media = 0;

        for(int item : numeros){
            media = media + item;
        }

        for(int item : numeros){
            System.out.println(item);
        }

        System.out.println(media/numeros.length);

    }
}
