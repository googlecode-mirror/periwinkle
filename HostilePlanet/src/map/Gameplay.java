package map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import entity.Entity;
import entity.Player;


/**
 * @author C. Fox
 * 
 * The World class acts as an overseer for all events and actions happening in the game world at
 * any instance in time.
 */
public class Gameplay 
{
	private Player player;
	
	private Map maps[];
	private Map currentMap;
	
	public Gameplay()
	{
		maps = new Map[500];
		currentMap = new Map();
	}
	
	protected void init() throws SlickException
	{
		
	}

	/**
	 * update the map
	 * @param gc
	 */
	protected void update(GameContainer gc)
	{
		currentMap.update(gc);
	}
	
	/**
	 * render the map
	 */
	protected void render(Graphics g)
	{	
		currentMap.render(g);
	}
}
