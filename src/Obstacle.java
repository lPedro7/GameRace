import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Obstacle {

    Rectangle r;
    Rectangle r2;
    int y = 0;
    int width1 = (int) (Math.random()*800);
    int yRect2 = 1000-width1-200;

    public Obstacle() {


    }

    public void update(GameContainer gameContainer, int i) {
        //Velocitat de l'obstacle
        y += 4;

    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        //Cream l'obstacle, que consisteix en dos rectangules amb un espaiat entre els dos
        r = new Rectangle(0, y, width1, 6);
        r2 = new Rectangle(width1+200,y,1000-width1-200,6);


    }

}
