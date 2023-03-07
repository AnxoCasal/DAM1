import java.util.Scanner;

public class boletin16 {
    
    public static void main(String[]args){

        Scanner sc = new Scanner (System.in);
        int num;
        int opt;
        int intento;
        int oport = 5;

        do{
            do{
                    System.out.println("Dame un numero entre el 1 y el 100");
                    num = sc.nextInt();
                    if(num<0||num>100);{
                        System.out.println("Numero invalido, ingrese otro\n");
                    }
            }while (num>100||num<0); 

            for(int cont = 0; cont < 30; cont++){
                System.out.println("\n");
            }

            do{
                System.out.println("Adivina el numero");
                System.out.println("Te quedan "+oport+" intentos");
                intento = sc.nextInt();
                if (intento==num){
                    oport= -1;
                    System.out.println("\n Has adivinado!");
                } else {
                    if(intento<0||intento>100){
                        System.out.println("Numero invalido\n");
                    } else {
                    oport--;
                        if(intento<num){
                            System.out.println("\n Te quedas corto!\n");
                        } else {
                        System.out.println("\n Te has pasado!\n");
                        }
                }
                    
                    if (oport==0){
                        System.out.println("Has perdido! El numero era "+num);
                    }
                }
            }while(oport>0);

            System.out.println("\n Otra partida \n 1- Si \n 2- Salir");
            opt = sc.nextInt();

            oport = 5;

        }while(opt==1);
    }
}
