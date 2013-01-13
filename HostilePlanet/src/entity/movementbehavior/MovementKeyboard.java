package entity.movementbehavior;

import map.ViewArea;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

import entity.Entity;

public class MovementKeyboard extends MovementBehavior
{
	public MovementKeyboard(Entity e, float s)
	{
		super(e, s);
	}
	
	public void getAction(Input input)
	{
		//up
		if (input.isKeyDown(Input.KEY_W))
		{
			speed.y -= (speedScale + speed.y) / accelScale;
		}
		
		//down
		else if (input.isKeyDown(Input.KEY_S))
		{
			speed.y += (speedScale - speed.y) / accelScale;
		}
		
		//left
		if (input.isKeyDown(Input.KEY_A))
		{
			speed.x -= (speedScale + speed.x) / accelScale;
		}
		
		//right
		else if (input.isKeyDown(Input.KEY_D))
		{
			speed.x += (speedScale - speed.x) / accelScale;
		}	
	}
	
	public void update(GameContainer gc, ViewArea screen)
	{
		getAction(gc.getInput());
		move(screen);
	}
	
	@Override
	public Vector2f calculateNextPosition(Vector2f currentPosition) 
	{
		return null;
	}

	
}
