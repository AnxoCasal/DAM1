
package areas;

import areas.milibreria.Areas;
import areas.milibreria.InterfazUsuario;

public class Principal {
 public static void main(String[] args) {
 InterfazUsuario iu = new InterfazUsuario();
 double lado, area;

 System.out.println("Vamos a calcular el área de un pentágono");
 lado=iu.pideRealPositivo("Introduce el lado (debe ser positivo)");
 area=Areas.pentagonoRegular(lado);
 iu.muestraArea(area);
 }
}
