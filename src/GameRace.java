import org.newdawn.slick.*;

//Cream classe principal, que té l'extensió de la llibreria de Stick2d
public class GameRace extends BasicGame {
    //Cream un jugador, i un mapa
    Player p;
    World w;
    public static final String gamename = "GTA VI";
    static Music mainMusic;
    static int highscore = 0;

//Constructor del GameRace i definim canço i el titol
    public GameRace(String title) throws SlickException {
        super(title);
        mainMusic = new Music("/src/assets/Tetris.ogg");
    }

    public static void main(String[] args) throws SlickException {

        GameRace rg = new GameRace(gamename);
        //Dimensions de la pantalla
        AppGameContainer app = new AppGameContainer(rg, 1000, 600, false);
        //Limitam els FPS a 60
        app.setTargetFrameRate(60);
        ;
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
        mainMusic.play();

        if (!mainMusic.playing()){
            mainMusic.loop();
        }

    }

    //Aquest metode fa un override i mantindrà actualitzat el joc
    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        if (!gameContainer.isPaused()) {
            w.update(gameContainer);
            p.update(gameContainer, i);
        }



    }

    //Aquest mètode fara un override dibuixarà els frames de joc per cada FPS
    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        w.render(gameContainer, graphics);
        p.render(gameContainer, graphics);



    }
}
