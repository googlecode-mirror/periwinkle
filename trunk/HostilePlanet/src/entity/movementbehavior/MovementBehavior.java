package entity.movementbehavior;

import map.ViewArea;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;

import entity.Entity;

public abstract class MovementBehavior 
{	
	protected Entity owner;
	public Vector2f speed;
	public Vector2f speedLimit;
	protected double speedScale;
	protected double accelScale;
	
	
	public MovementBehavior(Entity e, float s)
	{
		owner = e;
		
		speedScale = s;
		accelScale = 50;
		speed = new Vector2f(0, 0);
	}
	
	public Vector2f calculateNextPosition(Vector2f currentPosition)
	{
		float  ySpeed = (float) (speedScale * Math.sin(Math.toRadians(speed.y)));
		float xSpeed = (float) (speedScale * Math.cos(Math.toRadians(speed.x)));
		
		Vector2f nextPosition = new Vector2f(currentPosition.x + xSpeed, currentPosition.y + ySpeed);
		
		return nextPosition;
	}
	
	/**
	 * adds the speed of the movement behavior to the owner's position
	 */
	public void move(ViewArea screen)
	{
		owner.setX(owner.getX() + speed.x + screen.x);
		owner.setY(owner.getY() + speed.y + screen.y);
	}
	
	public void update(GameContainer gc, ViewArea screen)
	{
		move(screen);
	}
}
