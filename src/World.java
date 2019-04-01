import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.LinkedList;

public class World {
    private LinkedList<Obstacle> listaObstaculos = new LinkedList<Obstacle>();

    void World(){
        Obstacle o = new Obstacle();
        listaObstaculos.push(o);
    }


    public void update(GameContainer gameContainer,int i) throws SlickException{
        for (int j = 0; j < listaObstaculos.size(); j++) {
            listaObstaculos.get(i).update();
        }


    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException{


        listaObstaculos.getLast().render();


        graphics.draw(listaObstaculos.peekLast().r);
        graphics.draw(listaObstaculos.peekLast().r2);


    }

}
