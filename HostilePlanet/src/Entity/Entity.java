package Entity;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import Entity.hitbox.Hitbox;

import World.ViewArea;
import World.World;

/**
 * 
 * @author C. Fox
 *
 * An entity object is any individual object, creature or player in the game world.
 * (So basically everything)
 */
public abstract class Entity 
{
	String id;
	
	public Hitbox hitbox;
	public World world;
	public Vector2f position;
	public Vector2f speed;
	
	float rotation;
	float scale;
	public int width = 64, 
		       height = 64;
	
	public double xSpeed;
	public double ySpeed;
	double speedScale;
	
	Input userInput = new Input(0);
	
	RenderComponent renderComponent = null;
	ArrayList<Component> components = new ArrayList<Component>();

	public Entity(World world, String id, Vector2f position)
	{	
		this.world = world;
		
		this.id = id;
		this.position = position;
		
		scale = 1;
		rotation = 0;
	}
	
    public void addComponent(Component component)
    {
        if(RenderComponent.class.isInstance(component))
            renderComponent = (RenderComponent) component;
 
        component.setOwnerEntity(this);
        components.add(component);
    }
 
    public Component getComponent(String id)
    {
        for(Component comp : components)
        {
        	if (comp.getId().equalsIgnoreCase(id))
        		return comp;
        }
 
        return null;
    }
 
    public float getScale()
    {
    	return scale;
    }
 
    public float getRotation()
    {
    	return rotation;
    }
 
    public String getId()
    {
    	return id;
    }
 
    public void setPosition(Vector2f position) 
    {
    	this.position = position;
    }
 
    public void setRotation(float rotate) 
    {
        rotation = rotate;
    }
 
    public void setScale(float scale) 
    {
    	this.scale = scale;
    }
    
    public void move(ViewArea screen)
    {
    	position.x += screen.x + xSpeed;
    	position.y += screen.y + ySpeed;
    }
    
    /**
    public boolean hit(Entity e)
    {
    	return hitbox.intersects(e.hitbox);
    }**/
 
    public void update(GameContainer gc, StateBasedGame sb, ViewArea screen)
    {
    	move(screen);
    	
        for(Component component : components)
        {
            component.update(gc, sb);
        }
    }
 
    public void render(GameContainer gc, StateBasedGame sb, Graphics gr)
    {
        if(renderComponent != null)
            renderComponent.render(gc, sb, gr);
    }
}
