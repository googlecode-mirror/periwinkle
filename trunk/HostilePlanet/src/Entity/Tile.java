package Entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import World.World;

public class Tile extends Entity
{
	public Tile(World world, String id, Vector2f position) 
	{
		super(world, id, position);
		
		try 
		{
			addComponent(new ImageRenderComponent("sand", new Image("Resources/sand (light).png")));
		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}
	}
}
