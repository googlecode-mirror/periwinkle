package World;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Game extends BasicGame
{
	public World one;
	public static int height = 640;
	public static int width = 800;
	
	public Game() 
	{
		super("test");
	}

	public void init(GameContainer gc) throws SlickException 
	{
		one = new World();
	}

	public void update(GameContainer gc, int delta) throws SlickException 
	{
		one.update(gc);
	}

	public void render(GameContainer gc, Graphics gr) throws SlickException
	{
		one.render(gc, null, gr);
	}
	
	public static void main(String[] args) throws SlickException
	{
		AppGameContainer app = new AppGameContainer(new Game());
 
        app.setDisplayMode(width, height, false);
        app.setTargetFrameRate(60);
        app.start();
	}
}
