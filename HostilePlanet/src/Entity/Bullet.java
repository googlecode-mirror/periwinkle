package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import World.ViewArea;
import World.World;

public class Bullet extends Entity
{	
	public Bullet(World world, String id, Vector2f position, int speed) 
	{
		super(world, id, position);
		
		this.speed = speed;
		
		try 
		{
			addComponent(new ImageRenderComponent("bullet", new Image("Resources/bullet.png")));
		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sb, ViewArea screen)
	{
		super.update(gc, sb, screen);
		
		position.y -= speed;
	}
}
