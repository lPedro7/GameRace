import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;

//Definirem el jugador
public class Player {
    //puntuació del jugador
    int score = 0;
    //Altura del jugador
    int y = 500;
    //Posicio horitzontal del jugador
    int x = 550;
    //Icona del personatge
    private Image img;

    float velocidad = 10;

    void update(GameContainer gameContainer, int i){
        //Si l'usuari pressiona un botó
        Input input = gameContainer.getInput();
        //En cas de que sigui fletxa a l'esquerra o A es moura 4 pixels a l'esquerra
        if ((input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) && x >= 0){
            x -= velocidad;
        }
        //En cas de que sigui fletxa a la dreta o D es moura 4 pixels a la dreta
        if ((input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) && x <= 950) {
            x += velocidad;
        }

        if (input.isKeyDown(Input.KEY_ESCAPE)){
            gameContainer.exit();
        }



        score++;

        velocidad += 0.001;

    }

    void render(GameContainer gameContainer, Graphics graphics){
        //Mostram la puntiació del jugador
        graphics.drawString("Score : " + score,750,10);
        //Cream el personatge
        Circle c = new Circle(0,0,25,50);
        //Definim la seva posició
        c.setX(x);
        c.setY(y);
        //Dibuixam a l'usuari
        graphics.draw(c);



    }



}
