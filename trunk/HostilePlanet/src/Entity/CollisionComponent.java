package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class CollisionComponent extends Component 
{
	Shape hitbox;
	
	public CollisionComponent(Entity e, Shape s)
	{
		hitbox = s;
	}
	
	public boolean isHit(Shape h)
	{
		return hitbox.intersects(h);
	}

	public void update(GameContainer gc, StateBasedGame sb) 
	{
		
	}
}
