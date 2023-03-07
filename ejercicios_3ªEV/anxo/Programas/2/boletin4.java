import java.util.Scanner;

public class boletin4 {
    
/**
 * Funcion que realiza la potencia de los datos introducidos
 * @param base Base de la potencia
 * @param expo Exponente de la potencia
 * @return Resultado de la operacion
 */
    static double potencia(double base, long exp){

    double resultado= 1;

    if(exp==1){
        resultado=base;
        return resultado;
    }

    if(exp<0){
        for(int cont=0; cont>exp; cont--){
            resultado= resultado*base;
        }
        resultado=1/resultado;
        return resultado;
    }else{
        for(int cont=0; cont<exp; cont++){
            resultado= resultado*base;
        }
        return resultado;
    }
    }
    public static void main(String[]args){

        Scanner sc = new Scanner (System.in);
        double base;
        long exp;

        System.out.println("Dame la base y el exponente de tu potencia");
        base = sc.nextDouble();
        exp = sc.nextLong();

        System.out.println(potencia(base, exp));
    }
}