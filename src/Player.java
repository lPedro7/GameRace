import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;

//Definirem el jugador
public class Player {
    //puntuació del jugador
    static int score = 0;
    //Altura del jugador
    int y = 500;
    //Posicio horitzontal del jugador
    int x = 450;
    //Jugador
    static Circle c;
    //Velocitat actual del jugador
    float velocidad = 10;

    //Definim els controls que tindrà el jugador
    void update(GameContainer gameContainer) {
        //Si l'usuari pressiona un botó
        Input input = gameContainer.getInput();
        //En cas de que sigui fletxa a l'esquerra o A es moura la velocitat definida a la esquerra
        if ((input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) && x >= 0) {
            x -= velocidad;
        }
        //En cas de que sigui fletxa a la dreta o D es moura la velocitat definida a la dreta
        if ((input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) && x <= 950) {
            x += velocidad;
        }
        //Si pulsam ESC , sortim del joc
        if (input.isKeyDown(Input.KEY_ESCAPE)) {
            gameContainer.exit();
        }

        //La puntuació s'incrementa cada vegada que actualitzam el joc
        score++;
        //La velocitat aumenta gradualment segons avançam
        velocidad += 0.002;

    }

    void render(GameContainer gameContainer, Graphics graphics) {
        //Mostram la puntuació del jugador
        graphics.drawString("Score : " + score, 750, 10);
        graphics.drawString("Highscore : " + RaceGame.highscore, 750, 30);
        //Cream el personatge
        c = new Circle(0, 0, 25, 50);
        //Definim la seva posició
        c.setX(x);
        c.setY(y);
        //Dibuixam a l'usuari
        graphics.draw(c);

        //Feim la situació de intersecció entre el jugador i un obstacle, feim un try, perque esteim fent la comprovació
        //De que si el jugador intersecta amb el primer obstacle de la llista d'obstacles, al començament del joc, la
        //llista està buida, i ens donaria una excepció de NullPointerException
        try {
            //Comprovam si el jugador intersecta amb el primer o segon rectangle de l'obstacle
            if (c.intersects(World.listaObstaculos.getFirst().r) || c.intersects(World.listaObstaculos.getFirst().r2)) {
                //Si hi ha colisió pausam el joc
                gameContainer.pause();
                //Podem rebre un input, que serà o R o ESC
                Input in = gameContainer.getInput();
                //Pausam la musica
                RaceGame.mainMusic.stop();
                //Notificam el Game Over
                graphics.drawString("Game Over", 350, 300);
                graphics.drawString("Press R to restart or ESC to exit", 350, 335);
                graphics.drawString("Your score is " + score, 350, 370);

                //Si la puntuació actual és major a la màxima puntuació, la nostra puntuació sera la nova màxima
                if (score > RaceGame.highscore) {
                    RaceGame.highscore = score;
                }
                //Si pulsam R reiniciam el joc
                if (in.isKeyPressed(Input.KEY_R)) {
                    //Llevam tots els obstacles
                    World.listaObstaculos.clear();
                    //Reanudam el joc
                    gameContainer.resume();
                    //Tornam a cridar a init per començar el joc
                    gameContainer.reinit();
                    //Retornam la puntuacio a 0
                    score = 0;
                }
                //Si pulsam ESC sortim del joc
                if (in.isKeyPressed(Input.KEY_ESCAPE)) {
                    gameContainer.exit();
                }


            }
        } catch (Exception e) {
        }

    }
}
