
/*
 * this is the enemy class. it uses all 
 * the methods from the charater class
 */
public class Enemy extends Charaters 
{
	int previousX;
	int previousY;
	
	public Enemy(int posX, int posY, int arrayPosition) 
	{
		super(posX, posY, arrayPosition);
	}
}
