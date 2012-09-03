import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Main extends BasicGame
{
	Image masterImage;
	int windowWidth = 800;
	int windowHeigth = 640;

	static StringDrawer stringDrawer = new StringDrawer();
	
	public Main(String title)
	{
		super(title);
	}

	@Override
	public void render(GameContainer gc, Graphics arg1) throws SlickException
	{
		
		stringDrawer.drawRenderArray();
			}

	@Override
	public void init(GameContainer arg0) throws SlickException
	{
		masterImage = new Image("Resources/Letters.png");
		
		stringDrawer.createArray(masterImage);
		
		stringDrawer.addChar('C', 200, 100, 1, 8, stringDrawer);
		stringDrawer.addChar('a', 207, 100, 1, 8.5, stringDrawer);
		stringDrawer.addChar('t', 214, 100, 1, 9, stringDrawer);
		
		stringDrawer.requestString("The Cat below is drawn with single chars", 175, 75, 2 , 5, .5, 190, stringDrawer);
		stringDrawer.requestString("This will go away after 8 secs", 300, 300, 3 , 8, 0, 190, stringDrawer);
		stringDrawer.requestString("This will start going away after 8 secs", 300, 325, 2 , 8, .5, 265, stringDrawer);
		stringDrawer.requestString("This will never go away", 300, 350, 170,  stringDrawer);
	}

	@Override
	public void update(GameContainer gc, int arg1) throws SlickException
	{
		stringDrawer.checkDisplayTime(gc);
	}
	
	public static void main(String[] Arg) throws SlickException
	{
		AppGameContainer game = new AppGameContainer(new Main("Words!!"));
		game.setDisplayMode(800, 640, false);
		game.setTargetFrameRate(60);
		//game.setShowFPS(false);
		game.start();
	}
}
