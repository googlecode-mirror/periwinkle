package Entity.movementbehavior;

import org.newdawn.slick.geom.Vector2f;

public interface MovementBehavior 
{	
	public Vector2f calculateNextPosition(Vector2f currentPosition);
}
