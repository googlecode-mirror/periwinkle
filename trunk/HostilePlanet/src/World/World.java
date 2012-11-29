package World;

import java.util.LinkedList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import Entity.Entity;
import Entity.Player;


/**
 * @author C. Fox
 * 
 * The World class acts as an overseer for all events and actions happening in the game world at
 * any instance in time.
 */
public class World 
{
	ViewArea screen;
	public Map Map = new Map(this);
	Player player;

	LinkedList<Entity> toRemove = new LinkedList<Entity>();
	LinkedList<Entity> toAdd = new LinkedList<Entity>();
	
	Layer rLayers[] = new Layer[3];
	
	public World() throws SlickException
	{
		init();
	}
	
	public void init()
	{
		player = new Player(this, "player", new Vector2f(100, 100));
		screen = new ViewArea(player);
		
		rLayers[0] = new Layer("bg");
		rLayers[1] = new Layer("mg"); //this one is being checked for collisions
		rLayers[2] = new Layer("fg");
		
		for (int i = 0; i < 500; i++)
		{
			if (Map.layer0[i] != null)
			{
				rLayers[0].entities.add(Map.layer0[i]);
			}
		}
		
		rLayers[1].entities.add(player);
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
	 * all game logic goes here
	 * *NOTE* ALL ENTITIES IN WORLD MUST UPDATE!!!!! OR ElSE BAD THINGS HAPPEN!
	 * @param gc
	 */
	public void update(GameContainer gc)
	{
		screen.update();
		
		rLayers[0].update(gc, screen);
		rLayers[1].update(gc, screen);
		
		//add new entities to world
		for (Entity e : toAdd)
		{
			rLayers[1].entities.add(e);
		}
		toAdd.clear();
	}
	
	public void checkCollisions(Entity[] arr)
	{
		for (Entity e : arr)
		{
			
		}
	}
	
	/**
	public void resolveCollisions(Layer cl)
	{
		for (Entity e : cl.active)
		{
			for (Entity t : cl.active)
			{
				if (e.hit(t))
				{
					
				}
			}
		}
	}**/
	
	/**
	 * only render entities that are within the view area + margin
	 */
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr)
	{	
		for (Entity e : rLayers[0].entities)
		{
			e.render(gc, sb, gr);
		}
		
		for (Entity e : rLayers[1].entities)
		{
			e.render(gc, sb, gr);
		}
		
		for (Entity e : rLayers[2].entities)
		{
			e.render(gc, sb, gr);
		}
	}
	
	public void switchMap(GameContainer gc)
	{
		Map.loadMap(this);
		
		LinkedList<Entity> currentEntities = new LinkedList<Entity>();
		
		for (Entity e : rLayers[1].entities)
		{
			if(e != player)
			{
				currentEntities.add(e);
			}
		}
		
		player = new Player(this, "player", new Vector2f(100, 100));
		screen = new ViewArea(player);
		
		rLayers[0] = new Layer("bg");
		rLayers[1] = new Layer("mg"); //this one is being checked for collisions
		rLayers[2] = new Layer("fg");
	
		
		for (int i = 0; i < 500; i++)
		{
			if (Map.layer0[i] != null)
			{
				rLayers[0].entities.add(Map.layer0[i]);
			}
		}
		
		rLayers[1].entities.add(player);
		
		for (Entity e : currentEntities)
		{
			toAdd.add(e);
		}
		
		
	}
}
