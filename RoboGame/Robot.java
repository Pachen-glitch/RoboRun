import greenfoot.*;

public class Robot extends Actor {
    private GreenfootImage quieto = new GreenfootImage("robot_quieto.PNG");
    private GreenfootImage camina = new GreenfootImage("robot_camina.png");
    private GreenfootImage muerto = new GreenfootImage("robot_muerto.png");
    private boolean alternar = false;

    public Robot() {
        quieto.scale(32, 32);
        camina.scale(32, 32);
        muerto.scale(32, 32);
        setImage(quieto); // Imagen inicial
    }

    public void act() {
        mover();
        recogerGemas();
        verificarColision();
    }

    private void mover() {
        int dx = 0;
        int dy = 0;

        if (Greenfoot.isKeyDown("right")) {
            dx = 2;
        } else if (Greenfoot.isKeyDown("left")) {
            dx = -2;
        } else if (Greenfoot.isKeyDown("up")) {
            dy = -2;
        } else if (Greenfoot.isKeyDown("down")) {
            dy = 2;
        }

        if ((dx != 0 || dy != 0) && !hayPared(dx, dy)) {
            setLocation(getX() + dx, getY() + dy);
            alternarImagen();
        }
    }

    private void alternarImagen() {
        if (alternar) {
            setImage(quieto);
        } else {
            setImage(camina);
        }
        alternar = !alternar;
    }

    private boolean hayPared(int dx, int dy) {
        int nuevoX = getX() + dx;
        int nuevoY = getY() + dy;

        setLocation(nuevoX, nuevoY);
        boolean tocaPared = isTouching(Pared.class);
        setLocation(getX() - dx, getY() - dy);

        return tocaPared;
    }

    private void recogerGemas() {
        Actor gema;

        gema = getOneIntersectingObject(GemaRoja.class);
        if (gema != null) {
            getWorld().removeObject(gema);
            ((MundoJuego)getWorld()).getContador().agregarPuntos(10);
        }

        gema = getOneIntersectingObject(GemaVerde.class);
        if (gema != null) {
            getWorld().removeObject(gema);
            ((MundoJuego)getWorld()).getContador().agregarPuntos(1);
        }

        gema = getOneIntersectingObject(GemaAzul.class);
        if (gema != null) {
            getWorld().removeObject(gema);
            ((MundoJuego)getWorld()).getContador().agregarPuntos(25);
        }
    }

    private void verificarColision() {
        if (isTouching(Hongo.class)) {
            ((MundoJuego)getWorld()).getContador().quitarMitadPuntos();
            setImage(muerto);
            Greenfoot.stop();
        }
    }
}

