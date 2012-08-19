import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.pathfinding.Path;

/*
 * this class is the base class for all the charaters in the project. it has the 2 move methods
 */
public class Charaters
{
	private int posX;
	private int posY;
	
	private int previousX;
	private int previousY;
	
	
	private int arrayPosition;
	
	private boolean firstRun = true;
	
	private int refreshPath = 0;
	private int currentPathStep = 1;
	private Path path = null;
	
	public Charaters(int posX, int posY, int arrayPosition)
	{
		this.posX = posX;
		this.posY = posY;
		this.setArrayPosition(arrayPosition);
	}
	
	public void setPosX(int posX) 
	{
		this.posX = posX;
	}

	public int getPosX() 
	{
		return posX;
	}

	public void setPosY(int f)
	{
		this.posY = f;
	}

	public int getPosY() 
	{
		return posY;
	}
	
	
	/*
	 * This method is the main movement method
	 *  for charters other then the player
	 */
	
	public void slickMove(Player user, GameContainer gc)
	{
		previousX = getPosX();
		previousY = getPosY();
		
		if(this.posX != user.getPosX() || this.posY != user.getPosY())
		{
			Vector2f nextMove = new Vector2f();
			
			nextMove = Pathing.slickPathing(this.posX, this.posY, user.getPosX(), user.getPosY(), gc, getArrayPosition());
			
			setPosX((int)nextMove.getX());
			setPosY((int)nextMove.getY());
			
			pathingMove(user);
			
			checkForJump(user);
		}
		
		
		
	}
	
	
	
	
	
	/*
	 * this is the move method that is used in pathing.
	 * It does not test if it hits things
	 */
	
	public void pathingMove(Player user)
	{
		//checks for collisions
		if(World.isPassable((getPosX()) / 32, (getPosY()) / 32) == true || //top left
		   World.isPassable((getPosX() + 31)/32, (getPosY())/32) == true) //top right
		{
			setPosX(previousX);
			setPosY(previousY);
			
			if(this.posX > user.getPosX())
			{
				setPosX(getPosX() - 1);
			}
			
			if(this.posX < user.getPosX())
			{
				setPosX(getPosX() + 1);
			}
			
			if(this.posX == user.getPosX())
			{
				setPosX(getPosX() - 1);
			}
		}
		
		if(World.isPassable((getPosX()) / 32, (getPosY()+ 31) / 32) == true || //bottom left
		   World.isPassable((getPosX() + 31)/32, (getPosY() + 31)/32) == true) //bottom right
		{
			setPosX(previousX);
			setPosY(previousY);
			
			if(this.posX > user.getPosX())
			{
				setPosX(getPosX() - 1);
			}
			
			if(this.posX < user.getPosX())
			{
				setPosX(getPosX() + 1);
			}
			
			if(this.posX == user.getPosX())
			{
				setPosX(getPosX() - 1);
			}
		}
		
		
		if(World.isPassable((getPosX() + 31) / 32, (getPosY()+ 31) / 32) == true || //bottom left
		   World.isPassable((getPosX() + 31)/32, (getPosY())/32) == true) //top right
		{
			setPosX(previousX);
			setPosY(previousY);
			
			if(this.posY > user.getPosY())
			{
				setPosY(getPosY() - 1);
			}
			
			if(this.posY < user.getPosY())
			{
				setPosY(getPosY() + 1);
			}
			
			if(this.posY == user.getPosY())
			{
				setPosY(getPosY() - 1);
			}
		}
		
		if(World.isPassable((getPosX()) / 32, (getPosY()+ 31) / 32) == true || //bottom left
		   World.isPassable((getPosX())/32, (getPosY())/32) == true) //top right
		{
			setPosX(previousX);
			setPosY(previousY);
			
			if(this.posY > user.getPosY())
			{
				setPosY(getPosY() - 1);
			}
			
			if(this.posY < user.getPosY())
			{
				setPosY(getPosY() + 1);
			}
			
			if(this.posY == user.getPosY())
			{
				setPosY(getPosY() - 1);
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
	
	
	public void checkForJump(Player user)
	{
		
		int traveledDistance;
		
		Vector2f firstPos = new Vector2f(previousX, previousY);
		
		Vector2f secondPos = new Vector2f(this.posX, this.posY);
		
		traveledDistance = (int) firstPos.distance(secondPos);
		
		if(traveledDistance > 4)
		{
			setPosX(previousX);
			setPosY(previousY);
			
			if (this.posX > user.getPosX())
			{
				setPosX(this.posX - 1);
			}
			
			if (this.posY > user.getPosY())
			{
				setPosY(this.posY - 1);
			}
		}
		
		
	}
	
	public void setPath(Path path) {
		this.path = path;
	}

	public Path getPath() {
		return path;
	}

	public void setArrayPosition(int arrayPosition) {
		this.arrayPosition = arrayPosition;
	}

	public int getArrayPosition() {
		return arrayPosition;
	}

	public void setCurrentPathStep(int currentPathStep) {
		this.currentPathStep = currentPathStep;
	}

	public int getCurrentPathStep() {
		return currentPathStep;
	}

	public void setRefreshPath(int refreshPath) {
		this.refreshPath = refreshPath;
	}

	public int getRefreshPath() {
		return refreshPath;
	}

	public void setFirstRun(boolean firstRun) {
		this.firstRun = firstRun;
	}

	public boolean isFirstRun() {
		return firstRun;
	}
}
	




