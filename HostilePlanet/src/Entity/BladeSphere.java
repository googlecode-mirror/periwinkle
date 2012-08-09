package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import World.ViewArea;
import World.World;

public class BladeSphere extends Entity
{
	int spin;
	Entity target;
	
	public BladeSphere(World world, String id, Vector2f position, int rotationSpeed, Entity target) 
	{
		super(world, id, position);
		
		try 
		{
			addComponent(new ImageRenderComponent("Blade Sphere", new Image("Resources/Blade Sphere.png", false, Image.FILTER_NEAREST)));
		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}
		
		spin = rotationSpeed;
		speedScale = 2;
		
		this.target = target;
	}
	
	public void follow(Entity e)
	{
		if (position.x < e.position.x)
		{
			xSpeed += 0.03;
		}
		
		else
		{
			xSpeed += -0.03;
		}
		
		if (position.y < e.position.y)
		{
			ySpeed += 0.03;
		}
		
		else
		{
			ySpeed += -0.03;
		}
		
		if (xSpeed > speedScale)
		{
			xSpeed = speedScale;
		}
		
		else if (xSpeed < -speedScale)
		{
			xSpeed = -speedScale;
		}
		
		if (ySpeed > speedScale)
		{
			ySpeed = speedScale;
		}
		
		else if (ySpeed < -speedScale)
		{
			ySpeed = -speedScale;
		}
	}
	
	public void stopFollowing()
	{
		xSpeed = 0;
		ySpeed = 0;
	}
	
	public void update(GameContainer gc, StateBasedGame sb, ViewArea screen)
	{
		super.update(gc, sb, screen);
		
		if (position.distance(target.position) < 200)
		{
			rotation += spin;
			follow(target);
		}
		
		else
		{
			stopFollowing();
		}
	}
}
