package World;

import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.openal.SoundStore;


public class Game extends BasicGame
{
	public World myWorld;
	public static int height = 720;
	public static int width = 1280;
	
	public Music myMusic;
	
	public Game() 
	{
		super("Hostile Planet");
	}

	public void init(GameContainer gc) throws SlickException
	{
		myWorld = new World();
//		
//		myMusic = new Music("Resources/stone4.ogg");
//		myMusic.loop();
	
		
		gc.setMouseCursor("Resources/crosshair.png", 16, 16);
	}

	public void update(GameContainer gc, int delta) throws SlickException 
	{
		myWorld.update(gc);
	}

	public void render(GameContainer gc, Graphics gr) throws SlickException
	{
		myWorld.render(gc, null, gr);
	}
	
	public static void main(String[] args) throws SlickException
	{	
		AppGameContainer app = new AppGameContainer(new Game());
 
		app.setTargetFrameRate(128);
		app.setSmoothDeltas(true);
		app.setVSync(true);
        app.setDisplayMode(800, 600, false);

        app.start();
	}
}
