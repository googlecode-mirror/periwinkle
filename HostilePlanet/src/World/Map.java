package World;

import org.newdawn.slick.geom.Vector2f;

import Entity.Entity;
import Entity.Tile;

/**
 * 
 * @author C. Fox
 *
 * The map class contains all functionality for getting, setting and rendering all tiles in
 * a given map object
 */
public class Map
{
	public int width;
	public Tile[] layer0 = new Tile[500];
	public Tile[] layer1 = new Tile[10];
	
	public Map()
	{
		//temporary code for testing map
		int y = 0;
		int x = 0;
		
		for (int i = 0; i < layer0.length; i++)
		{
			y = i / 25;
			
			if (i % 25 == 0)
				x = 0;
			else
				x++;
			
			layer0[i] = new Tile("Sand", new Vector2f(x * 32, y * 32));
		}
	}
	
	public Entity tileAt(int layer, int xPos, int yPos)
	{
		int pos = (yPos / width) + xPos;
		Entity tile;
		
		if (layer == 0)
			tile = layer0[pos];
		
		else
			tile = layer1[pos];
		
		return tile;
	}
	
	public void setTile(int layer, int xPos, int yPos, Tile newTile)
	{
		
	}
	
	public void loadMap()
	{
		
	}
}
