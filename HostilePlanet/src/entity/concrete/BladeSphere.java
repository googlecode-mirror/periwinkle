package entity.concrete;

import map.Gameplay;
import map.ViewArea;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import entity.Entity;
import entity.ImageRenderer;


public class BladeSphere extends Entity
{
	int spin;
	Entity target;
	
	public BladeSphere(String id, Vector2f position, int rotationSpeed, Entity target) 
	{
		super(id, position);
		
		try 
		{
			r= new ImageRenderer(this, "image", new Image("Resources/Blade Sphere.png", false, Image.FILTER_NEAREST));
		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}
		
		spin = rotationSpeed;
		speedScale = 2;
		
		this.target = target;
		
		destroy();
	}
	
	public void follow(Entity e)
	{
		if (position.x < e.position.x)
		{
			speed.x += 0.03;
		}
		
		else
		{
			speed.x += -0.03;
		}
		
		if (position.y < e.position.y)
		{
			speed.y += 0.03;
		}
		
		else
		{
			speed.y += -0.03;
		}
		
		if (speed.x > speedScale)
		{
			speed.x = (float) speedScale;
		}
		
		else if (speed.y < -speedScale)
		{
			speed.x = (float) -speedScale;
		}
		
		if (speed.y > speedScale)
		{
			speed.y = (float) speedScale;
		}
		
		else if (speed.y < -speedScale)
		{
			speed.y = (float) -speedScale;
		}
	}
	
	public void stopFollowing()
	{
		speed.x = 0;
		speed.y = 0;
	}
	
	public void destroy()
	{
		r.fadeOut(.0001f);
	}
	
	public void update(GameContainer gc, StateBasedGame sb, ViewArea screen)
	{
		super.update(gc, sb, screen);
		
		rotation += spin;
		follow(target);
	}
}
