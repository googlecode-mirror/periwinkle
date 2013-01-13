package map;

import java.util.LinkedList;

import entity.Entity;
import entity.Tile;

public class MapCell 
{
	int sizeX;
	int sizeY;
	
	LinkedList<Entity> middleground;
	LinkedList<Entity> foreground;

	public MapCell()
	{
		
	}
	
	public void addToMiddle(Entity e)
	{
		middleground.add(e);
	}
	
	public void addToFront(Entity e)
	{
		foreground.add(e);
	}
	
	public void removeFromMiddle(Entity e)
	{
		middleground.remove(e);
	}
	
	public void removeFromFront(Entity e)
	{
		foreground.remove(e);
	}
}
