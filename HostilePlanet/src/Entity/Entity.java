package Entity;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import World.Game;
import World.ViewArea;
import World.World;

/**
 * 
 * @author C. Fox
 *
 * An entity object is any individual object, creature or player in the game world.
 * (So basically everything)
 */
public class Entity 
{
	String id;
	
	Vector2f position;
	float rotation;
	float scale;
	
	Input userInput = new Input(0);
	
	RenderComponent renderComponent = null;
	ArrayList<Component> components = new ArrayList<Component>();

	public Entity(String id, Vector2f position)
	{
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
 
    public Vector2f getPosition()
    {
    	return position;
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
 
    public void update(GameContainer gc, StateBasedGame sb, ViewArea screen)
    {  	   
    	position.x += screen.x;
    	position.y += screen.y;
    	
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
