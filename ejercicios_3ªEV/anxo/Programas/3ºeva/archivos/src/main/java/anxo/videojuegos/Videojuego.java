package anxo.videojuegos;

public class Videojuego {

    private String fabricante, titulo;
    private int año;

    public void setfabricante(String nombre) {
        this.fabricante = nombre.toUpperCase();
    }

    public String getfabricante() {
        return fabricante;
    }

    public void settitulo(String nombre) {
        this.titulo = nombre.toUpperCase();
    }

    public String gettitulo() {
        return titulo;
    }

    public void setaño(int año) {
        if (año < 1950) {
            this.año = 2022;
        } else {
            this.año = año;
        }
    }

    public int getaño() {
        return año;
    }

    public Videojuego(String fabricante, String titulo, int año) {
        this.settitulo(titulo);
        this.setfabricante(fabricante);
        this.setaño(año);
    }
}
