import java.util.Scanner;

public class boletin2{


    static char[][] nums1(int N, int M){

        char[][] tabla = new char[N][M];;

        for(int i = 0; i < tabla.length; i++){
            for(int j = 0; j < tabla[i].length; j++){
                tabla[i][j] = (char)(Math.random()*25+'A'); 
            }
        }

        return tabla;
    }

    static void nums2(char[][] matriz){ 

        String tabla = "";

        for(char[] fila : matriz){
            for (char item : fila){
                tabla = tabla + item + "  ";
            }
            tabla = tabla + "\n";
        }

        System.out.println(tabla);

    }
    
    static char nums3(char[][] tabla){

        char max = tabla[0][0];

        for(int i = 0; i < tabla.length; i++){
            for(int j = 0; j < tabla[i].length; j++){
                if(tabla[i][j]>max){
                    max = tabla[i][j];
                }
            }
        }

        return max;

    }
    
    static char nums4(char[][] tabla){

        char min = tabla[0][0];

        for(char[] fila : tabla){
            for (char item : fila){
                if(item<min){
                    min = item;
                }
            }
        }

        return min;

    }

    static boolean nums5(char[][] matriz, int i1, int i2, int i3, int i4){

        if(i1>=matriz.length||i2>=matriz[i1].length||i3>=matriz.length||i4>=matriz[i3].length||i1<0||i2<0||i3<0||i4<0){
            return false;
        } else {

            System.err.println(matriz[i1][i2]);
            System.err.println(matriz[i3][i4]);

            char aux = matriz[i1][i2];
            matriz[i1][i2] = matriz[i3][i4];
            matriz[i3][i4] = aux;

            System.err.println(matriz[i1][i2]);
            System.err.println(matriz[i3][i4]);
            
            return true;
        }
        

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] matriz = nums1(N,M);

        nums2(matriz);

        System.out.println(nums3(matriz));

        System.out.println(nums4(matriz));

        int i1 = sc.nextInt();

        int i2 = sc.nextInt();
        
        int i3 = sc.nextInt();
        
        int i4 = sc.nextInt();

        
        System.out.println(nums5(matriz,i1,i2,i3,i4));
    }
}