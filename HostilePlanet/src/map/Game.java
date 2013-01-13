package map;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;


public class Game extends BasicGame
{
	public static int height = 720;
	public static int width = 1280;
	
	public static ResourceManager rm;
	
	Gameplay gp;
	
	public Game()
	{
		super("Hostile Planet");
	}

	public void init(GameContainer gc) throws SlickException
	{	
		rm = new ResourceManager();
		gp = new Gameplay();
		
		gc.setMouseCursor("Resources/crosshair.png", 16, 16);
		//Music mySong = new Music("Resources/track1.ogg");
		//mySong.loop();

		gp.init();
	}

	public void update(GameContainer gc, int delta) throws SlickException 
	{
		gp.update(gc);
	}

	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		gp.render(g);
	}
	
	public static void main(String[] args) throws SlickException
	{	
		AppGameContainer app = new AppGameContainer(new Game());
 
		app.setTargetFrameRate(128);
		app.setSmoothDeltas(false);
		app.setVSync(false);
        app.setDisplayMode(800, 600, false);

        app.start();
	}
}
