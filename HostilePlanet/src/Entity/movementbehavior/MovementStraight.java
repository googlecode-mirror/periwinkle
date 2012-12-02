package Entity.movementbehavior;

import org.newdawn.slick.geom.Vector2f;

public class MovementStraight implements MovementBehavior
{
	public float speed;
	public int angle;
	
	public MovementStraight(float s, int theta)
	{
		speed = s;
		angle = theta;
	}
	
	public Vector2f calculateNextPosition(Vector2f currentPosition)
	{
		float  ySpeed = (float) (speed * Math.sin(Math.toRadians(angle + 90)));
		float xSpeed = (float) (speed * Math.cos(Math.toRadians(angle + 90)));
		
		Vector2f nextPosition = new Vector2f(currentPosition.x + xSpeed, currentPosition.y + ySpeed);
		
		return nextPosition;
	}
}
