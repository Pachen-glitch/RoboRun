import greenfoot.*; // Incluye Actor, GreenfootImage, etc.
import greenfoot.Color; // Usa esta para los colores

public class Contador extends Actor {
    private int puntos = 0;

    public Contador() {
        actualizarImagen();
    }

    public void agregarPuntos(int valor) {
        puntos += valor;
        actualizarImagen();
    }

    public void quitarMitadPuntos() {
        puntos = puntos*0;
        actualizarImagen();
    }

    public int getPuntos() {
        return puntos;
    }

    private void actualizarImagen() {
        setImage(new GreenfootImage("Puntos: " + puntos, 24, Color.WHITE, Color.BLACK));
    }
}

