public class GeometriaPrincipal{

    public static void main(String[] args) {
        Geometria rectangulo = new Geometria(true, 2 ,3);
        Geometria triangulo = new Geometria();
        triangulo.setAltura(2);
        triangulo.setBase(5);

        System.out.printf("Es un %s, la altura es de %d la base es de %d el perimetro es de %f el area de %f y la diagonal es de %f\n",
                            rectangulo.tipo(),rectangulo.getAltura(),rectangulo.getBase(),rectangulo.perimetro(),rectangulo.area(), rectangulo.diagonal());

        System.out.printf("Es un %s, la altura es de %d la base es de %d el perimetro es de %f el area de %f y la diagonal es de %f\n",
                            triangulo.tipo(),triangulo.getAltura(),triangulo.getBase(),triangulo.perimetro(),triangulo.area(), triangulo.diagonal());
    }
}