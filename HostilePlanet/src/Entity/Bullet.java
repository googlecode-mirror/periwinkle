package Entity;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import World.World;

public class Bullet extends Entity
{	
	public Bullet(World world, String id, Vector2f position, int speed, float direction) 
	{
		
		super(world, id, position);
	
		rotation = direction;
		
		ySpeed = speed * Math.sin(Math.toRadians(rotation + 90));
		xSpeed = speed * Math.cos(Math.toRadians(rotation + 90));
		
		try 
		{
			addComponent(new ImageRenderComponent("bullet", new Image("Resources/bullet.png", false, Image.FILTER_NEAREST)));
		}
		catch (SlickException e) 
		{
			e.printStackTrace();
		}
	}
}
