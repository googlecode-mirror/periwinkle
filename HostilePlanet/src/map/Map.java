package map;

import java.util.LinkedList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

import entity.Entity;
import entity.Player;
import entity.Tile;


/**
 * 
 * @author C. Fox
 *
 * The map class contains all functionality for getting, setting and rendering all tiles in
 * a given map object
 */
public class Map
{
	int gridWidth;
	int gridHeight;
	
	ViewArea screen;
	
	Player player;
	
	MapCell[] grid;
	
	MapLayer[] mapLayers;
	
	LinkedList<Entity> toRemove = new LinkedList<Entity>();
	LinkedList<Entity> toAdd = new LinkedList<Entity>();
	
	/**
	 * default constructor creates a generic test map.
	 * <do not use in final version>
	 */
	public Map()
	{
		mapLayers = new MapLayer[2];
		mapLayers[0] = new TileLayer("ground layer", 25, 19);
		mapLayers[1] = new MapLayer("middle layer");
		//mapLayers[2] = new MapLayer("top layer");
		
		//screen = new ViewArea(player);
		init();
	}
	
	public void init()
	{
		mapLayers[0].init();
		
		player = new Player("player", new Vector2f(100, 100));
		mapLayers[1].entities.add(player);
		
		screen = new ViewArea(player);
	}
	
	public void add(Entity e)
	{
		toAdd.add(e);
	}
	
	public void remove(Entity e)
	{
		toRemove.remove(e);
	}
	
	/**
	 * updates all entities in the map
	 */
	public void update(GameContainer gc)
	{
		for (MapLayer l : mapLayers)
		{
			l.update(gc, screen);
		}
	}
	
	/**
	 * render all entities in the map
	 */
	public void render(Graphics g)
	{
		for (MapLayer l : mapLayers)
		{
			l.render(g);
		}
	}
}
