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
	Map testMap = new Map(this);
	Player player;

	ArrayList<Entity> toRemove = new ArrayList<Entity>();
	ArrayList<Entity> toAdd = new ArrayList<Entity>();
	ArrayList<Entity> actives = new ArrayList<Entity>();
	Entity[] renderQueue = new Entity[(Game.width / 32) * (Game.height / 32) + 1];
	
	public World() throws SlickException
	{
		player = new Player(this, "player", new Vector2f(100, 100));
		screen = new ViewArea(player);
		
		for (int i = 0; i < 500; i++)
		{
			if (testMap.layer0[i] != null)
			{
				renderQueue[i] = testMap.layer0[i];
			}
		}
		
		actives.add(player);
	}
	
	public void init()
	{
		
	}

	public void add(Entity e) //adding while iterating through actives causes con-mod-exception
	{
		toAdd.add(e);
	}
	
	public void remove(Entity e)
	{
		toRemove.remove(e);
	}
	
	/**
	 * all game logic goes here
	 * *NOTE* ALL ENTITIES IN WORLD MUST UPDATE!!!!! OR ElSE BAD THINGS HAPPEN!
	 * @param gc
	 */
	public void update(GameContainer gc)
	{
		screen.update();
		
		for (Entity e : renderQueue)
		{
			if (e != null)
			{
				e.update(gc, null, screen);
			}
		}
		
		for (Entity e : actives)
		{
			e.update(gc, null, screen);
		}
		
		//add new entities to world
		for (Entity e : toAdd)
		{
			actives.add(e);
		}
		toAdd.clear();
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
		
		for (Entity e : actives)
		{
			e.render(gc, sb, gr);
		}
	}
}
