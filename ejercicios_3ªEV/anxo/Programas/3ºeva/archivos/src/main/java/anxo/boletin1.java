package anxo;

import java.io.File;
import java.util.Scanner;

public class boletin1 {
    public static void main(String[] args) {

        String path = "";
        File f = new File(path);
        boolean Salir = true;
        Scanner sc = new Scanner(System.in);

        do {

            System.out.println(
                    "\n¿Que quieres hacer?\n1- Seleccionar archivo o directorio\n2- Mostrar informacion\n3- Crear directorio\n4- Salir\n");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:

                    f = boletin1.seleccion();

                    break;

                case 2:

                    if (f.exists()) {
                        boletin1.info(f);
                    } else {
                        System.out.println("Ningun archivo seleccionado\n");
                    }

                    break;

                case 3:

                    boletin1.crear();

                    break;

                case 4:

                    Salir = false;

                    break;

                default:

                    Salir = false;

                    break;
            }
        } while (Salir);

    }

    public static File seleccion() {

        boolean error = false;
        String path;
        File f;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Introduzca la ruta del archivo");
            path = sc.nextLine();
            f = new File(path);
            if (f.exists()) {
                error = true;
                System.out.println("Ruta valida");
            } else {
                System.out.println("Ruta invalida");
            }
        } while (!error);

        return f;

    }

    public static void info(File f) {

        if (f.isFile()) {
            System.out.println(f.getName());
            System.out.println(f.getParent());
        } else if (f.isDirectory()) {
            File[] files = f.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    System.out.println(files[i].getName());
                    System.out.println(files[i].length());
                }
            }
        }

    }

    public static void crear() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Eliga un nombre para el directorio");
        String nombre = sc.nextLine();
        File directorio = new File(nombre);

        directorio.mkdir();
        if(directorio.exists()){
            System.out.println("El directorio se creo adecuadamente");
        } else {
            System.out.println("Ah ocurrido un error en la creacion del archivo");
        }
        
    }

}