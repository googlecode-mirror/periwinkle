package World;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Game extends BasicGame{
	public Input input;
	public World world1;
	public static int ScreenHeight;
	public static int ScreenWidth;
	public KeyboardShortcut kbdShortCuts;
	
	public Game(){
		super("Super Sidescrolling Adventure 1");
	}

	public void init(GameContainer gc) throws SlickException{
		ImagePreload.preloadimages();
		world1 = new World();
		kbdShortCuts = new KeyboardShortcut(world1);
	}

	public void update(GameContainer gc, int delta) throws SlickException{
		world1.update(gc);
		input = gc.getInput();
		kbdShortCuts.getKeyPressed(input);
	}

	public void render(GameContainer gc, Graphics gr) throws SlickException{
		world1.render(gc, null, gr);
	}
	
	public static void main(String[] args) throws SlickException{	
		AppGameContainer app = new AppGameContainer(new Game());
		ScreenWidth = app.getScreenWidth();
		ScreenHeight = app.getScreenHeight();
		
		app.setDisplayMode(ScreenWidth, ScreenHeight, false);
        app.setTargetFrameRate(120);
        app.start();
	}
}
