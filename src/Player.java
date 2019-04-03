import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;

//Definirem el jugador
public class Player {
    //puntuació del jugador
    static int score = 0;
    //Altura del jugador
    int y = 500;
    //Posicio horitzontal del jugador
    int x = 550;
    //Icona del personatge
    private Image img;

    static Circle c;

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

        velocidad += 0.002;

    }

    void render(GameContainer gameContainer, Graphics graphics){
        //Mostram la puntiació del jugador
        graphics.drawString("Score : " + score,750,10);
        graphics.drawString("Highscore : " + GameRace.highscore,750,20);
        //Cream el personatge
        c = new Circle(0,0,25,50);
        //Definim la seva posició
        c.setX(x);
        c.setY(y);
        //Dibuixam a l'usuari
        graphics.draw(c);

try {
    if (c.intersects(World.listaObstaculos.getFirst().r) || c.intersects(World.listaObstaculos.getFirst().r2)) {
        gameContainer.pause();
        Input in = gameContainer.getInput();
        GameRace.mainMusic.stop();
        graphics.drawString("Game Over press R to restart or ESC to exit",350,300);
        graphics.drawString("Your score is " + score,350,305);
        if (score>GameRace.highscore){
            GameRace.highscore=score;
        }
        score=0;
        if (in.isKeyPressed(Input.KEY_R)){
            World.listaObstaculos.clear();
            System.out.println("pulsando R");
            gameContainer.resume();
            gameContainer.reinit();
        }

        if (in.isKeyPressed(Input.KEY_ESCAPE)){
            gameContainer.exit();
        }


    }
}catch (Exception e){}
    }



}
