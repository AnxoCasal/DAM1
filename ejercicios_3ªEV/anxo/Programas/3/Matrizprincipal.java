import java.util.Scanner;

public class Matrizprincipal{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N;

        do{
            System.out.println("De que proporciones quieres que sea la tabla");
            N = sc.nextInt();
            if(N<2){
                System.out.println("Necesario un valor 2 o superior\n");
            }
        }while(N<2);

        Matriz ex1 = new Matriz(N);
        
        int opt = 0;

        do{
            System.out.println(
                "\n1- Mostrar matriz."+
                "\n2- Mostrar suma de todos los elementos."+
                "\n3- Mostrar suma de la diagonal."+
                "\n4- Mostrar suma de los elementos salvo diagonal"+
                "\n5- Mostrar suma de elementos de una fila."+
                "\n6- Mostrar matriz sin una fila."+
                "\n7- Salir.\n"
            );
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    
                Matriz.grafica(ex1.Matriz);

                    break;
            
                case 2:
                
                System.out.println(ex1.suma());
                    
                    break;
            
                case 3:
                
                System.out.println("La suma de la diagonal es: "+ex1.suma(true));
                    
                    break;
            
                case 4:
                
                System.out.println("La suma de todos los valores menos la diagonal es: "+ex1.suma(false));
                    
                    break;
            
                case 5:

                System.out.println("Selecciona la fila a sumar");
                int fila = sc.nextInt()-1;
                System.out.println("La suma de la fila seleccionada es: "+ ex1.suma(fila));
                    
                    break;
            
                case 6:

                System.out.println("Selecciona la fila a eliminar");
                fila = sc.nextInt()-1;
                Matriz.grafica(ex1.borraFila(fila,ex1.Matriz));
                    
                    break;

                default:
                    break;
            }
        } while (opt!=7);
    }
}