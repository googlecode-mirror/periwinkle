package World;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;

import Entity.Entity;


public class Layer
{	
	public String id;
	
	ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public Layer(String id)
	{
		this.id = id;
	}

	public void update(GameContainer gc, ViewArea screen)
	{	
		resolveCollisions();
		
		for (Entity e : entities)
		{
			e.update(gc, null, screen);
		}
		
		System.out.println(entities.size());
	}
	
	public void resolveCollisions()
	{
		for (int i = 0; i < entities.size(); i++)
		{
			for (int j = i + 1; j < entities.size(); j++)
			{
				Entity focus = entities.get(i);
				Entity target = entities.get(j);
				
				
				if (checkForHit(focus, target))
				{
					focus.xSpeed = -focus.xSpeed;
					focus.ySpeed = -focus.ySpeed;
					target.xSpeed = -target.xSpeed;
					target.ySpeed = -target.ySpeed;
				}
				/**
				if (checkTop(focus, target))
				{
					focus.ySpeed += 1;
					target.ySpeed += -1;
				}
				
				if (checkLeft(focus, target))
				{
					focus.xSpeed += 1;
					target.xSpeed += -1;
				}
				
				if (checkBottom(focus, target))
				{
					focus.ySpeed += -5;
					target.ySpeed += 5;
				}
				
				if (checkRight(focus, target))
				{
					focus.xSpeed += -5;
					target.xSpeed += 5;
				}**/
			}
		}
	}
	
	public boolean checkForHit(Entity focus, Entity target)
	{
		boolean isHit = false;
		
		if (focus.position.y <= target.position.y + target.height 
				&& focus.position.y >= target.position.y
				&& focus.position.x >= target.position.x
				&& focus.position.x <= target.position.x + target.width)
		{
			isHit = true;
		}
		
		return isHit;
	}
	/**
	public boolean checkTop(Entity focus, Entity target)
	{
		if (focus.position.y <= target.position.y + target.height 
				&& focus.position.y >= target.position.y)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public boolean checkLeft(Entity focus, Entity target)
	{
		if (focus.position.x <= target.position.x + target.width 
				&& focus.position.x + focus.width > target.position.x + target.width)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public boolean checkBottom(Entity focus, Entity target)
	{
		if (focus.position.y + focus.height > target.position.y
				&& focus.position.y + focus.height >= target.position.y + target.height)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public boolean checkRight(Entity focus, Entity target) //unfinished
	{
		if (focus.position.y + focus.height > target.position.y
				&& focus.position.y + focus.height >= target.position.y + target.height)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}**/
}
