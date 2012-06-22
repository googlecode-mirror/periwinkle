package World;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import Entity.Entity;
import Entity.ImageRenderComponent;
import Entity.Player;
import Entity.Tile;

/**
 * @author C. Fox
 * last edit: C. Fox
 * 
 * The World class acts as an overseer for all events and actions happening in the game world at
 * any instance in time.
 */
public class World 
{
	ViewArea screen;
	Map testMap = new Map();
	Player player;

	ArrayList<Entity> actives = new ArrayList<Entity>();
	Entity[] renderQueue = new Entity[(Game.width / 32) * (Game.height / 32) + 1];
	
	public World() throws SlickException
	{
		player = new Player("player", new Vector2f(100, 100));
		screen = new ViewArea(player);
		
		for (int i = 0; i < 500; i++)
		{
			if (testMap.layer0[i] != null)
			{
				renderQueue[i] = testMap.layer0[i];
			}
		}
		
		renderQueue[500] = player;
	}
	
	public void init()
	{
		
	}

	public void add(Entity e)
	{
		actives.add(e);
	}
	
	public void remove(Entity e)
	{
		actives.remove(e);
	}
	
	/**
	 * all game logic goes here
	 * *NOTE* ALL ENTITIES IN WORLD MUST UPDATE!!!!! OR ElSE BAD THINGS HAPPEN!
	 * @param gc
	 */
	public void update(GameContainer gc)
	{
		player.update(gc, null, screen);
		screen.update();
		
		for (Entity e : renderQueue)
		{
			if (e != null)
			{
				e.update(gc, null, screen);
			}
		}
	}
	
	/**
	 * only render entities that are within the view area + margin
	 * @param gc
	 * @param sb
	 * @param gr
	 */
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr)
	{
		for (Entity e : renderQueue)
		{
			if (e != null)
			{
				e.render(gc, sb, gr);
			}
		}
	}
}
