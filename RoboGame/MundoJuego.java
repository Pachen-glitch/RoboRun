import greenfoot.*;

public class MundoJuego extends World {
    private Contador contador;
    private int tiempoReinicio = -1;

    public MundoJuego() {
        super(800, 600, 1); // por ejemplo, 800x600 píxeles
        
        // Crear imagen de fondo vacía
        GreenfootImage fondo = new GreenfootImage(getWidth(), getHeight());
        // Cargar bloque de arena (imagen existente en la carpeta images)
        GreenfootImage arena = new GreenfootImage("sand.png");
        // Dibujar la arena repetidamente para cubrir todo el fondo
        for(int x = 0; x < fondo.getWidth(); x += arena.getWidth()) {
            for(int y = 0; y < fondo.getHeight(); y += arena.getHeight()) {
                fondo.drawImage(arena, x, y);
            }
        }
        // Asignar la imagen mosaico como fondo estático del mundo
        setBackground(fondo);
        

        prepare();
    }


    public void act() {
        if (tiempoReinicio > 0) {
            tiempoReinicio--;
        } else if (tiempoReinicio == 0) {
            Greenfoot.setWorld(new MundoJuego());
        }
    }

    public void programarReinicio(int frames) {
        tiempoReinicio = frames;
    }

    public Contador getContador() {
        return contador;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        // Crear y agregar el contador
        contador = new Contador();
        addObject(contador, 70, 30); // Puedes ajustar la posición

        // Resto de los objetos
        Robot robot = new Robot();
        addObject(robot, 99, 215);

        Gato gato = new Gato();
        addObject(gato, 422, 124);
        Pared pared = new Pared();
        addObject(pared,784,344);
        Pared pared2 = new Pared();
        addObject(pared2,752,352);
        pared2.setLocation(755,344);
        Pared pared3 = new Pared();
        addObject(pared3,730,348);
        pared3.setLocation(719,346);
        pared3.setLocation(724,344);
        Pared pared4 = new Pared();
        addObject(pared4,675,340);
        pared4.setLocation(695,349);
        pared4.setLocation(698,346);
        pared4.setLocation(696,344);
        Pared pared5 = new Pared();
        addObject(pared5,644,265);
        pared5.setLocation(697,315);
        GemaRoja gemaRoja = new GemaRoja();
        addObject(gemaRoja,732,307);
        gemaRoja.setLocation(728,311);
        pared5.setLocation(700,312);
        pared5.setLocation(697,312);
        GemaAzul gemaAzul = new GemaAzul();
        addObject(gemaAzul,172,216);
        Pared pared6 = new Pared();
        addObject(pared6,389,145);
        pared6.setLocation(376,125);
        Pared pared7 = new Pared();
        addObject(pared7,701,272);
        pared7.setLocation(700,277);
        pared7.setLocation(697,282);
        Pared pared8 = new Pared();
        addObject(pared8,664,274);
        pared8.setLocation(667,287);
        pared8.setLocation(665,283);
        GemaRoja gemaRoja2 = new GemaRoja();
        addObject(gemaRoja2,184,268);
        GemaAzul gemaAzul2 = new GemaAzul();
        addObject(gemaAzul2,184,315);
        Hongo hongo = new Hongo();
        addObject(hongo,137,404);
    }

}
