import greenfoot.*;

public class Gato extends Actor {
    private int velocidad = 2;

    public Gato() {
        
        GreenfootImage img = new GreenfootImage("gato.png");
        img.scale(32, 32);
        setImage(img);
    }
    private boolean hayPared(int dx, int dy) {
        int nuevoX = getX() + dx;
        int nuevoY = getY() + dy;

        setLocation(nuevoX, nuevoY);
        boolean tocaPared = isTouching(Pared.class);
        setLocation(getX() - dx, getY() - dy);

        return tocaPared;
    }

    public void act() {
        mover();
        verificarBordes();
        verificarColision();
    }

    private void mover() {
    // Verificar si hay pared en la dirección a la que se mueve
    if (hayPared(velocidad, 0)) {
        // Cambiar dirección
        velocidad = -velocidad;
        turn(180);
    } else {
        // Mover normalmente
        setLocation(getX() + velocidad, getY());
    }
}

    private void verificarBordes() {
        if (getX() <= 10 || getX() >= getWorld().getWidth() - 10) {
            velocidad = -velocidad;
            turn(180);
        }
    }

    private void verificarColision() {
        Actor robot = getOneIntersectingObject(Robot.class);
        if (robot != null) {
            ((MundoJuego)getWorld()).getContador().quitarMitadPuntos();
            getWorld().removeObject(robot);
            ((MundoJuego)getWorld()).programarReinicio(180); // 3 segundos
        }
    }
}
