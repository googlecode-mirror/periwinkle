package Entity.movementbehavior;

import org.newdawn.slick.geom.Vector2f;

import Entity.Entity;

public class MovementFollow implements MovementBehavior
{

	public Vector2f calculateNextPosition(Vector2f currentPosition, Entity target) 
	{
		if (position.x < e.position.x)
		{
			xSpeed += 0.03;
		}
		
		else
		{
			xSpeed += -0.03;
		}
		
		if (position.y < e.position.y)
		{
			ySpeed += 0.03;
		}
		
		else
		{
			ySpeed += -0.03;
		}
		
		if (xSpeed > speedScale)
		{
			xSpeed = speedScale;
		}
		
		else if (xSpeed < -speedScale)
		{
			xSpeed = -speedScale;
		}
		
		if (ySpeed > speedScale)
		{
			ySpeed = speedScale;
		}
		
		else if (ySpeed < -speedScale)
		{
			ySpeed = -speedScale;
		}
		return null;
	}

}
