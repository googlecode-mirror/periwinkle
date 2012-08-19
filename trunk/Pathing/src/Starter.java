import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Starter extends BasicGame
{

	Image air;
	Image rock;
	Image player;
	Image enemyImage;
	
	
	static Charaters [] charaters = new Charaters [3];
	Player user = new Player(0, 0, 0);
	Enemy enemy  = new Enemy(288-32,288-32, 1);
	Enemy enemy1  = new Enemy(100,100, 2);
	
	public Starter(String title) 
	{
		super(title);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
		World.drawWorld(air, rock);
		
		player.draw((int)user.getPosX(), (int)user.getPosY(), 1 );
		enemyImage.draw((int)enemy.getPosX(), (int)enemy.getPosY(), 1 );
		enemyImage.draw((int)enemy1.getPosX(), (int)enemy1.getPosY(), 1 );
		
	}

	@Override
	public void init(GameContainer gc) throws SlickException 
	{
		World.CreateWorld();
		World.convertWorld();
		
		charaters[0] = user;
		charaters[1] = enemy;
		charaters[2] = enemy1;
		
		air = new Image("Resources/Air.png");
		rock = new Image("Resources/Rock.png");
		player = new Image("Resources/Player.png");
		enemyImage = new Image("resources/Enemy.png");
		
		
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException 
	{
		user.getMovement(gc);
		enemy.slickMove(user, gc);
		enemy1.slickMove(user, gc);
		
	
	}
	
	public static void main(String[] Arg) throws SlickException
	{
		AppGameContainer tester = new AppGameContainer(new Starter("pathing"));
		 tester.setDisplayMode(32 * 9, 32 * 9, false);
	     tester.setTargetFrameRate(60);
	     tester.start();
	}

}
