import java.util.Scanner;

public class boletin15 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opt;
        Double moneda;
        Double conversion = 1.17;
        Double result;

        do {

            System.out.println("----------------------------- \n" 
                    + " 1- Convertir libras a euros \n"
                    + " 2- Convertir euros a libras \n"
                    + " 3- Salir                    \n"
                    + "-----------------------------");

            opt = sc.nextInt();

            switch (opt) {
            case 1:
                do{
                    System.out.println("Introduce una cantdad de libras");
                    moneda = sc.nextDouble();
                    if (moneda < 0){
                        System.out.println("No es un valor valido");
                    }
                }while (moneda<=0);
            
            result= moneda*conversion;
            System.out.printf("%.2f\n", result);
                
                break;

            case 2:
            do{
                System.out.println("Introduce una cantdad de euros");
                moneda = sc.nextDouble();
                if (moneda < 0){
                    System.out.println("No es un valor valido");
                }
            }while (moneda<=0);
            
            result= moneda/conversion;
            System.out.printf("%.2f\n", result);
                
                break;

            case 3:
                break;
            }

        } while (opt != 3);

    }
}