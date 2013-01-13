package map;


import java.util.LinkedList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import entity.Entity;

/**
 * 
 * @author CFox
 *
 * A layer of a map. Allows for multiple planes of entities to overlap each other
 * during gameplay without causing collisions.
 */
public class MapLayer
{	
	public String id;
	
	LinkedList<Entity> entities = new LinkedList<Entity>(); //a list of all entities in the layer
	
	public MapLayer(String id)
	{
		this.id = id;
	}
	
	public void init()
	{
		
	}

	public void update(GameContainer gc, ViewArea screen)
	{	
		resolveCollisions();
		
		for (Entity e : entities)
		{
			e.update(gc, null, screen);
		}
	}
	
	public void render(Graphics g)
	{
		 for (Entity e : entities)
		 {
			 e.render(g);
		 }
	}
	
	public void resolveCollisions()
	{
		
	}
}
