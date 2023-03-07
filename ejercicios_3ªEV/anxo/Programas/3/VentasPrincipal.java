import java.util.Scanner;

public class VentasPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt = 1;
        int ano = 0;

        if (args.length != 0) {
            ano = Integer.parseInt(args[0]);
        }

        do {
            if (ano == 0) {
                System.out.println("\nIntroduce el anho a consultar");
                ano = sc.nextInt();
            }
            Ventas ex1 = new Ventas();
            ex1.setAno(ano);
            ex1.grafica();
            System.out.printf("\nLa media de ganancias es %.2f", ex1.media());
            ano = 0;
            System.out.println("\n\nQuieres consultar otro anho \n1 - Si\n2 - No");
            opt = sc.nextInt();
        } while (opt == 1);
    }
}
