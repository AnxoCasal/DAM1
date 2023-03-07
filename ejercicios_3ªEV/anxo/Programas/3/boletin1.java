import java.util.Scanner;
import java.util.Vector;

public class boletin1{

    static int[] nums(int N){

        int[] numeros;

        numeros = new int[N];

        for(int i = 0; i < numeros.length; i++){
            numeros[i] = (int)(Math.random()*4001+1000);
        }

        return numeros; 
    }

    static void nums2(int[] numeros){

        for(int item : numeros){
            System.out.println(item);
        }

    }
    
    static int nums3(int[] numeros){

        int max = numeros[0];

        for(int i = 0; i < numeros.length; i++){
            if(numeros[i]>max){
                max = numeros[i];
            }
        }

        return max;

    }
    
    static int nums4(int[] numeros){

        int min = numeros[0];

        for(int item : numeros){
            if(item<min){
                min = item;
            }
        }

        return min;

    }

    static boolean nums5(int[] numeros, int i1, int i2){

        if(i1>=numeros.length||i2>=numeros.length||i1<0||i2<0){
            return false;
        } else {

            System.out.println(numeros[i1]);
            System.out.println(numeros[i2]);

            int aux = numeros[i1];
            numeros[i1] = numeros[i2];
            numeros[i2] = aux;

            System.out.println(numeros[i1]);
            System.out.println(numeros[i2]);
            return true;
        }
        

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int N = sc.nextInt();

        int[] numeros = nums (N);

        nums2(numeros);

        int max = nums3(numeros);

        System.out.println(max);

        int min = nums4(numeros);

        System.out.println(min);

        int i1 = sc.nextInt();

        int i2 = sc.nextInt();



        System.out.println(nums5(numeros,i1,i2));

    }
}