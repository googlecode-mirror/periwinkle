package entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class ImageRenderer
{
	Entity owner;
	int scale;
	
	String id;
	Image image;
	 
	public ImageRenderer(Entity myOwner, String id, Image image)
	{
		this.image = image;
		owner = myOwner;
		
		scale = 1;
	}
	
	public void fadeOut(float multiplier)
	{
		image.setAlpha(image.getAlpha() + multiplier);
	}
	
	public void fadeIn(float multiplier)
	{
		image.setAlpha(image.getAlpha() - multiplier);
	}
 
	/**
	 * render the image to the graphics object g
	 * @param g
	 */
	public void render(Graphics g) 
	{
		Vector2f pos = owner.getPosition();
 
		//image.rotate((float) (owner.getRotation() - image.getRotation())); redundant code
		image.draw(pos.x, pos.y, scale);
	}
 
	/**
	 * update the image. Mainly used for dynamic rotating and scaling of the image.
	 * @param gc
	 * @param sb
	 */
	public void update(GameContainer gc, StateBasedGame sb) 
	{
		image.rotate((float) (owner.getRotation() - image.getRotation()));
	}

	/**
	 * retrieve the scale of the image at the current frame.
	 * @return
	 */
	public float getScale() 
	{
		return scale;
	}
}
