package entity;

import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;

/**
 * 
 * @author CFox
 *
 * A Hitbox aids collision detection between entities by keeping track of the bounding area for
 * said entity and calculating collisions between hitboxes.
 */
public class Hitbox 
{
	public Shape area;
	
	/**
	 * create a hitbox out of an array of points
	 * @param loc
	 * @param pointArray
	 */
	public Hitbox(Vector2f loc, float[] points)
	{	
		area = new Polygon(points);
		area.setLocation(loc);
	}
	
	/**
	 * create a rectangular hitbox with a given width and height
	 * @param loc
	 * @param width
	 * @param height
	 */
	public Hitbox(Vector2f loc, int width, int height)
	{
		area = new Rectangle(loc.x, loc.y, width, height);
	}
	
	/**
	 * rotates the hitbox by the given amount theta.
	 * @param theta
	 */
	public void rotate(float theta)
	{
		area.transform(Transform.createRotateTransform(theta));
	}
	
	/**
	 * scale the hitbox by the given scaling factor.
	 * @param factor
	 */
	public void scale(float xFactor, float yFactor)
	{
		area.transform(Transform.createScaleTransform(xFactor, yFactor));
	}
	
	/**
	 * checks if the hitbox is intersecting another
	 * @param other
	 */
	public boolean intersects(Hitbox other)
	{
		return area.intersects(other.area);
	}
}
