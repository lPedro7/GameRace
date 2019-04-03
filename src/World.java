import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.LinkedList;

public class World {
    static LinkedList<Obstacle> listaObstaculos = new LinkedList<Obstacle>();
    int sc = Player.score;
    float velocidad = 2;
    float distanciaEntreObstacles = 240;
    World() {
        crearObstaculosIniciales();
    }


    public void update(GameContainer gameContainer) throws SlickException {


        for (int j = 0; j < listaObstaculos.size();  j++) {
            listaObstaculos.get(j).bajarObs(velocidad);

            if (listaObstaculos.getLast().y >= 240){
                crearObstaculosIniciales();
            }

            if (listaObstaculos.getFirst().y > 600){
                listaObstaculos.removeFirst();
            }

        }


        sc++;


    }



    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        for (int i = 0; i < listaObstaculos.size(); i++) {

            if (listaObstaculos.get(i).y>0){
                // RENDERIZAMOS
                listaObstaculos.get(i).render(graphics,gameContainer);
            }
        }

        velocidad+=0.001;
        distanciaEntreObstacles += 0.02;

    }




    public  void crearObstaculosIniciales(){
        Obstacle o;
        float posicion = 0;

        for (int i = 0; i < 10; i++) {
            o = new Obstacle(posicion);
            posicion-=distanciaEntreObstacles;
            listaObstaculos.add(o);

        }



    }
}
