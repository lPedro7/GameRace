import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.LinkedList;

//En aquesta classe crearem tot lo que seria el mapa a on jugam
public class World {
    //Cream la llista d'obstacles
    static LinkedList<Obstacle> listaObstaculos = new LinkedList<Obstacle>();
    //La velocitat a la que baixen els obstacles
    float velocidad = 2;
    //La distancia que hi haurà entre obstacle i obstacle
    float distanciaEntreObstacles = 240;

    //El contructor cridara a la funcio que crea els obstacles per primera vegada
    World() {
        setObstacles();
    }


    public void update() {

        //Anirem indicant la velocitat a la que baixen els obstacles
        for (int j = 0; j < listaObstaculos.size(); j++) {
            listaObstaculos.get(j).bajarObs(velocidad);

            //Si el darrer obstacle passa de la altura de 260 píxels crearem nous obstacles
            if (listaObstaculos.getLast().y >= 260) {
                setObstacles();
            }

            //Quan el primer obstacle de la llista passi la pantalla, l'eliminam
            if (listaObstaculos.getFirst().y > 600) {
                listaObstaculos.removeFirst();
            }

        }


    }


    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        for (int i = 0; i < listaObstaculos.size(); i++) {
            //En el cas de que el primer obstacle superi l'altura 0, el dibuixarem
            if (listaObstaculos.get(i).y > 0) {

                listaObstaculos.get(i).render(graphics, gameContainer);
            }
        }
        //La velocitat i la distància entre obstàcles aniram aumentant gradualment
        velocidad += 0.001;
        distanciaEntreObstacles += 0.02;

    }

    //Cream una funcio per a crear els obstacles
    public void setObstacles() {
        Obstacle o;
        float posicion = 0;
        //Cream 5 obstacles, la distància entre tot dos es la "distanciaEntreObstacles", aquests obstacles
        //els afegim a la llista d'obstacles
        for (int i = 0; i < 5; i++) {
            o = new Obstacle(posicion);
            posicion -= distanciaEntreObstacles;
            listaObstaculos.add(o);

        }


    }
}
