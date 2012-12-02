package Entity.hitbox;

import org.newdawn.slick.geom.Vector2f;

public class RectangleHitbox extends Hitbox
{
	public RectangleHitbox(Vector2f coord, int width, int height)
	{
		position = coord;
		
		corners[1] = coord;
		corners[2] = new Vector2f(coord.x + width, coord.y);
		corners[3] = new Vector2f(coord.x + width, coord.y + height);
		corners[4] = new Vector2f(coord.x, coord.y + height);
	}
}
