package World;


import Entity.Entity;

/**
 * 
 * @author C. Fox
 * 
 * 
 */
public class ViewArea 
{
	public int x;
	public int y;
	int width;
	int height;
	Entity focus;
	
	public ViewArea(Entity focus)
	{
		this.focus = focus;
		x = 0;
		y = 0;
		width = Game.width;
		height = Game.height;
	}
	
	public void update()
	{
		float xPos = focus.getPosition().x;
		float yPos = focus.getPosition().y;
		
		if (xPos > 500)
		{
			x = -1;
		}
			
		else
			x = 0;
		
		if (yPos < 220)
		{
			y = 1;
		}
			
		else
			y = 0;
		
		if (xPos < 300)
		{
			x = 1;
		}
		
		if (yPos > 340)
		{
			y = -1;
		}
	}
}
