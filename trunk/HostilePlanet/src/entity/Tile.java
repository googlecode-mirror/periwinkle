package entity;

import map.Game;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;


public class Tile extends Entity
{
	public Tile(String id, Vector2f position) throws SlickException 
	{
		super(id, position);
		
		r = new ImageRenderer(this, id, Game.rm.sand);
	}
}
