import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;

//Aquesta classe s'encarrega de crear els obstacles
public class Obstacle {

    //L'obstacle es divideix en dos rectangles, amb un espai entre tot dos
    //Cream les variables del rectangle
    Rectangle r;
    Rectangle r2;
    //Altura de l'obstacle
    float y;
    //Cream les variables del tamany dels dos rectangles
    int width1;
    int width2 = 1000 - this.width1 - 200;

    public Obstacle(float y) {
        //Definim l'altura
        this.y = y;
        //El tamany de l'obstacle és aleatori, com a màxim de 800 píxels de llargària
        this.width1 = (int) (Math.random() * 800);

    }


    public void render(Graphics g, GameContainer gc) throws SlickException {

        //Cream l'obstacle, que consisteix en dos rectangules amb un espaiat entre els dos
        r = new Rectangle(0, this.y, width1, 6);
        int sep = 200;
        r2 = new Rectangle(this.width1 + sep, this.y, width2, 6);
        //Dibuixam els dos obstacles
        g.draw(r);
        g.draw(r2);


    }

    //Aquesta és la funció que farà baixar els obstacles amb la seva separació i velocitat pertinent
    public void bajarObs(float aumento) {
        this.y += aumento;
    }


}



