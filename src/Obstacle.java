import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

public class Obstacle {

    Rectangle r;
    Rectangle r2;
    private int separacion=200;
    float y ;
    int width1;
    int width2 = 1000-this.width1-200;
    float distanciaEntreObstacles = 240;

    public Obstacle(float y) {

        this.y=y;
        this.width1 =  (int) (Math.random()*800);;

    }


    public void render(Graphics g, GameContainer gc) throws SlickException {

        //Cream l'obstacle, que consisteix en dos rectangules amb un espaiat entre els dos
        r = new Rectangle(0,this.y,width1,6);
        r2 = new Rectangle(this.width1+separacion,this.y,width2,6);

        g.draw(r);
        g.draw(r2);
    }



    public void bajarObs(float aumento){
        this.y+=aumento;
    }


    public void interseccion(Circle c){

    }


}
