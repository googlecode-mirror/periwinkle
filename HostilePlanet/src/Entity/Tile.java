package Entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Tile extends Entity
{
	public Tile(String id, Vector2f position) 
	{
		super(id, position);
		
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
