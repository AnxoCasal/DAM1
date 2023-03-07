import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;

public class boletin3{

    static ArrayList<Integer> nums(int N){

        ArrayList<Integer> numeros = new ArrayList<Integer>();

        for(int i = 0; i < N; i++){
            numeros.add (i,(int)(Math.random()*4001+1000));
        }

        return numeros; 
    }

    static void nums2(ArrayList<Integer> numeros){

        for(int item : numeros){
            System.out.println(item);
        }

    }
    
    static int nums3(ArrayList<Integer> numeros){

        int max = numeros.get(0);

        for(int i = 0; i < numeros.size(); i++){
            if(numeros.get(i)>max){
                max = numeros.get(i);
            }
        }

        return max;

    }
    
    static int nums4(ArrayList<Integer> numeros){

        int min = numeros.get(0);

        for(int item : numeros){
            if(item<min){
                min = item;
            }
        }

        return min;

    }

    static boolean nums5(ArrayList<Integer> numeros, int i1, int i2){

        if(i1>=numeros.size()||i2>=numeros.size()||i1<0||i2<0){
            return false;
        } else {

            System.err.println(numeros.get(i1));
            System.err.println(numeros.get(i2));

            int aux = numeros.get(i1);
            numeros.set(i1, numeros.get(i2));
            numeros.set(i2, aux);

            System.err.println(numeros.get(i1));
            System.err.println(numeros.get(i2));
            return true;
        }
        

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int N = sc.nextInt();

        ArrayList<Integer> numeros = nums (N);

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
