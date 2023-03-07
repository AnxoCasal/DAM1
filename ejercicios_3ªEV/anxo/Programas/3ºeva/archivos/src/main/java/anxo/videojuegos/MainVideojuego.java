package anxo.videojuegos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainVideojuego {

    public static void main(String[] args) throws IOException {

        ArrayList<Videojuego> coleccionVideojuegos = new ArrayList<Videojuego>();
        //Videojuego sonic = new Videojuego("sega", "sonic", 2001);
        //Videojuego mario = new Videojuego("nintendo", "mario", 2002);
        //Videojuego zelda = new Videojuego("nintendo", "zelda", 2003);
        //coleccionVideojuegos.add(sonic);
        //coleccionVideojuegos.add(mario);
        //coleccionVideojuegos.add(zelda);
        boolean salir = true;
        Scanner sc = new Scanner(System.in);
        String titulo = "";
        String fabricante = "";
        int año;
        String añotxt;
        int cont = 0;
        String aux;
        boolean notfound = true;

        try {

            File file = new File("C://Users//Anxo//Documents//Coleccion.txt");
            file.createNewFile();
            if (!file.exists()) {
                System.out.println("El archivo no existe");
            } else {

                try (Scanner f = new Scanner(new File("C://Users//Anxo//Documents//Coleccion.txt"))) {

                    while (f.hasNext()) {
                        if (cont == 3) {
                            añotxt = f.nextLine();
                            año = Integer.parseInt(añotxt);
                            Videojuego nuevo = new Videojuego(fabricante, titulo, año);
                            coleccionVideojuegos.add(nuevo);
                            cont = 0;
                        } else if (cont == 2) {
                            fabricante = f.nextLine();
                            cont++;
                        } else if (cont == 1) {
                            titulo = f.nextLine();
                            cont++;
                        } else if (cont == 0) {
                            cont++;
                            f.nextLine();
                        }

                    }

                } catch (Exception e2) {
                    System.err.println("Error de acceso al archivo: " + e2.getMessage());
                }

                do {

                    System.out.println(
                            "\nBienvenida a la biblioteca de videojuegos, escoga una opcion:\n1- Nuevo\n2- Visualizar\n3- Buscar\n4- Eliminar\n5- Eliminar segun año\n6- Salir\n");
                    int opt = sc.nextInt();
                    sc.nextLine();

                    switch (opt) {
                        case 1:

                            System.out.println("¿Titulo?");
                            titulo = sc.nextLine();
                            System.out.println("¿?Fabricante");
                            fabricante = sc.nextLine();
                            System.out.println("¿Año?");
                            año = sc.nextInt();
                            Videojuego nuevo = new Videojuego(fabricante, titulo, año);
                            coleccionVideojuegos.add(nuevo);

                            break;
                        case 2:

                            for (int i = 0; i < coleccionVideojuegos.size(); i++) {
                                if (coleccionVideojuegos.get(i) != null) {
                                    System.out.println("\n" + coleccionVideojuegos.get(i).gettitulo() + "\n"
                                            + coleccionVideojuegos.get(i).getfabricante() + "\n"
                                            + coleccionVideojuegos.get(i).getaño());
                                }
                            }

                            break;
                        case 3:

                            System.out.println("\nQue juego quieres buscar?");
                            titulo = sc.nextLine();

                            for (int i = 0; i < coleccionVideojuegos.size(); i++) {
                                if (coleccionVideojuegos.get(i).gettitulo() != null
                                        && coleccionVideojuegos.get(i).gettitulo()
                                                .startsWith(titulo.toUpperCase()) == true) {
                                    System.out.println("\n" + coleccionVideojuegos.get(i).gettitulo() + "\n"
                                            + coleccionVideojuegos.get(i).getfabricante() + "\n"
                                            + coleccionVideojuegos.get(i).getaño());
                                    notfound = !notfound;
                                }
                            }
                            if (notfound) {
                                System.out.println("\nNo se encuentra el juego que buscas\n");
                            }

                            break;
                        case 4:

                            System.out.println("\nQue juego quieres eliminar?");
                            for (int i = 0; i < coleccionVideojuegos.size(); i++) {
                                System.out.printf("\n%d-\t%s", i, coleccionVideojuegos.get(i).gettitulo());
                            }
                            System.out.println("\n");
                            int indice = sc.nextInt();
                            sc.nextLine();
                            coleccionVideojuegos.remove(indice);

                            break;
                        case 5:

                            System.out.println("Elige el año para eliminar todo el registro");
                            int registro = sc.nextInt();
                            sc.nextLine();
                            for (int i = 0; i < coleccionVideojuegos.size(); i++) {
                                if (registro == coleccionVideojuegos.get(i).getaño()) {
                                    coleccionVideojuegos.remove(i);
                                }
                            }
                            break;

                        default:

                            file.delete();
                            file.createNewFile();

                            for (int i = 0; i < coleccionVideojuegos.size(); i++) {
                                if (coleccionVideojuegos.get(i) != null) {
                                    aux = "";
                                    año = coleccionVideojuegos.get(i).getaño();
                                    aux = coleccionVideojuegos.get(i).gettitulo() + "\n"
                                            + coleccionVideojuegos.get(i).getfabricante() + "\n"
                                            + año + "\n";

                                    try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
                                        pw.append("\n" + aux);
                                    } catch (Exception ee) {
                                        System.err.println("Error");
                                    }

                                }
                            }
                            salir = !salir;
                            break;
                    }

                } while (salir);
            }

        } catch (InputMismatchException e) {
            System.out.println("\nERROR de introduccion de datos\n");
        }

    }

}
