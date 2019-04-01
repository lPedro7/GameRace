import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.LinkedList;

public class World {

    Obstacle obstaculo = new Obstacle();
    private LinkedList<Obstacle> listaObstaculos = new LinkedList<Obstacle>();



    public void World(){

        for (int i = 0; i < 10; i++) {
            listaObstaculos.push(obstaculo);
        }





    }


    public void update(GameContainer gameContainer,int i) throws SlickException{
        obstaculo.update(gameContainer,i);

        if (obstaculo.y == 300){
            obstaculo.update(gameContainer,i);

        }



        if (obstaculo.y > 600){
            obstaculo.y = -5;
            listaObstaculos.push(obstaculo);
        }



    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException{

        obstaculo.render(gameContainer,graphics);


        if (obstaculo.y == 300){
            obstaculo.render(gameContainer,graphics);
        }



            graphics.draw(obstaculo.r);
            graphics.draw(obstaculo.r2);







    }

}
