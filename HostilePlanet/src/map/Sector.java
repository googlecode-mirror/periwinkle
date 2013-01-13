package map;

import java.util.LinkedList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import entity.Entity;
import entity.Tile;

/**
 * 
 * @author C. Fox
 *
 * A Sector is a small section of the map that holds it's own tiles and knows everything existing
 * within its boundaries. Mainly used for increasing collision detection efficiency.
 */
public class Sector 
{
	int tWidth = 32;
	int tHeight = 32;
	
	int sWidth = 2;
	int sHeight = 2;
	
	LinkedList<Entity> actives;
	
	public Sector()
	{
		
	}
	
	/**
	 * updates all entities within the Sector
	 */
	public void update(GameContainer gc, StateBasedGame sb, ViewArea screen)
	{
		for(Entity e : actives)
		{
			e.update(gc, sb, screen);
		}
	}
	
	/**
	 * renders all entities and tiles within the Sector
	 */
	public void render()
	{
		
	}
}
