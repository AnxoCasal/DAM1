public class Principal {
    
    public static void intercambiaRadios(Pelota pelota1, Pelota pelota2){
        double aux;
        aux = pelota1.getRadio();
        pelota1.setRadio(pelota2.getRadio());
        pelota2.setRadio(aux);
    }



    public static void main(String[]args){

        Pelota pelo = new Pelota();
        pelo.tipo = "baloncesto";
        pelo.setRadio(20);

        System.out.printf("El radio de pelo es %.2f y es de tipo %s\n",
                            pelo.getRadio(), pelo.tipo);
        
        
        Pelota p2 = new Pelota();
        Pelota p3 = new Pelota("Futbol", 22);

        System.out.printf("El radio de pelo es %.2f y es de tipo %s\n",
                            p2.getRadio(), p2.tipo);
        System.out.printf("El radio de pelo es %.2f y es de tipo %s\n",
                            p3.getRadio(), p3.tipo);

        p2.inflar();
        p3.inflar(10);

        System.out.printf("El radio de pelo es %.2f y es de tipo %s\n",
                            p2.getRadio(), p2.tipo);
        System.out.printf("El radio de pelo es %.2f y es de tipo %s\n",
                            p3.getRadio(), p3.tipo);


        intercambiaRadios(p2,p3);

        System.out.printf("El radio de pelo es %.2f y es de tipo %s\n",
                            p2.getRadio(), p2.tipo);
        System.out.printf("El radio de pelo es %.2f y es de tipo %s\n",
                            p3.getRadio(), p3.tipo);
    }
}