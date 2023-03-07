import java.time.LocalDate;

public class Ventas {

    LocalDate current_date = LocalDate.now();
    private int ano=current_date.getYear()-1;
    private int[] vector = new int[12];

    /**
     * Constructor que da valores al array
     * @param vector array con el que se trabaja
     */
    public Ventas(){
        for(int i=0; i<vector.length; i++){
            vector[i] =(int)(Math.random()*1000+1);
        }
    }

    /**
     * guarda el valor pasado en la variable ano, en caso de que el valor pasado sea mayor al actual o menor a cero no se modifica
     * @param ano nuevo valor para this.ano
     */
    public void setAno(int ano){
        if (ano<this.ano&&ano>0){
            this.ano=ano;
        }
    }

    /**
     * devuelve el valor de ano
     * @return int de ano
     */
    public int getAno(){
        return ano;
    }

    /**
     * Crea una media de la suma de todos los valores de un array
     * @vector array con el que se opera
     * @return devuelve un double de la media
     */
    public double media(){
        double media = 0;
        for(int item : vector){
            media = media + item;
        }
        media = media/12;
        return media;
    }
    
    /**
     * Muestra un grafica de las ganancias de cada mes del año elegido
     * @param anho año del que se muestran los datos
     */
    public void grafica() {
        System.out.println("\nAnho " + this.ano + " :");
        int mes = 0;
        for(int item : vector){
            String graf = "#";
            mes++;
            for(int i = 100; item>i; i= i+100){
                graf = graf + "#";
            }
            System.out.printf("\nMes %3d (%3d): %s", mes, item, graf);
        }
    }
}
