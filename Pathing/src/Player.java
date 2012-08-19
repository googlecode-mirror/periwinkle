import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

/*
 * this is the class for the player charater. 
 * it has all the methods from the charaters class but also
 * has the method that moves based on user input 
 */
public class Player extends Charaters 
{

	public Player(int posX, int posY, int arrayPosition) 
	{
		super(posX, posY,arrayPosition);
	}
	
	public void getMovement(GameContainer gc)
	{
		
		int movementSpeed = 2; //faster the the enemy for testing
		
		Input userInput = gc.getInput();
		
		if(userInput.isKeyDown(Input.KEY_A))
		{
			setPosX(getPosX() - movementSpeed);
			
			//checks upper and lower left corners
			if(World.isPassable((getPosX()) / 32, (getPosY()) / 32) == true ||
					World.isPassable((getPosX()) / 32, (getPosY() + 30) / 32) == true)
			{
				setPosX(getPosX() + movementSpeed);
			}
		}
		
		if(userInput.isKeyDown(Input.KEY_D))
		{
			setPosX(getPosX() + movementSpeed);
			
			// checks the upper and lower right corners
			if(World.isPassable((getPosX() + 30 / 32), (getPosY()) / 30) == true ||
					World.isPassable((getPosX() + 30) / 32, (getPosY() + 30) / 32) == true)
			{
				setPosX(getPosX() - movementSpeed);
			}
		}
		
		if(userInput.isKeyDown(Input.KEY_W))
		{
			setPosY(getPosY() - movementSpeed);
			
			//checks upper left and right corners
			if(World.isPassable((getPosX()) / 32, (getPosY()) / 32) == true ||
					World.isPassable((getPosX() + 30) / 32, (getPosY()) / 30) == true)
			{
				setPosY(getPosY() + movementSpeed);
			}
		}
		
		if(userInput.isKeyDown(Input.KEY_S))
		{
			setPosY(getPosY() + movementSpeed);
			
			// checks lower left and right corners
			if(World.isPassable((getPosX()) / 32, (getPosY() + 30) / 32) == true ||
					World.isPassable((getPosX() + 32) / 32, (getPosY() + 30) / 32) == true)
			{
				setPosY(getPosY() - movementSpeed);
			}
		}
		
		if(getPosX() >= 8*32)
		{
			setPosX(8*32);
		}
		
		if(getPosX() <= 0)
		{
			setPosX(0);
		}
		
		if(getPosY() >= 8*32)
		{
			setPosY(8*32);
		}
		
		if(getPosY() <= 0)
		{
			setPosY(0);
		}
	}
}
