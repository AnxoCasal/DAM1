import java.util.Scanner;


public class Boletin4 {

/**Muestra la cadena de caracteres que se le pase, caracter a caracter
 * @param cadena String a mostrar
 */
    public static void muestraEnLinea(String cadena){

        for(int i = 0; i < cadena.length(); i++){
            System.out.println(cadena.charAt(i));  
        }
    }

/** Funcion al que se le pasa un string y devuelve la parte de el que se le indique
 * 
 * @param cadena String con el que trabaja
 * @param inicio caracter a partir del cual se comienza a coger
 * @param cant numero de caracteres a coger
 * @return fragmento del string
 */
    
    public static String subCadena (String cadena, int inicio, int cant){

        String fragmento = "";

        if(inicio>cadena.length()||inicio+cant>cadena.length()||inicio<0||cant<0){
            return fragmento;
        } else {
            for(int i = 0; i < cant; i++){
                fragmento = fragmento + cadena.charAt(inicio);
                inicio++;
            }
            return fragmento;
        }
    }

/** Muestra un string centrado en una CMD suponiendo que mide 80 espacios
 * @param cadena string con la que se trabaja
 */
    public static void muestraCentrado(String cadena){

        String espacio = "";
        int cant = 40-(cadena.length()/2);

        for(int i = 0; i<cant; i++){
            espacio= espacio + " ";
        }
        System.out.println(espacio + cadena + espacio);
    }
/** Funcion que crea un vector de chars con cada caracter de un string 
 * 
 * @param cadena string con el que se trabaja
 * @return el vector de char
 */
    public static char[] cadenaAVector(String cadena){

        char []vector = new char[cadena.length()];

        for(int i = 0; i < cadena.length(); i++){
            vector[i] = cadena.charAt(i);
        }

        return vector;

    }

/** Funcion que cambia el orden de un string 
 * 
 * @param cadena string con el que se trabaja
 * @return string en orden inverson
 */
    public static String alReves(String cadena) {
        String reves = "";

        for(int i = cadena.length()-1; i >= 0 ; i-- ){
            reves = reves + cadena.charAt(i);
        }

        return reves;
    }

/** Cooncatena una serie indefinida de strings y los pasa a mayusculas y convierte las _ en espacios
 * 
 * @param cadena
 * @return String conjunto de los strings
 */
    public static String pasoAMayusculas(String ... cadena) {
        
        String mayus = "";

        for(String item : cadena){
            for(int i = 0; i < item.length(); i++){

                char aux = item.charAt(i);

                if(aux>=97&&aux<=122){
                    aux = (char)(aux - 32);
                    mayus = mayus + aux;
                } else {
                    if (item.charAt(i)==95){
                        mayus = mayus + " ";
                    } else {
                        mayus = mayus + aux;
                    }
                } 
            }
        }

        return mayus;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cadena = sc.nextLine();

        muestraEnLinea(cadena);

        int i = sc.nextInt();
        int j = sc.nextInt();

        System.out.println(subCadena(cadena, i, j));

        muestraCentrado(cadena);
        
        System.out.println(cadenaAVector(cadena));

        System.out.println(alReves(cadena));

        System.out.println(pasoAMayusculas("casa", "arBOl_frutal", "coche", "ABCabcáéíñÑ!·$%&/ _*"));
    }

}
