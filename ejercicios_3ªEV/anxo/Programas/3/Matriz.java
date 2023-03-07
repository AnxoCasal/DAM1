public class Matriz{

      int[][] Matriz;

    /**
     * Da valores aleatorios entre 1 y 10 a un array bidimensional
     * @param N Valor usado para dimensionar la tabla
     */
    public Matriz(int N){
        
        Matriz = new int[N][N];

        for(int i= 0;i<Matriz.length ;i++){
            for(int j=0;j<Matriz[i].length;j++){
                Matriz[i][j] = (int)(Math.random()*9+1);
            }
        }
    }

    /**
     * Muestra la matriz en fomato tabla con indices en columnas y filas
     */
    public static void grafica(int[][] matriz){

        int indice = 0;
        
        for(int[] fila : matriz){
            System.out.printf("%3d ",indice);
            indice++;
        }

        System.out.printf("%3d\n\n",indice);
        indice = 1;

        for(int[] fila : matriz){
                System.out.printf("%3d",indice);
            for(int item : fila){
                System.out.printf(" %3d",item);
            }
            indice++;
            System.out.println("\n");
        }
    }

    /**
     * Suma todos los valores de la matriz
     * @return variable int con el valor de la suma
     */
    public int suma() {

        int suma = 0;
        for(int[] fila : Matriz){
            for (int item : fila){
                suma = suma + item;
            }
        }
     
        return suma;

    }

    /**
     * Funcion a la que se le pasa un valor true o false, si es true suma la diagonal de la matriz, si es false suma todos los valores y le resta la diagonal
     * @param opt Booleano con el que se decide que valor devuelve
     * @return devuelve un int con el valor que se haya decidido
     */
    public int suma(boolean opt){

        int aux = 0;
        int i = 0;

            do{
                aux = aux + Matriz[i][i];
                i++;
            } while (i<Matriz.length);

            if(opt==true){
                return aux;
            } else{
                aux = suma() - aux;
                return aux;
            }
    }

    /**
     * Se Elige una fila de la matriz y la suma
     * @param fila Indice de la linea a sumar
     * @return Int con el valor de la suma
     */
    public int suma(int fila) {
        
        int suma = 0;

        if(fila<0||fila>Matriz.length||fila==Matriz.length){
            return -1;
        } else {
            for(int item : Matriz[fila]){
                suma = suma + item;
            }
            return suma;
        }
    }

    /**
     * Elimina la fila seleccionada de la matriz
     * @param except Indice de la linea a borrar
     */
    public int[][] borraFila(int except, int[][] matriz){

        

        return matriz;
    }
}