package entity;



import map.ViewArea;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import entity.movementbehavior.MovementBehavior;


/**
 * 
 * @author C. Fox
 *
 * An entity object is any individual object, creature or player in the game world.
 * (So basically everything)
 */
public abstract class Entity 
{
	private String id;
	
	protected Vector2f position;
	
	protected MovementBehavior mb;
	protected Hitbox hitbox;
	protected ImageRenderer r;

	public Entity(String id, Vector2f position)
	{	
		this.id = id;
		this.position = position;
	}
 
    public float getScale()
    {
    	return r.getScale();
    }
 
    public double getRotation()
    {
    	return position.getTheta();
    }
 
    public String getId()
    {
    	return id;
    }
 
    public void setPosition(Vector2f position) 
    {
    	this.position = position;
    }
 
    public void setRotation(double rotate) 
    {
        position.setTheta(rotate);
    }
 
    public void setScale(int scale) 
    {
    	r.scale = scale;
    	hitbox.scale(scale, scale);
    }
 
    /**
     * @param gc
     * @param sb
     * @param screen
     */
    public void update(GameContainer gc, StateBasedGame sb, ViewArea screen)
    {
    	if (mb != null)
    	{
    		mb.update(gc, screen);
    	}
    	
        r.update(gc, sb);
    }
 
    public void render(Graphics g)
    {
        r.render(g);
    }

	public Vector2f getPosition() 
	{
		return position;
	}
	
	public int getRenderWidth()
	{
		return r.image.getWidth();
	}
	
	public int getRenderHeight()
	{
		return r.image.getHeight();
	}
	
	public float getX()
	{
		return position.x;
	}
	
	public float getY()
	{
		return position.y;
	}
	
	public void setX(float newX)
	{
		position.x = newX;
	}
	
	public void setY(float newY)
	{
		position.y = newY;
	}

	public Vector2f getSpeed() 
	{
		return mb.speed;
	}
}
