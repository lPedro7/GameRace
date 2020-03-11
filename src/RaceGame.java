import org.newdawn.slick.*;

//Cream classe principal, que té l'extensió de la llibreria de Stick2d
public class RaceGame extends BasicGame {
    //Cream un jugador, i un mapa
    Player p;
    World w;
    //Definim el nom del joc, la cançó que sonarà de fons i el rècord de puntuació
    public static final String gamename = "RaceGame";
    static Music mainMusic;
    static int highscore = 0;

    //Constructor del RaceGame i definim canço i el titol
    public RaceGame(String title) throws SlickException {
        super(title);
        mainMusic = new Music("/src/assets/Tetris.ogg");
    }

    public static void main(String[] args) throws SlickException {


        //Cream un nou joc
        RaceGame rg = new RaceGame(gamename);
        //Dimensions de la pantalla
        AppGameContainer app = new AppGameContainer(rg, 1000, 600, false);
        //Limitam els FPS a 60
        app.setTargetFrameRate(60);

        //Inicialitzam el joc

        app.start();
    }

    //Inicialització del joc
    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        //Definim un nou jugador
        p = new Player();
        //Definim un nou mon
        w = new World();
        //Feim que soni la música i, que si s'acaba, que torni a sonar
        mainMusic.play();
        mainMusic.loop();

    }

    //Aquest metode fa un override i mantindrà actualitzat el joc
    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        //En cas de que el joc no estigui pausat, que faci l'update
        if (!gameContainer.isPaused()) {
            w.update();
            p.update(gameContainer);
        }

    }

    //Aquest mètode fara un override dibuixarà els frames de joc per cada FPS
    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        w.render(gameContainer, graphics);
        p.render(gameContainer, graphics);
    }
}
