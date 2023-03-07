import java.util.Scanner;

public class boletin3 {

/**
 * Comprueba si es bisiesto el año introducido
 * @param anho numero a comprobar
 * @return resultado, true si es bisiesto y false si no lo es
 */
    static boolean bisiesto(int anho){

        if(anho%4==0){
            if(anho%400==0){
                return true;
            } else {
                if(anho%100==0){
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }

    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        int anho;

        do{

        System.out.println("Dame un anho");

        anho = sc.nextInt();

        boolean bisiesto= bisiesto(anho);

        System.out.println(bisiesto);

        
    }while(anho!=0);
}
}
