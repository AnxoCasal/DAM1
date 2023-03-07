import java.util.Scanner;

public class eje1 {


/**
 * @param
 * @return
 */
    static int funcion(int num1, int num2){

    int resultado = 1;

    if(num2>0){
        for(int cont = 0; cont<num2; cont++){
            resultado = resultado * num1;
        }
    } else{
        num2 = num2 * -1;
        resultado = num1 / num2;
    }

    return resultado;

    }
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);


        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println(funcion(num1,num2));

    }
}
//or = ||
//switch (numeroMes) {
//    case 1: cadenaMes = "Enero";
//    break;
//    case 2: cadenaMes = "Febrero";
//    break;
//    default:cadenaMes = "Mes inválido";
//    break;
//  }

//String dato="231";
//int num = Integer.parseInt(dato);
//
//
//dato=""+num;
//
//
//
//double n1=12.65;
//int n2;
//n2=(int)n1;
//System.out.println(n1+"\n"+n2);
//
//System.out.printf("Con %.2f salen 2 decimales y con %.4f\n" 4, Math.PI, 2 * Math.PI);