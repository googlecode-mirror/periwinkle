package Entity.hitbox;

import org.newdawn.slick.geom.Vector2f;

public abstract class Hitbox 
{
	Vector2f position;
	
	Vector2f[] corners;
	
	public Vector2f getCorner(int index)
	{
		return corners[index];
	}
	
	public Vector2f[] getCorners()
	{
		return corners;
	}
}
